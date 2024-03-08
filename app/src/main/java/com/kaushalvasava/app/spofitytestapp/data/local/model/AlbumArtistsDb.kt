package com.kaushalvasava.app.spofitytestapp.data.local.model

import com.kaushalvasava.app.spofitytestapp.data.remote.model.ExternalUrls

data class AlbumArtistsDb(
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val name: String,
    val type: String,
    val uri: String,
)