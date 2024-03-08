package org.torrentloom.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import org.torrentloom.VERSION

object TorrentLoom : CliktCommand() {
    val versionFlag by option("-v", "--version", help = "Version of the application").flag()

    override fun run() {
        if (versionFlag) {
            println("TorrentLoom v${VERSION}")
            return
        }
    }
}
