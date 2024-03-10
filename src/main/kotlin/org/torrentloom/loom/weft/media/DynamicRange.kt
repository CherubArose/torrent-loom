package org.torrentloom.loom.weft.media

import kotlinx.serialization.Serializable

@Serializable
enum class DynamicRange {
    /**
     * HDR10+.
     *
     * - Type: HDR
     * - More info: [Wikipedia](https://en.wikipedia.org/wiki/HDR10%2B)
     */
    HDR10Plus,

    /**
     * HDR10, also known as HDR.
     *
     * - Type: HDR
     * - More info: [Wikipedia](https://en.wikipedia.org/wiki/HDR10)
     */
    HDR10,

    /**
     * PQ10, also known as PQ.
     *
     * - Type: HDR
     * - More info: [Wikipedia](https://en.wikipedia.org/wiki/High-dynamic-range_television#PQ10_(PQ_format))
     */
    PQ10,

    /**
     * HLG10, also known as HLG
     *
     * - Type: HDR
     * - More info: [Wikipedia](https://en.wikipedia.org/wiki/Hybrid_log%E2%80%93gamma)
     */
    HLG10,

    /**
     * WGC, also known as Wide Color Gamut.
     *
     * - Type: SDR
     * - More info: [Wikipedia](https://en.wikipedia.org/wiki/Wide_color_gamut)
     */
    WCG,

    /**
     * DV, also known as Dolby Vision.
     *
     * Represents commonly DV profile 5.
     *
     * - Type: HDR
     * - More info: [Wikipedia](https://en.wikipedia.org/wiki/Dolby_Vision)
     */
    DV,

    /**
     * DV HDR, Dolby Vision with a base layer of HDR10.
     *
     * Represents commonly DV profile 7 or 8.
     *
     * - Type: HDR
     * - More info: [Wikipedia](https://en.wikipedia.org/wiki/Dolby_Vision#Dual_layer)
     */
    DV_HDR,

    /**
     * DV HLG, Dolby Vision with a base layer of HLG10.
     *
     * Represents commonly DV profile 8.
     *
     * - Type: HDR
     * - More info: [Wikipedia](https://en.wikipedia.org/wiki/Dolby_Vision#Dual_layer)
     */
    DV_HLG,

    /**
     * DV HDR10+, Dolby Vision combined with HDR10+.
     *
     * - Type: HDR
     */
    DV_HDR10Plus,

    /**
     * SDR, also known as Standard Dynamic Range.
     *
     * - Type: SDR
     * - More info: [Wikipedia](https://en.wikipedia.org/wiki/Standard-dynamic-range_video)
     */
    SDR,
}
