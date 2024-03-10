package org.torrentloom.mediadata.guessit.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.torrentloom.utils.ArrayWrappingSerializer

@Serializable
enum class Other {
    `2in1`,
    `3D`,

    @SerialName("Audio Fixed")
    AudioFixed,
    Bonus,

    @SerialName("BT.2020")
    BT2020,
    Classic,
    Colorized,
    Complete,
    Converted,
    Documentary,

    @SerialName("Dolby Vision")
    DolbyVision,

    @SerialName("Dual Audio")
    DualAudio,

    @SerialName("East Coast Feed")
    EastCoastFeed,
    Extras,

    @SerialName("Fan Subtitled")
    FanSubtitled,

    @SerialName("Fast Subtitled")
    FastSubtitled,

    @SerialName("Full HD")
    FullHD,

    @SerialName("Hardcoded Subtitles")
    HardcodedSubtitles,
    HD,
    HDR10,

    @SerialName("High Frame Rate")
    HighFrameRate,
    Hybrid,

    @SerialName("Variable Frame Rate")
    VariableFrameRate,

    @SerialName("High Quality")
    HighQuality,

    @SerialName("High Resolution")
    HighResolution,
    Internal,

    @SerialName("Line Dubbed")
    LineDubbed,

    @SerialName("Line Audio")
    LineAudio,

    @SerialName("Mic Dubbed")
    MicDubbed,

    @SerialName("Micro HD")
    MicroHD,
    Mux,
    NTSC,
    Obfuscated,

    @SerialName("Open Matte")
    OpenMatte,

    @SerialName("Original Aspect Ratio")
    OriginalAspectRatio,

    @SerialName("Original Video")
    OriginalVideo,
    PAL,
    Preair,
    Proof,
    Proper,

    @SerialName("PS Vita")
    PSVita,

    @SerialName("Read NFO")
    ReadNFO,

    @SerialName("Region 5")
    Region5,

    @SerialName("Region C")
    RegionC,
    Reencoded,
    Remux,
    Repost,
    Retail,
    Rip,
    Sample,
    Screener,
    SECAM,

    @SerialName("Standard Dynamic Range")
    StandardDynamicRange,

    @SerialName("Straight to Video")
    StraightToVideo,

    @SerialName("Sync Fixed")
    SyncFixed,
    Trailer,

    @SerialName("Ultra HD")
    UltraHD,
    Upscaled,

    @SerialName("West Coast Feed")
    WestCoastFeed,
    Widescreen,
    XXX,
    ;

    object ListSerializer : ArrayWrappingSerializer<Other>(serializer())
}
