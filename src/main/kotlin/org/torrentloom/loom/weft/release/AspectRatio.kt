package org.torrentloom.loom.weft.release

import kotlinx.serialization.Serializable

@Serializable
enum class AspectRatio {
    /**
     * Original Aspect-Ratio.
     *
     * More info [Wikipedia](https://en.wikipedia.org/wiki/Aspect_ratio_(image)#Original_aspect_ratio_(OAR))
     */
    OAR,

    /**
     * Modified Aspect-Ratio.
     *
     * More info [Wikipedia](https://en.wikipedia.org/wiki/Aspect_ratio_(image)#Modified_aspect_ratio_(MAR))
     */
    MAR,

    /**
     * IMAX aspect-ratio.
     *
     * More info [Wikipedia](https://en.wikipedia.org/wiki/IMAX)
     */
    IMAX,

    /**
     * Open Matte.
     *
     * More info [Wikipedia](https://en.wikipedia.org/wiki/Open_matte)
     */
    OpenMatte,
}
