package com.kaushalvasava.app.spofitytestapp.data.remote.model.audiobook

data class Chapters(
    val href: String,
    val items: List<Chapter>,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: String,
    val total: Int
)