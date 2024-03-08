package com.kaushalvasava.app.spofitytestapp.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.kaushalvasava.app.spofitytestapp.data.local.converter.ArtistsConverters
import com.kaushalvasava.app.spofitytestapp.data.local.converter.ExternalUrlsConverters
import com.kaushalvasava.app.spofitytestapp.data.local.converter.ImagesConverters
import com.kaushalvasava.app.spofitytestapp.data.local.converter.MarketStringsConverters

@Entity("album_table")
@TypeConverters(
    MarketStringsConverters::class,
    ImagesConverters::class,
    ExternalUrlsConverters::class,
    ArtistsConverters::class
)
data class AlbumEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("album_type") val albumType: String,
    @ColumnInfo("total_tracks") val totalTracks: Int,
    @ColumnInfo("available_markets") val availableMarkets: List<String>,
    @ColumnInfo("href") val href: String,
    @ColumnInfo("images") val images: List<ImageDb>,
    @ColumnInfo("release_date") val releaseDate: String,
    @ColumnInfo("release_date_precision") val releaseDatePrecision: String,
    @ColumnInfo("type") val type: String,
    @ColumnInfo("uri") val uri: String,
    @ColumnInfo("artists") val artists: List<AlbumArtistsDb>,
)