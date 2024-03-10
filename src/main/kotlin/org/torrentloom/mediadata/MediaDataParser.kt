package org.torrentloom.mediadata

import org.torrentloom.loom.Heddle
import org.torrentloom.loom.weft.Weft

/**
 * MediaData parser.
 *
 * From a raw MediaData component, extract its relevant values.
 */
abstract class MediaDataParser<M : MediaData>(val moduleName: String) {
    abstract fun parseData(data: M, weft: Weft): Weft

    protected fun <T : Any> Heddle<T>.addOption(option: T) = addOption(moduleName, option)

    protected fun <T : Any> Heddle<T>.addOptionIfNotNull(option: T?) = if (option != null) addOption(option) else this
}
