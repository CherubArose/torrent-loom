package org.torrentloom.mediadata.guessit.fetcher

import com.kgit2.kommand.process.Command
import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.serialization.json.Json
import org.torrentloom.mediadata.guessit.data.GuessItData
import org.torrentloom.mediadata.guessit.data.Type

object DefaultGuessItFetcher : GuessItFetcher {
    private val logger = KotlinLogging.logger {}

    override fun runGuessIt(path: String, type: Type?): GuessItData = Command("guessit")
        .args("-j", *buildGuessItParams(type).toTypedArray(), path)
        .also { logger.atDebug { "Running guessit (${it.debugString()})" } }
        .spawn()
        .waitWithOutput()
        .run {
            Json.decodeFromString(stdout ?: throw Exception("Failed to run the GuessIt command: $stderr"))
        }

    private fun buildGuessItParams(type: Type?) = type?.let { listOf("--type", type.name.lowercase()) } ?: emptyList()

    private fun Command.args(vararg args: String) = args(args.toList())
}
