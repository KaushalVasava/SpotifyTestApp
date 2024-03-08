package com.kaushalvasava.app.spofitytestapp.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Followers(
    val href: String?,
    val total: Int
) : Parcelable