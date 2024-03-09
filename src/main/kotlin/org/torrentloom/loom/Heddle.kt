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
    /**
     * Map of all options available for each provider.
     */
    val options: Map<String, T>,
    /**
     * Current provider selected.
     */
    val selection: String?,
) {
    init {
        check(selection == null || selection in options) {
            "Failed to initialise ${Heddle::class}, the selection '$selection' does not exist amongst $options."
        }
    }

    /**
     * Current value selected.
     */
    val selected: T? = options[selection]

    fun validateOptions(checker: HeddleOptionsChecker<T>) = options.values.find(checker::check) != null

    companion object {
        private val emptyHeddle = Heddle(emptyMap(), null)

        /**
         * Returns an empty Heddle of the specified type.
         */
        @Suppress("UNCHECKED_CAST")
        fun <T : Any> emptyHeddle(): Heddle<T> = emptyHeddle as Heddle<T>
    }
}
