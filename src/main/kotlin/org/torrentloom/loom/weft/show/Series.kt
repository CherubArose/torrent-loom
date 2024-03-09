package org.torrentloom.org.torrentloom.loom.weft.show

import org.torrentloom.org.torrentloom.loom.Heddle

/**
 * TV Series as a Show
 */
data class Series(
    override val title: Heddle<String> = Heddle.emptyHeddle(),
    override val originalTitle: Heddle<String> = Heddle.emptyHeddle(),
    override val locale: Heddle<String> = Heddle.emptyHeddle(),
    override val releaseYear: Heddle<Int> = Heddle.emptyHeddle(),
    override val tmdbId: Heddle<Int> = Heddle.emptyHeddle(),
    override val tvdbId: Heddle<Int> = Heddle.emptyHeddle(),
    override val malId: Heddle<Int> = Heddle.emptyHeddle(),
    /**
     * Title of the part of the Series being uploaded.
     *
     * Could be the title of the episode if only one episode (or multi-episode) is uploaded.
     * Could be the title of the season if a season pack is uploaded.
     */
    val partTitle: Heddle<String> = Heddle.emptyHeddle(),
    /**
     * List of seasons being uploaded.
     *
     * The season list should never be empty, but it could contain only one element.
     */
    val seasons: Heddle<List<Int>> = Heddle.emptyHeddle(),
    /**
     * List of episodes being uploaded.
     *
     * The episode list could be empty when uploading entire season(s), contain a single episode, or multiple episodes.
     */
    val episodes: Heddle<List<Int>> = Heddle.emptyHeddle(),
) : Show {
    val type: Type

    init {
        check(seasons.validateOptions { it.isNotEmpty() }) { "One of the options in Season is an empty list: $seasons" }

        type = when {
            // No season, No episode
            seasons.selected == null && episodes.selected == null -> Type.Unassigned
            // One season, One episode
            seasons.selected?.size == 1 && episodes.selected?.size == 1 -> Type.SingleEpisode
            // One season, Multiple episodes
            seasons.selected?.size == 1 && (episodes.selected?.size ?: 0) > 1 -> Type.MultiEpisodes
            // One season, No episodes
            seasons.selected?.size == 1 && episodes.selected?.isEmpty() ?: false -> Type.SeasonPack
            // Multiple seasons, No episodes
            (seasons.selected?.size ?: 0) > 1 && episodes.selected?.isEmpty() ?: false -> Type.MultiSeasons
            else -> throw IllegalStateException("Unsupported combination of Season(s) ${seasons.selected} and Episode(s) ${episodes.selected}")
        }
    }

    /**
     * Type of content being uploaded.
     */
    enum class Type {
        SeasonPack,
        MultiSeasons,
        SingleEpisode,
        MultiEpisodes,
        Unassigned
    }
}
