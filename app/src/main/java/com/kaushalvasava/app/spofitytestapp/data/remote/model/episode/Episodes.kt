package com.kaushalvasava.app.spofitytestapp.data.remote.model.episode

import com.google.gson.annotations.SerializedName

data class Episodes(
    @SerializedName("href") val href: String,
    @SerializedName("limit") val limit: Int,
    @SerializedName("next") val next: String,
    @SerializedName("offset") val offset: Int,
    @SerializedName("previous") val previous: String,
    @SerializedName("total") val total: Int,
    @SerializedName("items") val items: List<Episode?>,
)