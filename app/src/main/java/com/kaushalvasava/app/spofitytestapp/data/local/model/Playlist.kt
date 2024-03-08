package com.kaushalvasava.app.spofitytestapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("playlist_table")
data class Playlist(
    @PrimaryKey(autoGenerate = false) val id: String,
    val name: String,
)