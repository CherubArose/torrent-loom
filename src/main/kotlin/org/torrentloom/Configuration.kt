package org.torrentloom

import org.koin.dsl.module
import org.torrentloom.org.torrentloom.mediadata.MediaDataModule

val injectionConfiguration = module {
    single<List<MediaDataModule<*>>> {
        listOf(
        )
    }
}
