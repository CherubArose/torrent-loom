package org.torrentloom.mediadata

/**
 * MediaData parser.
 *
 * From a raw MediaData component, extract its relevant values.
 */
interface MediaDataParser<M : MediaData> {
    fun parseData(data: MediaData)
}
