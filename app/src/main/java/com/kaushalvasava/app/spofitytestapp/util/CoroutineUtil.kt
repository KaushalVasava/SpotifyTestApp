package com.kaushalvasava.app.spofitytestapp.util

import kotlin.coroutines.cancellation.CancellationException

inline fun <M> runCoroutineCatching(block: () -> M, errorBlock: (Throwable) -> M): M {
    return try {
        block()
    } catch (cancellationException: CancellationException) {
        throw cancellationException
    } catch (e: Throwable) {
        errorBlock(e)
    }
}