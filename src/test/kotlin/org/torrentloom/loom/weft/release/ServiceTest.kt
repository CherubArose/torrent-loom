package org.torrentloom.loom.weft.release

import kotlin.test.Test
import kotlin.test.assertTrue

class ServiceTest {
    @Test
    fun ensureNoDuplicateServiceNames() {
        val duplicateServices = Service.entries
            .flatMap { (listOf(it.name) + it.alternativeNames).map { name -> name to it } }
            .groupBy({ (name, _) -> name }, { (_, service) -> service })
            .filter { it.value.size > 1 }

        assertTrue(duplicateServices.isEmpty(), "Found duplicate entries: $duplicateServices")
    }
}
