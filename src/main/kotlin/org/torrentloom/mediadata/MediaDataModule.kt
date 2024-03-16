package org.torrentloom.mediadata

import kotlinx.serialization.KSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.module.Module
import org.koin.dsl.module
import org.torrentloom.loom.Shuttle
import kotlin.reflect.KClass

typealias MediaDataFormat<T> = Pair<KClass<T>, KSerializer<T>>

abstract class MediaDataModule<M : MediaData> : KoinComponent {
    abstract val moduleIdentifier: String
    protected abstract val fetcher: MediaDataFetcher<M>
    protected abstract val parser: MediaDataParser<M>
    open val defaultModuleConfiguration: Module = module { }

    private val json: Json by inject()

    fun runModule(shuttle: Shuttle, rerun: Boolean = false): Shuttle =
        (shuttle.takeUnless { rerun || getModuleMediaData(it) == null } ?: fetchMediaData(shuttle))
            .let { parseMediaData(it) }

    private fun fetchMediaData(shuttle: Shuttle): Shuttle = when (val mediaData = fetcher.fetchData(shuttle)) {
        null -> shuttle.copy(mediaData = shuttle.mediaData.minus(moduleIdentifier))
        else -> shuttle.copy(mediaData = shuttle.mediaData.plus(moduleIdentifier to mediaData))
    }.also(::saveShuttle)

    private fun parseMediaData(shuttle: Shuttle): Shuttle = getModuleMediaData(shuttle)?.let { mediaData ->
        shuttle.copy(weft = parser.parseData(mediaData, shuttle.weft)).also(::saveShuttle)
    } ?: shuttle


    private fun saveShuttle(shuttle: Shuttle) {
        //TODO: Save the state of the shuttle
        println(json.encodeToString(shuttle))
    }

    @Suppress("UNCHECKED_CAST")
    fun getModuleMediaData(shuttle: Shuttle): M? = shuttle.mediaData[moduleIdentifier] as? M
    abstract fun getMediaDataFormat(): MediaDataFormat<M>
    inline fun <reified T : Any> mediaDataFormat(): MediaDataFormat<T> = T::class to serializer<T>()
}
