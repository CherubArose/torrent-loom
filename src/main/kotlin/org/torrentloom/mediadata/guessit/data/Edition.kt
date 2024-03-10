package org.torrentloom.mediadata.guessit.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.torrentloom.utils.ArrayWrappingSerializer

@Serializable
enum class Edition {
    Collector,
    Special,

    @SerialName("Director's Definitive Cut")
    DirectorDefinitiveCut,
    Criterion,
    Deluxe,
    Limited,
    Theatrical,

    @SerialName("Director's Cut")
    DirectorsCut,
    Extended,

    @SerialName("Alternative Cut")
    AlternativeCut,
    Remastered,
    Restored,
    Uncensored,
    Uncut,
    Unrated,
    Festival,

    @SerialName("IMAX")
    Imax,
    Fan,
    Ultimate,

    @SerialName("_Ultimate_Collector")
    UltimateCollector,

    @SerialName("_Ultimate_Fan")
    UltimateFan,
    ;

    object ListSerializer : ArrayWrappingSerializer<Edition>(serializer())
}
