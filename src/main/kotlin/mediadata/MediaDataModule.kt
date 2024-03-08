package org.torrentloom.mediadata

abstract class MediaDataModule<M : MediaData> {
    internal abstract val fetcher: MediaDataFetcher<M>
    internal abstract val parser: MediaDataParser<M>

    fun runModule() = parser.parseData(fetcher.fetchData())
}
