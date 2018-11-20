package sample

/**
 * Created by @iamBedant on 13/11/18.
 */
actual object Log {
    actual fun d(message: String) {
        print(message)
    }
    actual fun e(message: String) {
        print(message)
    }

    actual fun i(message: String) {
        print(message)
    }

    actual fun e(error: Throwable) {
        print(error)
    }
}