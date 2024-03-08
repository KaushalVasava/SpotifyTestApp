package com.kaushalvasava.app.spofitytestapp.data.remote.model.album

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.kaushalvasava.app.spofitytestapp.data.remote.model.ExternalUrls
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlbumArtists(
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val name: String,
    val type: String,
    val uri: String,
) : Parcelable