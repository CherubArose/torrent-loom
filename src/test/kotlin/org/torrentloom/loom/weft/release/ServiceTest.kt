package org.torrentloom.loom.weft.release

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.expect

class ServiceTest {
    @Test
    fun ensureNoDuplicateServiceNames() {
        val duplicateServices = Service.entries
            .flatMap { (listOf(it.name) + it.alternativeNames).map { name -> name to it } }
            .groupBy({ (name, _) -> name }, { (_, service) -> service })
            .filter { it.value.size > 1 }

        assertTrue(duplicateServices.isEmpty(), "Found duplicate entries: $duplicateServices")
    }

    @Test
    fun ensureNoPoorlyNamedServices() {
        val poorlyNamedServices = Service.entries.filterNot { it.name.matches(Regex("^[A-Z0-9]+$", RegexOption.IGNORE_CASE)) }

        assertTrue(poorlyNamedServices.isEmpty(), "Found badly named services: $poorlyNamedServices")
    }
}
