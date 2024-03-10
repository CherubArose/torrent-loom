package org.torrentloom.loom.weft.release

import kotlinx.serialization.Serializable
import org.torrentloom.loom.Heddle
import org.torrentloom.loom.weft.release.disc.DiscInfo

@Serializable
data class Release(
    /**
     * Cut version of the show.
     *
     * e.g. `Director's cut`, `Extended`, etc.
     */
    val cut: Heddle<String> = Heddle.emptyHeddle(),
    /**
     * Ratio of the media.
     *
     * e.g. [AspectRatio.OAR] (Original Aspect Ratio), `[AspectRatio.OpenMatte], etc.
     */
    val aspectRatio: Heddle<AspectRatio> = Heddle.emptyHeddle(),
    /**
     * Whether the release is made of two or more sources.
     */
    val hybrid: Heddle<Boolean> = Heddle.emptyHeddle(),
    /**
     * Version of the REPACK (if any).
     *
     * A REPACK is usually issued by the same release group and is the same content, but addresses packages issues.
     */
    val repackVersion: Heddle<Int> = Heddle.emptyHeddle(),
    /**
     * Version of the PROPER (if any).
     *
     * A PROPER can be released by a different release group and can be a different and improved version of previously released content.
     */
    val properVersion: Heddle<Int> = Heddle.emptyHeddle(),
    /**
     * Version of the RERip (if any).
     *
     * A RERip is usually issued by the same release group and is the same content, but addresses content ripping issues.
     */
    val reripVersion: Heddle<Int> = Heddle.emptyHeddle(),
    /**
     * Edition of the release.
     *
     * e.g. `Remaster`, `Limited`, `Criterion Collection`, etc.
     */
    val edition: Heddle<String> = Heddle.emptyHeddle(),
    /**
     * Main medium on which the source content was obtained.
     *
     * e.g. [Source.DVD], or [Source.Web]
     */
    val source: Heddle<Source> = Heddle.emptyHeddle(),
    //TODO: Use the Service Enum rather than String?
    val service: Heddle<String> = Heddle.emptyHeddle(),
    /**
     * Name of the release group
     *
     * e.g. FraMeSToR, FLUX
     */
    val releaseGroup: Heddle<String> = Heddle.emptyHeddle(),
    val type: Heddle<Type> = Heddle.emptyHeddle(),
    val discInfo: DiscInfo = DiscInfo(),
)
