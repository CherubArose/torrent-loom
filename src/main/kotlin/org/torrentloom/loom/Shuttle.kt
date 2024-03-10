package org.torrentloom.loom

import kotlinx.serialization.Serializable
import org.torrentloom.loom.weft.Weft
import org.torrentloom.mediadata.MediaData

/**
 * Container about the current Torrent being prepared.
 */
@Serializable
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
