package org.torrentloom.loom.weft.release

/**
 * Types of P2P release.
 */
enum class Type {
    /**
     * Content extracted from a non-web source put in a media container with no re-encoding or any other modification.
     */
    Remux,

    /**
     * Re-encoded content from a non-web source.
     */
    Encode,

    /**
     * WEB-DL
     *
     * Content downloaded from an internet source, the content has NOT been re-encoded or modified.
     *
     * More info: [Wikipedia](https://en.wikipedia.org/wiki/Pirated_movie_release_types#Web_Download)
     */
    WebDL,

    /**
     * WebRip
     *
     * Content downloaded from an internet source, the content has been re-encoded or modified.
     *
     * More info: [Wikipedia](https://en.wikipedia.org/wiki/Pirated_movie_release_types#Web_Rip)
     */
    WebRip,

    /**
     * Content obtained via TV broadcast
     *
     * More info: [Wikipedia](https://en.wikipedia.org/wiki/High-definition_television)
     */
    HDTV,

    /**
     * Content in Disc format (DVD, Blu-ray, etc.)
     */
    Disc,
}
