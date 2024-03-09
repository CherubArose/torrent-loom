package org.torrentloom.org.torrentloom.loom

import org.torrentloom.org.torrentloom.loom.weft.Weft
import org.torrentloom.org.torrentloom.mediadata.MediaData

/**
 * Container about the current Torrent being prepared.
 */
data class Shuttle(
    /**
     * Path to the folder/file being processed.
     */
    val path: String,
    /**
     * Metadata about the media being uploaded.
     */
    val weft: Weft = Weft(),
    /**
     * Raw MediaData collected
     */
    val mediaData: Map<String, MediaData> = emptyMap(),
)
