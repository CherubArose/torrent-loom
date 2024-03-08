package org.torrentloom

import org.koin.core.qualifier.named
import org.koin.dsl.module

val injectionConfiguration = module {
    single<String>(named("injectionTest")) { "injected" }
}
