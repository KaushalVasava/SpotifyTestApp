package com.kaushalvasava.app.spofitytestapp.data.remote.model.album

import kotlinx.serialization.SerialName

data class Albums(
    @SerialName("href") val href: String,
    @SerialName("limit") val limit: Int,
    @SerialName("next") val next: String,
    @SerialName("offset") val offset: Int?,
    @SerialName("previous") val previous: String?,
    @SerialName("total") val total: Int,
    @SerialName("items") val items: List<Album>,
)