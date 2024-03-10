package org.torrentloom.mediadata.guessit.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.torrentloom.mediadata.MediaData
import org.torrentloom.utils.listserializer.IntListSerializer
import org.torrentloom.utils.listserializer.StringListSerializer

/**
 * https://github.com/guessit-io/guessit/blob/develop/docs/properties.md
 */
@Serializable
data class GuessItData(
    /**
     * Type of the file.
     */
    val type: Type? = null,
    /**
     * Title of movie or episode.
     */
    val title: String? = null,
    /**
     * Other titles found for movie.
     */
    @SerialName("alternative_title")
    val alternativeTitle: String? = null,
    /**
     * Container of the file.
     *
     * - 3g23gp
     * - 3gp2
     * - asf
     * - ass
     * - avi
     * - divx
     * - flv
     * - idx
     * - iso
     * - m4v
     * - mk2
     * - mk3d
     * - mkv
     * - mka
     * - mov
     * - mp4
     * - mp4a
     * - mpeg
     * - mpg
     * - nfo
     * - nzb
     * - ogg
     * - ogm
     * - ogv
     * - qt
     * - ra
     * - ram
     * - rm
     * - srt
     * - ssa
     * - sub
     * - torrent
     * - ts
     * - vob
     * - wav
     * - webm
     * - wma
     * - wmv
     */
    val container: String? = null,
    /**
     * Mime type of the related container. Guessed values may vary based on OS native support of mime type.
     */
    val mimetype: String? = null,
    /**
     * Date found in filename.
     */
    val date: String? = null, // TODO: Convert to a better format
    /**
     * Year of movie (or episode).
     */
    val year: Int? = null,
    /**
     * Week number, from 1 to 52, of episode.
     */
    val week: Int? = null,
    /**
     * Name of (non)scene group that released the file.
     */
    @SerialName("release_group")
    val releaseGroup: String? = null,
    /**
     * Name of website contained in the filename.
     */
    val website: String? = null,
    /**
     *
     */
    @SerialName("streaming_service")
    val streamingService: String? = null, // TODO: Convert to the known Enum
    /**
     * Season number. (Can be a list if several are found)
     */
    @SerialName("season")
    @Serializable(with = IntListSerializer::class)
    val seasons: List<Int>? = null, // TODO: check the case of single vs multiple seasons && Int vs String
    /**
     * Episode number. (Can be a list if several are found)
     */
    @SerialName("episode")
    @Serializable(with = IntListSerializer::class)
    val episodes: List<Int>? = null, // TODO: check the case of single vs multiple episodes && Int vs String
    /**
     * Disc number. (Can be a list if several are found)
     */
    @Serializable(with = IntListSerializer::class)
    val disc: List<Int>? = null, // TODO: check the case of single vs multiple discs && Int vs String
    /**
     * Total number of episodes.
     */
    @SerialName("episode_count")
    val episodeCount: Int? = null,
    /**
     * Total number of seasons.
     */
    @SerialName("season_count")
    val seasonCount: Int? = null,
    /**
     * Some details about the episode.
     * - Final
     * - Pilot
     * - Special
     * - Unaired
     */
    @SerialName("episode_details")
    val episodeDetails: String? = null,
    /**
     * Episode format of the series.
     * - Minisode
     */
    @SerialName("episode_format")
    val episodeFormat: String? = null,
    /**
     * In anime fansub scene, new versions are released with tag `<episode>v[0-9]`.
     */
    val version: Int? = null,

    // Video properties
    /**
     * Source of the release
     */
    val source: Source? = null,
    /**
     * Resolution of video.
     *
     * - `<width>x<height>`
     * - `360i`
     * - `360p`
     * - `368p`
     * - `480i`
     * - `480p`
     * - `540i`
     * - `540p`
     * - `576i`
     * - `576p`
     * - `720p`
     * - `900i`
     * - `900p`
     * - `1080i`
     * - `1080p`
     * - `1440p`
     * - `2160p`
     * - `4320p`
     */
    @SerialName("screen_size")
    val screenSize: String? = null,
    /**
     * Aspect ratio of video. Calculated using width and height from `screen_size`
     */
    @SerialName("aspect_ratio")
    val aspectRatio: String? = null,
    /**
     * Codec used for video.
     *
     * - `DivX`
     * - `H.263`
     * - `H.264`
     * - `H.265`
     * - `MPEG-2`
     * - `RealVideo`
     * - `VP7`
     * - `VP8`
     * - `VP9`
     * - `Xvid`
     */
    @SerialName("video_codec")
    val videoCodec: String? = null,
    /**
     * Codec profile used for video.
     *
     * - `Baseline`
     * - `High`
     * - `High 10`
     * - `High 4:2:2`
     * - `High 4:4:4 Predictive`
     * - `Main`
     * - `Extended`
     * - `Scalable Video Coding`
     * - `Advanced Video Codec High Definition`
     * - `High Efficiency Video Coding`
     */
    @SerialName("video_profile")
    val videoProfile: String? = null,
    /**
     * Bit depth used for video.
     *
     * - `8-bit`
     * - `10-bit`
     * - `12-bit`
     */
    @SerialName("color_depth")
    val colorDepth: String? = null,
    /**
     * API used for the video.
     *
     * `DXVA`
     */
    @SerialName("video_api")
    val videoApi: String? = null,
    /**
     * Video bit rate (Mbps). Examples: `25Mbps` (`<BitRate [25Mbps]>`), `40Mbps` (`<BitRate [40Mbps]>`).
     *
     * `[<guessit.BitRate>]` (object has `magnitude` and `units`)
     */
    @SerialName("video_bit_rate")
    val videoBitRate: String? = null,
    /**
     * Video frame rate (frames per second). Examples: `25fps` (`<FrameRate [25fps]>`), `60fps` (`<FrameRate [60fps]>`).
     *
     * `[<guessit.FrameRate>]` (object has `magnitude` and `units`)
     */
    @SerialName("frame_rate")
    val frameRate: String? = null,

    // Audio properties
    /**
     * Number of channels for audio.
     *
     * - `1.0`
     * - `2.0`
     * - `5.1`
     * - `7.1`
     */
    @SerialName("audio_channels")
    val audioChannels: String? = null,
    /**
     * Codec used for audio.
     *
     * - `AAC`
     * - `Dolby Atmos`
     * - `Dolby Digital`
     * - `Dolby Digital Plus`
     * - `Dolby TrueHD`
     * - `DTS`
     * - `FLAC`
     * - `LPCM`
     * - `MP2`
     * - `MP3`
     * - `Opus`
     * - `PCM`
     * - `Vorbis`
     */
    @SerialName("audio_codec")
    val audioCodec: String? = null,
    /**
     * The codec profile used for audio.
     *
     * - `Extended Surround`
     * - `EX`
     * - `High Efficiency`
     * - `High Quality`
     * - `High Resolution Audio`
     * - `Low Complexity`
     * - `Master Audio`
     */
    @SerialName("audio_profile")
    val audioProfile: String? = null,
    /**
     * Audio bit rate (Kbps, Mbps). Examples: `448Kbps` (`<BitRate [448Kbps]>`), `1.5Mbps` (`<BitRate [1.5Mbps]>`).
     *
     * `[<guessit.BitRate>]` (object has `magnitude` and `units`)
     */
    @SerialName("audio_bit_rate")
    val audioBitRate: String? = null,

    // Localization properties

    /**
     * Country(ies) of content. Often found in series, `Shameless (US)` for instance.
     *
     * `[<babelfish.Country>]` (This class equals name and iso code)
     */
    val country: String? = null,
    /**
     * Language(s) of the audio soundtrack.
     *
     * `[<babelfish.Language>]` (This class equals name and iso code)
     */
    @SerialName("language")
    @Serializable(with = StringListSerializer::class)
    val languages: List<String>? = null,
    /**
     * Language(s) of the subtitles.
     *
     * `[<babelfish.Language>]` (This class equals name and iso code)
     */
    @SerialName("subtitle_language")
    @Serializable(with = StringListSerializer::class)
    val subtitleLanguages: List<String>? = null,

    // Other properties

    /**
     * Bonus number.
     */
    val bonus: String? = null,
    /**
     * Bonus title.
     */
    @SerialName("bonus_title")
    val bonusTitle: String? = null,
    /**
     * CD number.
     */
    val cd: Int? = null,
    /**
     * Total count of CD.
     */
    @SerialName("cd_count")
    val cdCount: Int? = null,
    /**
     * CRC32 of the file.
     */
    val crc32: String? = null,
    /**
     * Volume identifier (UUID).
     */
    val uuid: String? = null,
    /**
     * Size (MB, GB, TB).
     *
     * Examples: `1.2GB` (`<Size [1.2GB]>`), `430MB` (`<Size [430MB]>`).
     * - `[<guessit.Size>]` (object has `magnitude` and `units`)
     */
    val size: String? = null,
    /**
     * Edition of the movie.
     */
    @Serializable(with = Edition.ListSerializer::class)
    val edition: List<Edition>? = null,
    /**
     * Film number of this movie.
     */
    val film: String? = null,
    /**
     * Film title of this movie.
     */
    @SerialName("film_title")
    val filmTitle: String? = null,
    /**
     * Film series of this movie.
     */
    @SerialName("film_series")
    val filmSeries: String? = null,
    /**
     * Other property will appear under this property.
     */
    @Serializable(with = Other.ListSerializer::class)
    val other: List<Other>? = null,
) : MediaData
