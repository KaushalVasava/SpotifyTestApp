package com.kaushalvasava.app.spofitytestapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("artist_table")
data class Artist(
    @PrimaryKey(autoGenerate = false) val id: String,
    val name: String,
)