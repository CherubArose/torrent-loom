package org.torrentloom.mediadata.guessit.fetcher

import com.kgit2.kommand.process.Command
import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.serialization.json.Json
import org.torrentloom.mediadata.guessit.data.GuessItData
import org.torrentloom.mediadata.guessit.data.Type

object DefaultGuessItFetcher : GuessItFetcher {
    private val logger = KotlinLogging.logger {}

    override fun runGuessIt(path: String, type: Type?): GuessItData = Command("guessit")
        .args("-j", *typeArgs(type), path)
        .also { logger.atDebug { "Running guessit (${it.debugString()})" } }
        .spawn()
        .waitWithOutput()
        .run {
            Json.decodeFromString(stdout ?: throw Exception("Failed to run the GuessIt command: $stderr"))
        }

    private fun typeArgs(type: Type?) = type?.let { arrayOf("--type", type.name.lowercase()) } ?: emptyArray()

    private fun Command.args(vararg args: String) = args(args.toList())
}
