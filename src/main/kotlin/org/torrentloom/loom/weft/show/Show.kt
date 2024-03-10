package org.torrentloom.loom.weft.show

import kotlinx.serialization.Serializable
import org.torrentloom.loom.Heddle

@Serializable
sealed interface Show {
    /**
     * Internationally recognised title of the show.
     *
     * Usually found on IMDB. All punctuation must be included.
     */
    val title: Heddle<String>

    /**
     * Original Title of the show.
     *
     * Must be transliterated in Latin characters (Romanization/Romaji).
     */
    val originalTitle: Heddle<String>

    /**
     * Locale of the show.
     *
     * Only used to disambiguate the show if multiple versions from different countries exist.
     */
    val locale: Heddle<String>

    /**
     * Release year of the show.
     *
     * The release year can be used to distinguish different shows with the same name released at a different time.
     * e.g. "Snow White (1990)" and "Snow White (1987)"
     */
    val releaseYear: Heddle<Int>

    /**
     * TheMovieDataBase identifier.
     *
     * Unique identifier for the show on themoviedb.org
     */
    val tmdbId: Heddle<Int>

    /**
     * TheTVDB identifier.
     *
     * Unique identifier for the show on thetvdb.com
     */
    val tvdbId: Heddle<Int>

    /**
     * MyAnimeList identifier.
     *
     * Unique identifier for the show on myanimelist.net
     */
    val malId: Heddle<Int>
}
