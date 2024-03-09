package org.torrentloom.loom

/**
 * Data holder for variants of a same value.
 *
 * A Heddle holds multiple possible values for a single metadata information, and allows to select one in particular.
 * For example when doing a metadata lookup on a specific movie, different metadata providers could have slightly
 * different values for its name, or for a specific files, different providers could find different Streaming services.
 *
 * The Heddle allows to keep track all those variants and their sources, while keeping one of them as the selected one.
 */
data class Heddle<T : Any>(
    val options: Map<String, T>,
    val selected: String?,
) {
    init {
        check(selected == null || selected in options) {
            "Failed to initialise ${Heddle::class}, the selected option '$selected' does not exist amongst $options."
        }
    }

    /**
     * Gets the currently selected option in the Heddle.
     *
     * @return the selected option, or null if none were available.
     */
    fun get(): T? = options[selected]

    companion object {
        private val emptyHeddle = Heddle(emptyMap(), null)

        /**
         * Returns an empty Heddle of the specified type.
         */
        @Suppress("UNCHECKED_CAST")
        fun <T : Any> emptyHeddle(): Heddle<T> = emptyHeddle as Heddle<T>
    }
}
