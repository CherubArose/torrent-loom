package org.torrentloom.mediadata.guessit

import org.koin.core.component.inject
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.torrentloom.mediadata.MediaDataModule
import org.torrentloom.mediadata.guessit.data.GuessItData
import org.torrentloom.mediadata.guessit.fetcher.DefaultGuessItFetcher
import org.torrentloom.mediadata.guessit.fetcher.GuessItFetcher
import org.torrentloom.mediadata.guessit.parser.GuessItParser

object GuessItModule : MediaDataModule<GuessItData>() {
    override val moduleIdentifier: String by inject(named<GuessItModule>())
    override val fetcher: GuessItFetcher by inject(named<GuessItModule>())
    override val parser: GuessItParser by inject(named<GuessItModule>())

    override val defaultModuleConfiguration: Module = module {
        single(named<GuessItModule>()) { GuessItModule::class.simpleName!! }
        single<GuessItFetcher>(named<GuessItModule>()) { DefaultGuessItFetcher }
        single<GuessItParser>(named<GuessItModule>()) { GuessItParser(get(named<GuessItModule>())) }
    }

    override fun getMediaDataFormat() = mediaDataFormat<GuessItData>()
}
