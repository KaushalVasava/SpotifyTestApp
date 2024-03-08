package com.kaushalvasava.app.spofitytestapp.data.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kaushalvasava.app.spofitytestapp.data.local.model.AlbumArtistsDb
import com.kaushalvasava.app.spofitytestapp.data.local.model.ExternalUrlsDb
import com.kaushalvasava.app.spofitytestapp.data.local.model.ImageDb

class ArtistsConverters {
    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToArtists(data: String): List<AlbumArtistsDb> {
        val listType = object : TypeToken<List<AlbumArtistsDb>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun artistsToString(someObjects: List<AlbumArtistsDb>): String {
        return gson.toJson(someObjects)
    }
}

class ExternalUrlsConverters {
    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToExternalUrls(data: String): ExternalUrlsDb {
        val listType = object : TypeToken<ExternalUrlsDb>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun externalUrlsToString(someObjects: ExternalUrlsDb): String {
        return gson.toJson(someObjects)
    }
}

class ImagesConverters {
    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToImages(data: String): List<ImageDb> {
        val listType = object : TypeToken<List<ImageDb>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun imagesToString(someObjects: List<ImageDb>): String {
        return gson.toJson(someObjects)
    }
}
class MarketStringsConverters {
    private var gson: Gson = Gson()

    @TypeConverter
    fun stringToMarkets(data: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun marketsToString(someObjects: List<String>): String {
        return gson.toJson(someObjects)
    }
}

