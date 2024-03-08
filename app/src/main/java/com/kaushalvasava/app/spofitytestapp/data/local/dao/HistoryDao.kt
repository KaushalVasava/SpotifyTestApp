package com.kaushalvasava.app.spofitytestapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.kaushalvasava.app.spofitytestapp.data.local.model.AlbumEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Query(
        "SELECT * FROM album_table"
    )
    fun getAlbums(): Flow<List<AlbumEntity>>

//    @Query(
//        "SELECT * FROM artist_table"
//    )
//    fun getArtists(): Flow<List<Artist>>

    @Upsert
    suspend fun insertUpdateAlbum(album: AlbumEntity)

    @Delete
    suspend fun deleteAlbum(album: AlbumEntity)


    @Query("SELECT * FROM album_table WHERE id = :albumId")
    suspend fun getAlbumById(albumId: String): AlbumEntity

    @Query("DELETE FROM album_table")
    suspend fun deleteAllAlbums()
}