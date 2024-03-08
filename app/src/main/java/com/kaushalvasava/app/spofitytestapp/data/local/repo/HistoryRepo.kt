package com.kaushalvasava.app.spofitytestapp.data.local.repo

import com.kaushalvasava.app.spofitytestapp.data.local.model.AlbumEntity
import kotlinx.coroutines.flow.Flow

interface HistoryRepo {

    suspend fun upsertAlbum(album: AlbumEntity)

    suspend fun deleteAlbum(album: AlbumEntity)

    fun getAllAlbums(): Flow<List<AlbumEntity>>

    suspend fun getAlbumById(albumId: String): AlbumEntity

    suspend fun deleteAllAlbums()
}