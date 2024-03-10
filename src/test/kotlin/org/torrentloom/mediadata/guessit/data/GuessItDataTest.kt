package org.torrentloom.mediadata.guessit.data

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class GuessItDataTest {
    @Test
    fun testEmptyGuessItResultParses() {
        val jsonContent = "{}"

        val expected = GuessItData()
        val actual = Json.decodeFromString<GuessItData>(jsonContent)

        assertEquals(expected, actual)
    }

    @Test
    fun testListEntriesWorkWithSingleItem() {
        val expected = GuessItData(
            seasons = listOf(1),
            episodes = listOf(2),
            disc = listOf(3),
            edition = listOf(Edition.Fan),
            other = listOf(Other.Rip),
        )

        val actual = """
            {
              "season": 1,
              "episode": 2,
              "disc": 3,
              "edition": "Fan",
              "other": "Rip"
            }
        """.decodeJson<GuessItData>()

        assertEquals(expected, actual)
    }

    @Test
    fun testListEntriesWorkWithListItems() {
        val expected = GuessItData(
            seasons = listOf(1, 2),
            episodes = listOf(3, 4),
            disc = listOf(5, 6),
            edition = listOf(Edition.Fan, Edition.Special),
            other = listOf(Other.Rip, Other.Mux),
        )
        val actual = """
            {
              "season": [1,2],
              "episode": [3,4],
              "disc": [5,6],
              "edition": ["Fan", "Special"],
              "other": ["Rip", "Mux"]
            }
        """.decodeJson<GuessItData>()

        assertEquals(expected, actual)
    }

    @Test
    fun testAllProperties() {
        val expected = GuessItData(
            type = Type.Movie,
            title = "title",
            alternativeTitle = "alternativeTitle",
            container = "container",
            mimetype = "mimetype",
            date = "date",
            year = 2012,
            week = 12,
            releaseGroup = "releaseGroup",
            website = "website",
            streamingService = "streamingService",
            seasons = listOf(1, 2),
            episodes = listOf(3, 4),
            disc = listOf(5, 6),
            episodeCount = 7,
            seasonCount = 8,
            episodeDetails = "episodeDetails",
            episodeFormat = "episodeFormat",
            version = 9,
            source = Source.DVD,
            screenSize = "screenSize",
            aspectRatio = "aspectRatio",
            videoCodec = "videoCodec",
            videoProfile = "videoProfile",
            colorDepth = "colorDepth",
            videoApi = "videoApi",
            videoBitRate = "videoBitRate",
            frameRate = "frameRate",
            audioChannels = "audioChannels",
            audioCodec = "audioCodec",
            audioProfile = "audioProfile",
            audioBitRate = "audioBitRate",
            country = "country",
            languages = listOf("language"),
            subtitleLanguages = listOf("subtitleLanguage"),
            bonus = "bonus",
            bonusTitle = "bonusTitle",
            cd = 10,
            cdCount = 11,
            crc32 = "crc32",
            uuid = "uuid",
            size = "size",
            edition = listOf(Edition.Fan),
            film = "film",
            filmTitle = "filmTitle",
            filmSeries = "filmSeries",
            other = listOf(Other.Documentary),
        )
        val actual = """
            {
              "type": "movie",
              "title": "title",
              "alternative_title": "alternativeTitle",
              "container": "container",
              "mimetype": "mimetype",
              "date": "date",
              "year": 2012,
              "week": 12,
              "release_group": "releaseGroup",
              "website": "website",
              "streaming_service": "streamingService",
              "season": [1,2],
              "episode": [3,4],
              "disc": [5,6],
              "episode_count": 7,
              "season_count": 8,
              "episode_details": "episodeDetails",
              "episode_format": "episodeFormat",
              "version": 9,
              "source": "DVD",
              "screen_size": "screenSize",
              "aspect_ratio": "aspectRatio",
              "video_codec": "videoCodec",
              "video_profile": "videoProfile",
              "color_depth": "colorDepth",
              "video_api": "videoApi",
              "video_bit_rate": "videoBitRate",
              "frame_rate": "frameRate",
              "audio_channels": "audioChannels",
              "audio_codec": "audioCodec",
              "audio_profile": "audioProfile",
              "audio_bit_rate": "audioBitRate",
              "country": "country",
              "language": "language",
              "subtitle_language": "subtitleLanguage",
              "bonus": "bonus",
              "bonus_title": "bonusTitle",
              "cd": 10,
              "cd_count": 11,
              "crc32": "crc32",
              "uuid": "uuid",
              "size": "size",
              "edition": "Fan",
              "film": "film",
              "film_title": "filmTitle",
              "film_series": "filmSeries",
              "other": ["Documentary"]
            }
        """.decodeJson<GuessItData>()

        assertEquals(expected, actual)
    }

    private inline fun <reified T : Any> String.decodeJson() = Json.decodeFromString<T>(this)
}
