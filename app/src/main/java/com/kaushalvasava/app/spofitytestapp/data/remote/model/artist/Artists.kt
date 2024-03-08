package com.kaushalvasava.app.spofitytestapp.data.remote.model.artist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artists(
    val href: String?,
    val items: List<Artist>,
    val limit: Int,
    val next: String?,
    val offset: Int,
    val previous: String?,
    val total: Int,
): Parcelable