package com.kaushalvasava.app.spofitytestapp.data.remote.model.show

import com.google.gson.annotations.SerializedName


data class Shows(
    @SerializedName("href") val href: String,
    @SerializedName("limit") val limit: Int,
    @SerializedName("next") val next: String,
    @SerializedName("offset") val offset: Int,
    @SerializedName("previous") val previous: String,
    @SerializedName("total") val total: Int,
    @SerializedName("items") val items: List<Show?>,
)