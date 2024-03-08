package com.kaushalvasava.app.spofitytestapp.data.remote.model.audiobook

import com.google.gson.annotations.SerializedName
import com.kaushalvasava.app.spofitytestapp.data.remote.model.ExternalUrls
import com.kaushalvasava.app.spofitytestapp.data.remote.model.Image

data class Chapter(
    @SerializedName("audio_preview_url")
    val audioPreviewUrl: String,
    @SerializedName("available_markets")
    val availableMarkets: List<String>,
    @SerializedName("chapter_number")
    val chapterNumber: Int,
    val description: String,
    @SerializedName("duration_ms")
    val durationMs: Int,
    val explicit: Boolean,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    @SerializedName("html_description")
    val htmlDescription: String,
    val id: String,
    val images: List<Image>,
    @SerializedName("is_playable")
    val isPlayable: Boolean,
    val languages: List<String>,
    val name: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("release_date_precision")
    val releaseDatePrecision: String,
    val restrictions: Restrictions,
    @SerializedName("resume_point")
    val resumePoint: ResumePoint,
    val type: String,
    val uri: String,
)
