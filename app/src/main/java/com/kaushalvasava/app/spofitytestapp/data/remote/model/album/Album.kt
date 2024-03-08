package com.kaushalvasava.app.spofitytestapp.data.remote.model.album

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.kaushalvasava.app.spofitytestapp.data.remote.model.ExternalUrls
import com.kaushalvasava.app.spofitytestapp.data.remote.model.Image
import com.kaushalvasava.app.spofitytestapp.data.remote.model.audiobook.Restrictions
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(
    @SerializedName("album_type") val albumType: String,
    @SerializedName("total_tracks") val totalTracks: Int,
    @SerializedName("available_markets") val availableMarkets: List<String>,
    @SerializedName("external_urls") val externalUrls: ExternalUrls?,
    @SerializedName("href") val href: String,
    @SerializedName("id") val id: String,
    @SerializedName("images") val images: List<Image>,
    @SerializedName("name") val name: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("release_date_precision") val releaseDatePrecision: String,
    @SerializedName("restrictions") val restrictions: Restrictions?,
    @SerializedName("type") val type: String,
    @SerializedName("uri") val uri: String,
    @SerializedName("artists") val artists: List<AlbumArtists>,
): Parcelable