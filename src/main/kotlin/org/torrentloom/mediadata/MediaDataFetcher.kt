package org.torrentloom.mediadata

/**
 * MediaData fetcher.
 *
 * Retrieves the metadata of a given media component in its "raw" form.
 * That data can then be parsed and processed elsewhere.
 */
interface MediaDataFetcher<M : MediaData> {
    fun fetchData(): M?
}
