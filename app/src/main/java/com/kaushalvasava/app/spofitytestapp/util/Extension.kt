package com.kaushalvasava.app.spofitytestapp.util

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.kaushalvasava.app.spofitytestapp.R

fun ImageView.setImage(artUri: String?, @DrawableRes errorDrawable: Int = R.drawable.ic_avatar) {
    Glide.with(context).load(artUri).error(errorDrawable)
        .transition(DrawableTransitionOptions.withCrossFade()).into(this)
}
