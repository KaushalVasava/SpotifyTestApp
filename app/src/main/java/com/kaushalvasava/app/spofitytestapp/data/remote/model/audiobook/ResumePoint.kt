package com.kaushalvasava.app.spofitytestapp.data.remote.model.audiobook

import com.google.gson.annotations.SerializedName

data class ResumePoint(
    @SerializedName("fully_played") val fullyPlayed: Boolean,
    @SerializedName("resume_position_ms") val resumePositionMs: Int
)