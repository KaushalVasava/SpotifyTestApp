package com.kaushalvasava.app.spofitytestapp.data.remote.api

import com.kaushalvasava.app.spofitytestapp.data.remote.model.BaseResponse
import com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album
import com.kaushalvasava.app.spofitytestapp.data.remote.model.artist.Artist
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpotifyApi {
    @GET("search")
    suspend fun getQueryData(
        @Query("q") query: String,
        @Query("type") type: String,
    ): com.kaushalvasava.app.spofitytestapp.data.remote.model.BaseResponse


    @GET("albums/{albumId}")
    suspend fun getAlbum(
        @Path("albumId") albumId: String,
    ): com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album

    @GET("artists/{artistId}")
    suspend fun getArtist(
        @Path("artistId") artistId: String,
    ): com.kaushalvasava.app.spofitytestapp.data.remote.model.artist.Artist
}