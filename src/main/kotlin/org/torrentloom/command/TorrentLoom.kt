package org.torrentloom.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.core.Koin
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.torrentloom.Configuration
import org.torrentloom.loom.Shuttle
import org.torrentloom.mediadata.MediaDataModule

object TorrentLoom : CliktCommand(), KoinComponent {
    private val pathArgument: String by argument("path", "Path to the file/folder to be uploaded")

    /**
     * List of all the mediaDataModule that will be run in order.
     */
    private val mediaDataModules: List<MediaDataModule<*>> by inject()
    private val json: Json by inject()

    override fun run() {
        mediaDataModules
            .fold(Shuttle(path = pathArgument)) { shuttle, module -> module.runModule(shuttle) }
            .let { println(json.encodeToString(it)) }
    }

    override fun getKoin(): Koin = Configuration.koin
}
