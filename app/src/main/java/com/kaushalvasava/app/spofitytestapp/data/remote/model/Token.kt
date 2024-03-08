package com.kaushalvasava.app.spofitytestapp.data.remote.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName

data class Token(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("expires_in")
    val expiresIn: Int,
    @SerializedName("token_type")
    val tokenType: String
)