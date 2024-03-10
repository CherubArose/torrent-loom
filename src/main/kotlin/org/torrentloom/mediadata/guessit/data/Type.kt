package org.torrentloom.mediadata.guessit.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Type {
    @SerialName("episode")
    Episode,

    @SerialName("movie")
    Movie,
}
