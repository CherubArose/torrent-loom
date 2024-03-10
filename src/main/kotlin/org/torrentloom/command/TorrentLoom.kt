package org.torrentloom.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.torrentloom.VERSION
import org.torrentloom.injectionConfiguration
import org.torrentloom.loom.Shuttle
import org.torrentloom.mediadata.MediaDataModule
import org.torrentloom.mediadata.guessit.GuessItModule

object TorrentLoom : CliktCommand(), KoinComponent {
    private val versionFlag by option("-v", "--version", help = "Version of the application").flag()
    private val pathArgument: String by argument("path", "Path to the file/folder to be uploaded")

    /**
     * List of all the mediaDataModule that will be run in order.
     */
    private val mediaDataModules: List<MediaDataModule<*>> by inject()

    init {
        startKoin {
            modules(
                injectionConfiguration,
                GuessItModule.defaultModuleConfiguration
            )
        }
    }

    override fun run() {
        if (versionFlag) {
            println("TorrentLoom v$VERSION")
            return
        }

        mediaDataModules.fold(Shuttle(path = pathArgument)) { shuttle, module -> module.runModule(shuttle) }
    }
}
