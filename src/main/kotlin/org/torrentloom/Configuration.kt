package org.torrentloom

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.koin.core.module.Module
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import org.torrentloom.mediadata.MediaData
import org.torrentloom.mediadata.MediaDataModule
import org.torrentloom.mediadata.guessit.GuessItModule
import org.torrentloom.mediadata.tmdb.TmdbModule

object Configuration {
    private val mediaDataModules = listOf(
        GuessItModule,
        TmdbModule,
    )

    private val module: Module = module {
        single<List<MediaDataModule<out MediaData>>> { mediaDataModules }
        single<Json> {
            Json {
                prettyPrint = true
                classDiscriminator = "#class"
                serializersModule = SerializersModule {
                    polymorphic(MediaData::class) {
                        get<List<MediaDataModule<MediaData>>>().map { it.getMediaDataFormat() }
                            .onEach { (clazz, serializer) -> subclass(clazz, serializer) }
                    }
                }
            }
        }

        includes(mediaDataModules.map { it.defaultModuleConfiguration })
    }

    val koin = koinApplication { modules(module) }.koin
}
