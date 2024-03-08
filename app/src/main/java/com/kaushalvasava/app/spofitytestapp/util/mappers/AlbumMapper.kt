package com.kaushalvasava.app.spofitytestapp.util.mappers

import com.kaushalvasava.app.spofitytestapp.data.local.model.AlbumEntity
import com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album

class AlbumMapper : Mapper<AlbumEntity, Album> {
    private val imageMapper: ImageMapper by lazy {
        ImageMapper()
    }
    private val albumArtistsMapper: AlbumArtistMapper by lazy {
        AlbumArtistMapper()
    }

    override fun to(input: AlbumEntity): Album {
        return Album(
            albumType = input.albumType,
            totalTracks = input.totalTracks,
            availableMarkets = input.availableMarkets,
            externalUrls = null,
            href = input.href,
            images = imageMapper.to(input.images),
            id = input.id,
            name = input.name,
            releaseDate = input.releaseDate,
            releaseDatePrecision = input.releaseDatePrecision,
            restrictions = null,
            type = input.type,
            uri = input.uri,
            artists = albumArtistsMapper.to(input.artists)
        )
    }

    override fun from(out: Album): AlbumEntity {
        return AlbumEntity(
            albumType = out.albumType,
            totalTracks = out.totalTracks,
            availableMarkets = out.availableMarkets,
            href = out.href,
            images = imageMapper.from(out.images),
            id = out.id,
            name = out.name,
            releaseDate = out.releaseDate,
            releaseDatePrecision = out.releaseDatePrecision,
            type = out.type,
            uri = out.uri,
            artists = albumArtistsMapper.from(out.artists)
        )

    }
}