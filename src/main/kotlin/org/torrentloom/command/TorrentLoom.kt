package org.torrentloom.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.torrentloom.loom.Shuttle
import org.torrentloom.mediadata.MediaDataModule
import org.torrentloom.mediadata.guessit.GuessItModule

object TorrentLoom : CliktCommand(), KoinComponent {
    private val pathArgument: String by argument("path", "Path to the file/folder to be uploaded")

    /**
     * List of all the mediaDataModule that will be run in order.
     */
    private val mediaDataModules: List<MediaDataModule<*>> by inject(named("modules"))

    init {
        startKoin {
            val mediaDataModules: List<MediaDataModule<*>> = listOf(GuessItModule)
            modules(
                module {
                    single<List<MediaDataModule<*>>>(named("modules")) {
                        listOf(
                            GuessItModule
                        )
                    }
                },
                *mediaDataModules.map { it.defaultModuleConfiguration }.toTypedArray(),
            )
        }
    }

    override fun run() {
        mediaDataModules
            .fold(Shuttle(path = pathArgument)) { shuttle, module -> module.runModule(shuttle) }
            .let { println(it) }
    }
}
