package org.torrentloom

import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.torrentloom.mediadata.MediaDataModule
import org.torrentloom.mediadata.guessit.GuessItModule

val injectionConfiguration = module {
    single<List<MediaDataModule<*>>>(named("modules")) {
        listOf(
            GuessItModule
        )
    }
}
