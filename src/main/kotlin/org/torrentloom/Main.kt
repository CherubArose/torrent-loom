package org.torrentloom

import com.github.ajalt.clikt.parameters.options.versionOption
import org.torrentloom.command.TorrentLoom

const val VERSION = "0.1"

fun main(vararg args: String) = TorrentLoom.versionOption(VERSION).main(args)
