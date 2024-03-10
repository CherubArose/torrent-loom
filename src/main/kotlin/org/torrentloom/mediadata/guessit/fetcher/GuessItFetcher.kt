package org.torrentloom.mediadata.guessit.fetcher

import org.torrentloom.loom.Shuttle
import org.torrentloom.loom.weft.show.Movie
import org.torrentloom.loom.weft.show.Series
import org.torrentloom.mediadata.MediaDataFetcher
import org.torrentloom.mediadata.guessit.data.GuessItData
import org.torrentloom.mediadata.guessit.data.Type

/**
 * Type of object that is able to run GuessIt or at least provide a result that follows the GuessIt format.
 */
interface GuessItFetcher : MediaDataFetcher<GuessItData> {
    /**
     * To run GuessIt more efficiently, it is better to know whether the content is a movie or a TV episode.
     */
    override fun fetchData(shuttle: Shuttle): GuessItData? = when (shuttle.weft.show) {
        is Movie -> Type.Movie
        is Series -> Type.Episode
        else -> null
    }.let { runGuessIt(shuttle.path, it) }

    fun runGuessIt(path: String, type: Type? = null): GuessItData
}
