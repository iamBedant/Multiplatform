package sample

import timber.log.Timber

/**
 * Created by @iamBedant on 13/11/18.
 */
actual class Log{
    actual fun d(message: String) {
        Timber.d(message)
    }

    actual fun e(message: String) {
        Timber.e(message)
    }

    actual fun i(message: String) {
        Timber.i(message)
    }
}