package org.torrentloom.loom.weft.media

import kotlinx.serialization.Serializable

@Serializable
enum class Resolution {
    /**
     * 8640p, also known as 16K resolution
     *
     * More info: https://en.wikipedia.org/wiki/16K_resolution
     */
    `8640p`,

    /**
     * 4320p, also known as 8K resolution, or 8K UHD
     *
     * More info: https://en.wikipedia.org/wiki/8K_resolution
     */
    `4320p`,

    /**
     * 2160p, also known as 4K resolution or 4k UHD
     *
     * More info: https://en.wikipedia.org/wiki/4K_resolution
     */
    `2160p`,

    /**
     * 1440p, also known as QHD (Quad HD) or WQHD (Wide Quad HD)
     *
     * More info: https://en.wikipedia.org/wiki/1440p
     */
    `1440p`,

    /**
     * 1080p, also known as Full HD
     *
     * More info: https://en.wikipedia.org/wiki/1080p
     */
    `1080p`,

    /**
     * 1080i, the interlaced version of 1080p
     *
     * More info: https://en.wikipedia.org/wiki/1080i
     */
    `1080i`,

    // HD
    `720p`,

    /**
     * 576i, the progressive version of 576i
     *
     * More info: https://en.wikipedia.org/wiki/576p
     */
    `576p`,

    /**
     * 576i, also known as PAL, or PAL/SECAM
     *
     * More info: https://en.wikipedia.org/wiki/576i
     */
    `576i`,

    /**
     * 480p,  the progressive version of 480i
     *
     * More info: https://en.wikipedia.org/wiki/480p
     */
    `480p`,

    /**
     * 480i, also known as NTSC
     *
     * More info: https://en.wikipedia.org/wiki/480i
     */
    `480i`,
    ;

    /**
     * Converts the resolution to the Analog resolution (in particular for DVD formats).
     *
     * 576p and 576i are considered PAL
     * 480p and 480i are considered NTSC
     * Other resolutions do not return an analog resolution.
     */
    fun asAnalogResolution() = when (this) {
        `576p`, `576i` -> AnalogResolution.PAL
        `480p`, `480i` -> AnalogResolution.NTSC
        else -> null
    }

    /**
     * Resolution for DVDs (using the previous PAL/NTSC denomination).
     */
    enum class AnalogResolution {
        /**
         * PAL, also known as PAL/SECAM
         *
         * More info: https://en.wikipedia.org/wiki/PAL
         */
        PAL,

        /**
         * NTSC
         *
         * More info: https://en.wikipedia.org/wiki/NTSC
         */
        NTSC
    }
}
