package org.torrentloom.loom.weft.release.disc

import kotlinx.serialization.Serializable
import org.torrentloom.loom.Heddle

/**
 * Information about the disc
 */
@Serializable
data class DiscInfo(
    val type: Heddle<DiscType> = Heddle.emptyHeddle(),
    /**
     * Distributor of the Disc.
     *
     * e.g. Sony Pictures, Criterion
     */
    val distributor: Heddle<String> = Heddle.emptyHeddle(),
    val region: Heddle<String> = Heddle.emptyHeddle(),
    val count: Heddle<Int> = Heddle.emptyHeddle(),
)
