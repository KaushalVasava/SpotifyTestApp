package com.kaushalvasava.app.spofitytestapp.data.remote.repo

import com.kaushalvasava.app.spofitytestapp.data.remote.model.BaseResponse
import com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album
import com.kaushalvasava.app.spofitytestapp.data.remote.model.artist.Artist

interface SpotifyRepo {
    suspend fun getQueryData( query: String, type: String): com.kaushalvasava.app.spofitytestapp.data.remote.model.BaseResponse

    suspend fun getAlbum(albumId: String): com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album

    suspend fun getArtist(artistId: String): com.kaushalvasava.app.spofitytestapp.data.remote.model.artist.Artist
}