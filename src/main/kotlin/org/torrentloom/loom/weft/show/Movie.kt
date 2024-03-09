package org.torrentloom.org.torrentloom.loom.weft.show

import org.torrentloom.org.torrentloom.loom.Heddle

data class Movie(
    override val title: Heddle<String> = Heddle.emptyHeddle(),
    override val originalTitle: Heddle<String> = Heddle.emptyHeddle(),
    override val releaseYear: Heddle<Int> = Heddle.emptyHeddle(),
    override val tmdbId: Heddle<Int> = Heddle.emptyHeddle(),
    override val tvdbId: Heddle<Int> = Heddle.emptyHeddle(),
    override val malId: Heddle<Int> = Heddle.emptyHeddle(),
    override val locale: Heddle<String> = Heddle.emptyHeddle(),
) : Show
