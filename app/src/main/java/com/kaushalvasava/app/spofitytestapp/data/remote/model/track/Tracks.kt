package com.kaushalvasava.app.spofitytestapp.data.remote.model.track

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tracks(
    val href: String,
    val items: List<Track?>,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: String?,
    val total: Int
) : Parcelable