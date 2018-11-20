package sample

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import timber.log.Timber

/**
 * Created by @iamBedant on 13/11/18.
 */
actual object Log{
    actual fun d(message: String) {
        Timber.d(message)
    }

    actual fun e(message: String) {
        Timber.e(message)
    }

    actual fun i(message: String) {
        Timber.i(message)
    }

    actual fun e(error: Throwable) {
        Timber.e(error)
    }
}

actual fun getMainDispetcher(): CoroutineDispatcher {
    return Dispatchers.Main
}