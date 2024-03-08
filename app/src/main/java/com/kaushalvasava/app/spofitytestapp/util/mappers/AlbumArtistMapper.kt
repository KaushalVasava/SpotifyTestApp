package com.kaushalvasava.app.spofitytestapp.util.mappers

import com.kaushalvasava.app.spofitytestapp.data.local.model.AlbumArtistsDb
import com.kaushalvasava.app.spofitytestapp.data.remote.model.ExternalUrls
import com.kaushalvasava.app.spofitytestapp.data.remote.model.album.AlbumArtists

class AlbumArtistMapper : Mapper<AlbumArtistsDb, AlbumArtists> {
    override fun to(input: AlbumArtistsDb): AlbumArtists {
        return AlbumArtists(
            externalUrls = input.externalUrls,
            href = input.href,
            id = input.id,
            name = input.name,
            type = input.type,
            uri = input.uri
        )
    }

    override fun from(out: AlbumArtists): AlbumArtistsDb {
        return AlbumArtistsDb(
            externalUrls = out.externalUrls,
            href = out.href,
            id = out.id,
            name = out.name,
            type = out.type,
            uri = out.uri
        )
    }
}