package org.torrentloom.mediadata.guessit.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Source {
    @SerialName("Analog HDTV")
    AnalogHDTV,

    @SerialName("Blu-ray")
    Bluray,
    Camera,

    @SerialName("Digital Master")
    DigitalMaster,

    @SerialName("Digital TV")
    DigitalTV,
    DVD,

    @SerialName("HD Camera")
    HDCamera,

    @SerialName("HD Telecine")
    HDTelecine,

    @SerialName("HD Telesync")
    HDTelesync,

    @SerialName("HD-DVD")
    HDDVD,
    HDTV,

    @SerialName("Pay-per-view")
    PayPerView,
    Satellite,
    Telecine,
    Telesync,
    TV,

    @SerialName("Ultra HD Blu-ray")
    UltraHDBluray,

    @SerialName("Ultra HDTV")
    UltraHDTV,
    VHS,

    @SerialName("Video on Demand")
    VideoOnDemand,
    Web,
    Workprint,
}
