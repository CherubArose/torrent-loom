package org.torrentloom.mediadata.guessit.data

import kotlinx.serialization.json.Json
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
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
            alternativeTitle = listOf("alternative", "Title"),
            container = listOf("cont", "ainer"),
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
            episodeDetails = listOf("episode", "Details"),
            episodeFormat = "episodeFormat",
            version = 9,
            source = Source.DVD,
            screenSize = "screenSize",
            aspectRatio = 3.1415,
            videoCodec = "videoCodec",
            videoProfile = listOf("video", "Profile"),
            colorDepth = "colorDepth",
            videoApi = "videoApi",
            videoBitRate = "videoBitRate",
            frameRate = "frameRate",
            audioChannels = listOf("audio", "Channels"),
            audioCodec = listOf("audio", "Codec"),
            audioProfile = listOf("audio", "Profile"),
            audioBitRate = "audioBitRate",
            country = "country",
            languages = listOf("lang", "uage"),
            subtitleLanguages = listOf("subtitle", "Language"),
            bonus = 10,
            bonusTitle = "bonusTitle",
            cd = 11,
            cdCount = 12,
            crc32 = "crc32",
            uuid = "uuid",
            size = "size",
            edition = listOf(Edition.Fan, Edition.Special),
            filmNumber = 13,
            filmTitle = "filmTitle",
            filmSeries = "filmSeries",
            other = listOf(Other.Documentary, Other.Rip),
            episodeTitle = "episodeTitle",
            properCount = 14,
            part = listOf(15, 16),
            absoluteEpisodes = listOf(17, 18),
        )
        val actual = """
            {
              "type": "movie",
              "title": "title",
              "alternative_title": ["alternative", "Title"],
              "container": ["cont", "ainer"],
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
              "episode_details": ["episode", "Details"],
              "episode_format": "episodeFormat",
              "version": 9,
              "source": "DVD",
              "screen_size": "screenSize",
              "aspect_ratio": 3.1415,
              "video_codec": "videoCodec",
              "video_profile": ["video", "Profile"],
              "color_depth": "colorDepth",
              "video_api": "videoApi",
              "video_bit_rate": "videoBitRate",
              "frame_rate": "frameRate",
              "audio_channels": ["audio", "Channels"],
              "audio_codec": ["audio", "Codec"],
              "audio_profile": ["audio", "Profile"],
              "audio_bit_rate": "audioBitRate",
              "country": "country",
              "language": ["lang", "uage"],
              "subtitle_language": ["subtitle", "Language"],
              "bonus": 10,
              "bonus_title": "bonusTitle",
              "cd": 11,
              "cd_count": 12,
              "crc32": "crc32",
              "uuid": "uuid",
              "size": "size",
              "edition": ["Fan", "Special"],
              "film": 13,
              "film_title": "filmTitle",
              "film_series": "filmSeries",
              "other": ["Documentary", "Rip"],
              "episode_title": "episodeTitle",
              "proper_count": 14,
              "part": [15, 16],
              "absolute_episode": [17, 18]
            }
        """.decodeJson<GuessItData>()

        assertEquals(expected, actual)
    }

    @TestFactory
    fun omegaParser() =
        ({}::class.java.getResourceAsStream("omega.json") ?: throw IllegalStateException("Missing omega.json file"))
            .bufferedReader().readLines().mapIndexed { index, line ->
                DynamicTest.dynamicTest("Parsing line #$index of omega.json") { line.decodeJson<GuessItData>() }
            } ?: emptyList()

    private inline fun <reified T : Any> String.decodeJson() = Json.decodeFromString<T>(this)
}
