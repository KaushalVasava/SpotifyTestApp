package com.kaushalvasava.app.spofitytestapp.util.mappers

interface Mapper<IN, OUT> {
    fun to(input: IN): OUT
    fun from(out: OUT): IN
}

fun <IN, OUT> Mapper<IN, OUT>.to(list: List<IN>): List<OUT> {
    return list.map { this.to(it) }
}

fun <IN, OUT> Mapper<IN, OUT>.from(list: List<OUT>): List<IN> {
    return list.map { this.from(it) }
}

fun <IN, OUT> Mapper<IN, OUT>.to(input: IN?): OUT? {
    return if (input != null) this.to(input) else null
}

fun <IN, OUT> Mapper<IN, OUT>.from(out: OUT?): IN? {
    return if (out != null) this.from(out) else null
}