package org.torrentloom.loom.weft

import org.torrentloom.loom.weft.media.Media
import org.torrentloom.loom.weft.release.Release
import org.torrentloom.loom.weft.show.Show

/**
 * Metadata relating to an upload being prepared.
 *
 * The weft is the thread transported by the [shuttle][org.torrentloom.loom.Shuttle] which ties the fabric together.
 *
 * More info: [Wikipedia](https://en.wikipedia.org/wiki/Warp_and_weft).
 */
data class Weft(
    /**
     * Details about the show.
     *
     * The [show] contains information that pertain to the content of the files but not their format.
     * It provides details about the TV Show/Movie/Anime.
     */
    val show: Show? = null,
    /**
     * Meta information about the file format.
     *
     * [media] contains details on the video file format, audio codecs and other encoding details.
     */
    val media: Media = Media(),
    /**
     * Meta information about the release of the file.
     *
     * [release] provides details about the release group, conditions of release, edition, etc.
     */
    val release: Release = Release(),
)
