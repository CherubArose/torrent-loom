package org.torrentloom.mediadata

import kotlinx.serialization.modules.PolymorphicModuleBuilder
import org.koin.core.module.Module
import org.torrentloom.loom.Heddle
import org.torrentloom.loom.Shuttle

abstract class MediaDataModule<M : MediaData> {
    val moduleIdentifier: String = this::class.simpleName!!
    abstract val defaultModuleConfiguration: Module

    protected abstract val fetcher: MediaDataFetcher<M>
    protected abstract val parser: MediaDataParser<M>

    fun runModule(shuttle: Shuttle, rerun: Boolean = false): Shuttle =
        (shuttle.takeUnless { rerun || getMediaData(it) == null } ?: fetchMediaData(shuttle)).let {
            getMediaData(it)
                ?.let { mediaData -> it.copy(weft = parser.parseData(mediaData, it.weft)) }
                .also { saveShuttle(shuttle) }
                ?: it
        }

    private fun fetchMediaData(shuttle: Shuttle): Shuttle = when (val mediaData = fetcher.fetchData(shuttle)) {
        null -> shuttle.copy(mediaData = shuttle.mediaData.minus(moduleIdentifier))
        else -> shuttle.copy(mediaData = shuttle.mediaData.plus(moduleIdentifier to mediaData))
    }.also {
        saveShuttle(shuttle)
    }

    private fun saveShuttle(shuttle: Shuttle) {
        //TODO: Save the state of the shuttle
        println(shuttle)
    }

    @Suppress("UNCHECKED_CAST")
    fun getMediaData(shuttle: Shuttle): M? = shuttle.mediaData[moduleIdentifier] as? M
    abstract fun registerMediaDataFormat(builder: PolymorphicModuleBuilder<M>)
}
