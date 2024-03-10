package org.torrentloom.mediadata.guessit.fetcher

import com.kgit2.kommand.process.Command
import kotlinx.serialization.json.Json
import org.torrentloom.mediadata.guessit.data.GuessItData
import org.torrentloom.mediadata.guessit.data.Type

object DefaultGuessItFetcher : GuessItFetcher {
    override fun runGuessIt(path: String, type: Type?): GuessItData = Command("guessit")
        .args(buildGuessItParams(type) + path)
        .spawn()
        .waitWithOutput()
        .run {
            Json.decodeFromString(stdout ?: throw Exception("Failed to run the GuessIt command: $stderr"))
        }

    private fun buildGuessItParams(type: Type?) = type?.let { listOf("--type", type.name.lowercase()) } ?: emptyList()
}
