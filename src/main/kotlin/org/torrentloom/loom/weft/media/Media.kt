package org.torrentloom.org.torrentloom.loom.weft.media

import org.torrentloom.org.torrentloom.loom.Heddle

data class Media(
    /**
     * Resolution of the media.
     *
     * e.g. 1080p, 720p
     */
    val resolution: Heddle<Resolution> = Heddle.emptyHeddle(),
    /**
     * Dynamic range for the video.
     *
     * e.g. HDR, DV
     */
    val dynamicRange: Heddle<DynamicRange> = Heddle.emptyHeddle(),
    /**
     * Audio channels for the media.
     *
     * e.g. 7.1, 2.0
     */
    val audioChannels: Heddle<String> = Heddle.emptyHeddle(),
    /**
     * Audio codec for the media.
     *
     * e.g. AAC, DD+
     */
    val audioCodec: Heddle<String> = Heddle.emptyHeddle(),
    /**
     * Video codec for the media.
     *
     * e.g. x265, x264
     */
    val videoCodec: Heddle<String> = Heddle.emptyHeddle(),
    /**
     * Whether the media is a 3D video or not
     */
    val `3D`: Heddle<Boolean> = Heddle.emptyHeddle(),
)
