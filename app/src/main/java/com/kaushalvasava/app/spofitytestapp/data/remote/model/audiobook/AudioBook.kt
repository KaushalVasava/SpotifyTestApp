package com.kaushalvasava.app.spofitytestapp.data.remote.model.audiobook

import com.google.gson.annotations.SerializedName
import com.kaushalvasava.app.spofitytestapp.data.remote.model.ExternalUrls
import com.kaushalvasava.app.spofitytestapp.data.remote.model.Image

data class AudioBook(
    val authors: List<Author>,
    @SerializedName("available_markets")
    val availableMarkets: List<String>,
    val chapters: Chapters,
    val copyrights: List<Copyright>,
    val description: String,
    val edition: String,
    val explicit: Boolean,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    @SerializedName("html_description")
    val htmlDescription: String,
    val id: String,
    val images: List<Image>,
    val languages: List<String>,
    @SerializedName("media_type")
    val mediaType: String,
    val name: String,
    val narrators: List<Narrator>,
    val publisher: String,
    @SerializedName("total_chapters")
    val totalChapters: Int,
    val type: String,
    val uri: String,
)