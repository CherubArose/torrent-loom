package org.torrentloom.loom.weft

import org.torrentloom.loom.weft.show.Show

/**
 * Metadata relating to an upload being prepared
 */
data class Weft(
    val show: Show? = null,
)
