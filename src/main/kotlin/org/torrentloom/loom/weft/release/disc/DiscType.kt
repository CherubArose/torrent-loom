package org.torrentloom.loom.weft.release.disc

/**
 * Types of discs for full disc uploads.
 */
enum class DiscType {
    /**
     * Blu-ray disc.
     *
     * More on [Wikipedia](https://en.wikipedia.org/wiki/Blu-ray)
     */
    BluRay,

    /**
     * DVD-5, Single-Sided, Single-Layer, 5GB (4.70GB)
     *
     * More on [Wikipedia](https://en.wikipedia.org/wiki/DVD#Capacity)
     */
    DVD5,

    /**
     * DVD-9, Single-Sided, Dual-Layer, 9GB (8.54GB)
     *
     * More on [Wikipedia](https://en.wikipedia.org/wiki/DVD#Capacity)
     */
    DVD9,

    /**
     * DVD-10, Double-sided, Single-Layer, 10GB (9.40GB)
     *
     * More on [Wikipedia](https://en.wikipedia.org/wiki/DVD#Capacity)
     */
    DVD10,

    /**
     * HD DVD
     *
     * More on [Wikipedia](https://en.wikipedia.org/wiki/HD_DVD)
     */
    HDDVD,

    /**
     * LaserDisc
     *
     * More on [Wikipedia](https://en.wikipedia.org/wiki/LaserDisc)
     */
    LD,
}
