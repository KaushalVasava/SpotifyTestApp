package com.kaushalvasava.app.spofitytestapp.data.remote.model

import com.google.gson.annotations.SerializedName
import com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Albums
import com.kaushalvasava.app.spofitytestapp.data.remote.model.artist.Artists
import com.kaushalvasava.app.spofitytestapp.data.remote.model.audiobook.Audiobooks
import com.kaushalvasava.app.spofitytestapp.data.remote.model.episode.Episodes
import com.kaushalvasava.app.spofitytestapp.data.remote.model.playlist.Playlists
import com.kaushalvasava.app.spofitytestapp.data.remote.model.show.Shows
import com.kaushalvasava.app.spofitytestapp.data.remote.model.track.Tracks


data class BaseResponse(
    @SerializedName("tracks") val tracks: Tracks?,
    @SerializedName("artists") val artists: Artists?,
    @SerializedName("albums") val albums: Albums?,
    @SerializedName("playlists") val playlists: Playlists?,
    @SerializedName("shows") val shows: Shows?,
    @SerializedName("episodes") val episodes: Episodes?,
    @SerializedName("audiobooks") val audiobooks: Audiobooks?,
)