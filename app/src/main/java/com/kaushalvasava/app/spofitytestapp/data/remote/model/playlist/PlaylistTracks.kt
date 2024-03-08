package com.kaushalvasava.app.spofitytestapp.data.remote.model.playlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlaylistTracks(
    val href: String,
    val total: Int,
) : Parcelable