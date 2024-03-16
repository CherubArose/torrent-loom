package org.torrentloom.mediadata.tmdb

import kotlinx.serialization.Serializable
import org.torrentloom.mediadata.MediaData

@Serializable
data class TmdbData(
    val id: Int,
    val title: String,
    val imdbId: String,
    val originalTitle: String,
    val originalLanguage: String, //TODO: Have structured language definition
    val year: Int,
    //val tvdbId: String?,
    //val keywords: Set<String>,
    //val genres: Set<String>,
    //val tmdbDirectors: Set<String>,
    //val overview: String,
    //val runtime: String, //TODO: Have runtime as a time
    //val poster: String?,
    //val videos: Set<??>, //TODO: Figure out what videos are and if a type is required
) : MediaData
