package org.torrentloom.mediadata.guessit

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.torrentloom.loom.Shuttle
import org.torrentloom.mediadata.MediaDataModule
import org.torrentloom.mediadata.guessit.data.GuessItData
import org.torrentloom.mediadata.guessit.fetcher.DefaultGuessItFetcher
import org.torrentloom.mediadata.guessit.fetcher.GuessItFetcher
import org.torrentloom.mediadata.guessit.parser.GuessItParser

object GuessItModule : MediaDataModule<GuessItData>(), KoinComponent {
    override val fetcher: GuessItFetcher by inject(named(moduleIdentifier))
    override val parser: GuessItParser by inject(named(moduleIdentifier))

    override val defaultModuleConfiguration = module {
        single<GuessItParser>(named(moduleIdentifier)) { GuessItParser(moduleIdentifier) }
        single<GuessItFetcher>(named(moduleIdentifier)) { DefaultGuessItFetcher }
    }
}
