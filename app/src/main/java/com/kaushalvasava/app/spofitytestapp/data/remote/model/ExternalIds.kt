package com.kaushalvasava.app.spofitytestapp.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExternalIds(
    val isrc: String,
    val ean: String?,
    val upc: String?,
) : Parcelable