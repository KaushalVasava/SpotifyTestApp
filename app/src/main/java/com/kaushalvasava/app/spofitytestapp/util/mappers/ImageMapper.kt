package com.kaushalvasava.app.spofitytestapp.util.mappers

import com.kaushalvasava.app.spofitytestapp.data.local.model.ImageDb
import com.kaushalvasava.app.spofitytestapp.data.remote.model.Image

class ImageMapper : Mapper<ImageDb, Image> {
    override fun to(input: ImageDb): Image {
        return Image(
            input.height,
            input.url,
            input.width
        )
    }

    override fun from(out: Image): ImageDb {
        return ImageDb(
            out.height,
            out.url,
            out.width
        )
    }
}