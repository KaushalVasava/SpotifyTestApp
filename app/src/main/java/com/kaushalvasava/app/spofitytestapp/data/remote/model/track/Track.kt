package com.kaushalvasava.app.spofitytestapp.data.remote.model.track

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.kaushalvasava.app.spofitytestapp.data.remote.model.ExternalIds
import com.kaushalvasava.app.spofitytestapp.data.remote.model.ExternalUrls
import com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album
import kotlinx.parcelize.Parcelize

@Parcelize
data class Track(
    val album: Album,
    val artists: List<TrackArtist>,
    @SerializedName("available_markets")
    val availableMarkets: List<String>,
    @SerializedName("disc_number")
    val discNumber: Int,
    @SerializedName("duration_ms")
    val durationMs: Long,
    val explicit: Boolean,
    @SerializedName("external_ids")
    val externalIds: ExternalIds,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    @SerializedName("is_local")
    val isLocal: Boolean,
    val name: String,
    val popularity: Int,
    @SerializedName("preview_url")
    val previewUrl: String?,
    @SerializedName("track_number")
    val trackNumber: Int,
    val type: String,
    val uri: String
) : Parcelable