package org.torrentloom.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.torrentloom.VERSION
import org.torrentloom.injectionConfiguration
import org.torrentloom.mediadata.MediaDataModule

object TorrentLoom : CliktCommand(), KoinComponent {
    val versionFlag by option("-v", "--version", help = "Version of the application").flag()

    val mediaDataModules: List<MediaDataModule<*>> by inject()

    init {
        startKoin {
            modules(
                injectionConfiguration,
            )
        }
    }

    override fun run() {
        if (versionFlag) {
            println("TorrentLoom v${VERSION}")
            return
        }

        mediaDataModules.fold("") { _, module -> module.runModule(); ""}
    }
}
