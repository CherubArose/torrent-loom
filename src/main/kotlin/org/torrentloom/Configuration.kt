package org.torrentloom

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.torrentloom.mediadata.MediaData
import org.torrentloom.mediadata.MediaDataModule
import org.torrentloom.mediadata.guessit.GuessItModule

object Configuration {
    private val mediaDataModules = listOf(GuessItModule)

    private val module: Module = module {
        single<List<MediaDataModule<*>>>(named("modules")) { mediaDataModules }
        single<Json> {
            Json {
                prettyPrint = true
                classDiscriminator = "#class"
                serializersModule = SerializersModule {
                    polymorphic(MediaData::class) {
                        get<List<MediaDataModule<*>>>(named("modules")).onEach { it.registerMediaDataFormat(this) }
                    }
                }
            }
        }
    }

    fun load() {
        startKoin {
            modules(
                module,
                *mediaDataModules.map { it.defaultModuleConfiguration }.toTypedArray(),
            )
        }
    }
}
