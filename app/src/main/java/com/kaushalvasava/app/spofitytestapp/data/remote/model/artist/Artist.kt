package com.kaushalvasava.app.spofitytestapp.data.remote.model.artist

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import com.kaushalvasava.app.spofitytestapp.data.remote.model.ExternalUrls
import com.kaushalvasava.app.spofitytestapp.data.remote.model.Followers
import com.kaushalvasava.app.spofitytestapp.data.remote.model.Image
import kotlinx.parcelize.Parcelize

@Entity("artist_table")
@Parcelize
data class Artist(
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val followers: Followers,
    val genres: List<String>,
    val href: String,
    val id: String,
    val images: List<Image>,
    val name: String,
    val popularity: Int,
    val type: String,
    val uri: String,
): Parcelable