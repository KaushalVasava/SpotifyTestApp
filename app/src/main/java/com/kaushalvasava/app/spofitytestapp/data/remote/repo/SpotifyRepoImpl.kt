package com.kaushalvasava.app.spofitytestapp.data.remote.repo

import com.kaushalvasava.app.spofitytestapp.data.remote.api.SpotifyApi

class SpotifyRepoImpl(
    private var api: SpotifyApi,
) : SpotifyRepo {

    override suspend fun getQueryData(query: String, type: String): com.kaushalvasava.app.spofitytestapp.data.remote.model.BaseResponse {
        return api.getQueryData(query, type)
    }

    override suspend fun getAlbum(albumId: String): com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album {
        return api.getAlbum(albumId)
    }

    override suspend fun getArtist(artistId: String): com.kaushalvasava.app.spofitytestapp.data.remote.model.artist.Artist {
        return api.getArtist(artistId)
    }
}