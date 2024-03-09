package org.torrentloom.mediadata

import org.torrentloom.loom.Shuttle

abstract class MediaDataModule<M : MediaData> {
    val moduleIdentifier: String = this::class.qualifiedName!!

    internal abstract val fetcher: MediaDataFetcher<M>
    internal abstract val parser: MediaDataParser<M>

    fun runModule(shuttle: Shuttle): Shuttle{
        val mediaData = fetcher.fetchData()
        parser.parseData(mediaData)
        return shuttle.copy(mediaData = shuttle.mediaData.plus(moduleIdentifier to mediaData))
    }
}
