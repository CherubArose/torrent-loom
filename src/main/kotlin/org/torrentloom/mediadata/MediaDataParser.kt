package org.torrentloom.mediadata

import org.torrentloom.loom.weft.Weft

/**
 * MediaData parser.
 *
 * From a raw MediaData component, extract its relevant values.
 */
interface MediaDataParser<M : MediaData> {
    fun parseData(data: MediaData, weft: Weft): Weft
}
