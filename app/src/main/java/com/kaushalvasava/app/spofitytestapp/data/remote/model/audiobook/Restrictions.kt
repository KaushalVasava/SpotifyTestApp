package com.kaushalvasava.app.spofitytestapp.data.remote.model.audiobook

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Restrictions(
    val reason: String
): Parcelable