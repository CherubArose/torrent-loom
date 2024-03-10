package org.torrentloom.loom.weft.show

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.torrentloom.loom.Heddle
import org.torrentloom.org.torrentloom.loom.weft.show.Series
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SeriesTest {
    private val provider = "provider"

    private val emptySeason = emptyList<Int>()
    private val singleSeason = listOf(1)
    private val multiSeason = listOf(2, 3)
    private val seasonCases = listOf(null, emptySeason, singleSeason, multiSeason)

    private val emptyEpisode = emptyList<Int>()
    private val singleEpisode = listOf(4)
    private val multiEpisode = listOf(5, 6)
    private val episodeCases = listOf(null, emptyEpisode, singleEpisode, multiEpisode)

    @TestFactory
    fun `ensure that the correct series type is detected`() =
        seasonCases.flatMap { season -> episodeCases.map { episode -> season to episode } }
            .map { (season, episode) -> Triple(season, episode, getExpectedSeriesType(season, episode)) }
            .map { (seasons, episodes, type) ->
                if (type != null) testWorkingSeriesType(seasons, episodes, type)
                else testFailingSeriesType(seasons, episodes)
            }

    private fun testWorkingSeriesType(seasons: List<Int>?, episodes: List<Int>?, type: Series.Type) =
        DynamicTest.dynamicTest("Seasons($seasons) and Episodes($episodes) represent $type") {
            val series = Series(seasons = Heddle.testHeddle(seasons), episodes = Heddle.testHeddle(episodes))

            assertEquals(seasons, series.seasons.selected)
            assertEquals(episodes, series.episodes.selected)
            assertEquals(type, series.type)
        }

    private fun testFailingSeriesType(seasons: List<Int>?, episodes: List<Int>?) =
        DynamicTest.dynamicTest("Seasons($seasons) and Episodes($episodes) fail") {
            assertFailsWith<IllegalStateException> {
                Series(seasons = Heddle.testHeddle(seasons), episodes = Heddle.testHeddle(episodes))
            }
        }

    private fun getExpectedSeriesType(seasons: List<Int>?, episodes: List<Int>?): Series.Type? = when {
        seasons == null && episodes == null -> Series.Type.Unassigned
        seasons == singleSeason && episodes == emptyEpisode -> Series.Type.SeasonPack
        seasons == singleSeason && episodes == singleEpisode -> Series.Type.SingleEpisode
        seasons == singleSeason && episodes == multiEpisode -> Series.Type.MultiEpisodes
        seasons == multiSeason && episodes == emptyEpisode -> Series.Type.MultiSeasons
        else -> null
    }

    private fun <T : Any> Heddle.Companion.testHeddle(option: T?) =
        if (option != null) from(provider, option, true) else emptyHeddle()
}
