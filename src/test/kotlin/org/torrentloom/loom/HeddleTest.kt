package org.torrentloom.loom

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith


class HeddleTest {
    @Test
    fun `selection not in options fails to initialise`() {
        assertFailsWith<IllegalStateException> {
            Heddle(mapOf("1" to "2"), "3")
        }
    }

    @Test
    fun `selected is the current selection`() {
        val heddle = Heddle(mapOf("1" to "2"), "1")

        assertEquals("2", heddle.selected)
    }


    @Test
    fun `addOption adds a new entry`() {
        val heddle = Heddle.from("1", "2")
            .addOption("3", "4")

        assertEquals(Heddle(mapOf("1" to "2", "3" to "4")), heddle)
    }

    @Test
    fun `addOption overrides existing entry`() {
        val heddle = Heddle.from("1", "2")
            .addOption("1", "4")

        assertEquals(Heddle(mapOf("1" to "4")), heddle)
    }

    @Test
    fun `addAndSelectOption adds new entry`() {
        val heddle = Heddle.from("1", "2")
            .addAndSelectOption("3", "4")

        assertEquals(Heddle(mapOf("1" to "2", "3" to "4"), "3"), heddle)
    }

    @Test
    fun `addAndSelectOption overrides existing entry`() {
        val heddle = Heddle.from("1", "2")
            .addAndSelectOption("1", "4")

        assertEquals(Heddle(mapOf("1" to "4"), "1"), heddle)
    }

    @Test
    fun `addAndDefaultOption adds new entry and select it when there is no selection`() {
        val heddle = Heddle.from("1", "2")
            .addAndDefaultOption("3", "4")

        assertEquals(Heddle(mapOf("1" to "2", "3" to "4"), "3"), heddle)
    }

    @Test
    fun `addAndDefaultOption adds new entry and leave previous selection`() {
        val heddle = Heddle.from("1", "2", true)
            .addAndDefaultOption("3", "4")

        assertEquals(Heddle(mapOf("1" to "2", "3" to "4"), "1"), heddle)
    }

    @Test
    fun `selectOption changes the selection`() {
        val heddle = Heddle.from("1", "2")
            .addOption("3", "4")
            .selectOption("3")

        assertEquals(Heddle(mapOf("1" to "2", "3" to "4"), "3"), heddle)
    }

    @Test
    fun `selectOption fails when the selection does not exist`() {
        assertFailsWith<IllegalStateException> {
            Heddle.from("1", "2")
                .selectOption("N/A")
        }
    }
}
