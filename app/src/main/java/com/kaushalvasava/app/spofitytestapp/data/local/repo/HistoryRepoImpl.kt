package com.kaushalvasava.app.spofitytestapp.data.local.repo

import com.kaushalvasava.app.spofitytestapp.data.local.dao.HistoryDao
import com.kaushalvasava.app.spofitytestapp.data.local.model.AlbumEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HistoryRepoImpl @Inject constructor(private val dao: HistoryDao) : HistoryRepo {
    override suspend fun upsertAlbum(album: AlbumEntity) {
        dao.insertUpdateAlbum(album)
    }

    override suspend fun deleteAlbum(album: AlbumEntity) {
        dao.deleteAlbum(album)
    }

    override fun getAllAlbums(): Flow<List<AlbumEntity>> {
        return dao.getAlbums()
    }

    override suspend fun getAlbumById(albumId: String): AlbumEntity {
        return dao.getAlbumById(albumId)
    }
//
    override suspend fun deleteAllAlbums() {
        dao.deleteAllAlbums()
    }
}