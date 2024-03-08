package com.kaushalvasava.app.spofitytestapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kaushalvasava.app.spofitytestapp.data.local.converter.ArtistsConverters
import com.kaushalvasava.app.spofitytestapp.data.local.converter.ExternalUrlsConverters
import com.kaushalvasava.app.spofitytestapp.data.local.converter.ImagesConverters
import com.kaushalvasava.app.spofitytestapp.data.local.converter.MarketStringsConverters
import com.kaushalvasava.app.spofitytestapp.data.local.dao.HistoryDao
import com.kaushalvasava.app.spofitytestapp.data.local.model.AlbumEntity
import com.kaushalvasava.app.spofitytestapp.data.local.model.Artist
import com.kaushalvasava.app.spofitytestapp.data.local.model.Playlist

@Database(
    entities = [AlbumEntity::class, Artist::class, Playlist::class],
    version = 1
)
@TypeConverters(
    MarketStringsConverters::class,
    ArtistsConverters::class,
    ImagesConverters::class,
    ExternalUrlsConverters::class,
)
abstract class HistoryDatabase : RoomDatabase() {
    abstract val historyDao: HistoryDao
}



