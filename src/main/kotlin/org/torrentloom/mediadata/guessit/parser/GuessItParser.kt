package org.torrentloom.mediadata.guessit.parser

import org.torrentloom.loom.weft.Weft
import org.torrentloom.loom.weft.media.Media
import org.torrentloom.loom.weft.media.Resolution
import org.torrentloom.loom.weft.release.Release
import org.torrentloom.loom.weft.show.Movie
import org.torrentloom.loom.weft.show.Series
import org.torrentloom.loom.weft.show.Show
import org.torrentloom.mediadata.MediaDataParser
import org.torrentloom.mediadata.guessit.data.GuessItData
import org.torrentloom.mediadata.guessit.data.Other
import org.torrentloom.mediadata.guessit.data.Source
import org.torrentloom.mediadata.guessit.data.Type
import org.torrentloom.loom.weft.release.Source as ReleaseSource
import org.torrentloom.loom.weft.release.Type as ReleaseType

class GuessItParser(moduleName: String) : MediaDataParser<GuessItData>(moduleName) {
    override fun parseData(data: GuessItData, weft: Weft): Weft = weft.copy(
        show = parseShow(data, weft.show ?: generateShow(data)),
        release = parseRelease(data, weft.release),
        media = parseMedia(data, weft.media),
    )

    private fun generateShow(data: GuessItData): Show = when (data.type) {
        Type.Movie -> Movie()
        Type.Episode -> Series()
        null -> throw IllegalStateException("Couldn't determine the type show automatically")
    }

    private fun parseShow(data: GuessItData, show: Show): Show = when (show) {
        is Movie -> parseMovie(data, show)
        is Series -> parseSeries(data, show)
    }

    private fun parseMovie(data: GuessItData, movie: Movie): Movie = movie.copy(
        title = movie.title.addOptionIfNotNull(data.formattedTitle),
        releaseYear = movie.releaseYear.addOptionIfNotNull(data.year),
    )

    private fun parseSeries(data: GuessItData, series: Series): Series = series.copy(
        title = series.title.addOptionIfNotNull(data.formattedTitle),
        releaseYear = series.releaseYear.addOptionIfNotNull(data.year),
        seasons = series.seasons.addOptionIfNotNull(data.episodes),
        episodes = series.episodes.addOptionIfNotNull(data.episodes),
        partTitle = series.partTitle.addOptionIfNotNull(data.episodeTitle),
    )

    private fun parseRelease(data: GuessItData, release: Release): Release = release.copy(
        releaseGroup = release.releaseGroup.addOptionIfNotNull(data.releaseGroup),
        service = release.service.addOptionIfNotNull(data.streamingService),
        // cut = release.cut.addOption()
        // edition = release.edition.addOption(buildEditions(result)),
        type = release.type.addOptionIfNotNull(data.releaseType),
        source = release.source.addOptionIfNotNull(data.releaseSource),
    )

    private fun parseMedia(data: GuessItData, media: Media): Media = media.copy(
        resolution = media.resolution.addOptionIfNotNull(data.resolution)
    )

    private val GuessItData.formattedTitle: String?
        get() = title?.let { title + (country?.let { " ($it)" } ?: "") }

    private val GuessItData.releaseType: ReleaseType?
        get() = when {
            other?.contains(Other.Remux) ?: false -> ReleaseType.Remux
            source == Source.Web && other?.contains(Other.Rip) ?: false -> ReleaseType.WebRip
            source == Source.Web -> ReleaseType.WebDL
            source in listOf(
                Source.AnalogHDTV,
                Source.HDTV,
                Source.TV,
                Source.UltraHDTV,
                Source.DigitalTV
            ) -> ReleaseType.HDTV

            else -> null
        }

    private val GuessItData.releaseSource: ReleaseSource?
        get() = when (source) {
            Source.UltraHDBluray, Source.BluRay -> ReleaseSource.BluRay
            Source.Web -> ReleaseSource.Web
            Source.DVD -> ReleaseSource.DVD
            Source.HDDVD -> ReleaseSource.HD_DVD
            Source.VHS -> ReleaseSource.VHS
            Source.UltraHDTV -> ReleaseSource.UHDTV
            Source.AnalogHDTV, Source.HDTV -> ReleaseSource.HDTV
            Source.TV -> ReleaseSource.TV
            else -> null
        }

    private val GuessItData.resolution: Resolution?
        get() = when (screenSize) {
            "360i", "360p", "368p" -> null
            "480i" -> Resolution.`480i`
            "480p" -> Resolution.`480p`
            "540i", "540p" -> null
            "576i" -> Resolution.`576i`
            "576p" -> Resolution.`576p`
            "720p" -> Resolution.`720p`
            "900i", "900p" -> null
            "1080i" -> Resolution.`1080i`
            "1080p" -> Resolution.`1080p`
            "1440p" -> Resolution.`1440p`
            "2160p" -> Resolution.`2160p`
            "4320p" -> Resolution.`4320p`
            else -> null
        }
}
