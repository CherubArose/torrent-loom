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
    val selection: String? = null,
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

    /**
     * Adds an option to the Heddle.
     *
     * @param provider name of the provider for the new [option]
     * @param option new option to add to the [Heddle]
     * @return copy of the [Heddle] with the new [option]
     */
    fun addOption(provider: String, option: T) = copy(options = options + (provider to option))

    /**
     * Adds and selects option in the Heddle.
     *
     * @param provider name of the provider for the new [option] to be selected
     * @param option new option to add to the [Heddle]
     * @return copy of the [Heddle] with the new [option] selected
     */
    fun addAndSelectOption(provider: String, option: T) =
        copy(options = options + (provider to option), selection = provider)


    /**
     * Adds and selects the default option in the Heddle.
     *
     * @param provider name of the provider for the new [option]. It will be selected if the [Heddle] had no previous selection.
     * @param option new option to add to the [Heddle]
     * @return copy of the [Heddle] with the new [option] selected
     */
    fun addAndDefaultOption(provider: String, option: T) =
        copy(options = options + (provider to option), selection = selection ?: provider)

    /**
     * Selects an option from the Heddle.
     *
     * @param selection name of the provider for the selection
     * @return copy of the [Heddle] with the newly selected option
     */
    fun selectOption(selection: String?) = copy(selection = selection)

    /**
     * Runs a validation against every option in the Heddle.
     *
     * @param checker Check fuction to apply to each option
     * @return true if each option is valid, false otherwise
     */
    fun validateOptions(checker: HeddleOptionsChecker<T>) = options.values.filterNot(checker::check).isEmpty()

    companion object {
        private val emptyHeddle = Heddle(emptyMap())

        /**
         * Returns an empty Heddle of the specified type.
         */
        @Suppress("UNCHECKED_CAST")
        fun <T : Any> emptyHeddle(): Heddle<T> = emptyHeddle as Heddle<T>

        fun <T : Any> from(source: String, option: T, autoSelect: Boolean = false): Heddle<T> =
            Heddle(mapOf(source to option), source.takeIf { autoSelect })
    }
}
