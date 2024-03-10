package org.torrentloom.loom.weft.release

import kotlinx.serialization.Serializable

/**
 * Sources of video content.
 */
@Serializable
enum class Source {
    BluRay,
    DVD,
    HD_DVD,
    Web,
    HDTV,
    UHDTV,
    TV,
    VHS,
    LaserDisc,
}
