package com.kaushalvasava.app.spofitytestapp.data.remote.model.show

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.kaushalvasava.app.spofitytestapp.data.remote.model.ExternalUrls
import com.kaushalvasava.app.spofitytestapp.data.remote.model.Image
import kotlinx.parcelize.Parcelize

@Parcelize
data class Show(
    @SerializedName("available_markets")
    val availableMarkets: List<String>,
    val copyrights: List<String>,
    val description: String,
    val explicit: Boolean,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    @SerializedName("html_description")
    val htmlDescription: String,
    val id: String,
    val images: List<Image>,
    @SerializedName("is_externally_hosted")
    val isExternallyHosted: Boolean,
    val languages: List<String>,
    @SerializedName("media_type")
    val mediaType: String,
    val name: String,
    val publisher: String,
    @SerializedName("total_episodes")
    val totalEpisodes: Int,
    val type: String,
    val uri: String
) : Parcelable