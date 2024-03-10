package org.torrentloom.loom

fun interface HeddleOptionsChecker<T : Any> {
    fun check(check: T): Boolean
}
