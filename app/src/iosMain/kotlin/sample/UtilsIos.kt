package sample

/**
 * Created by @iamBedant on 13/11/18.
 */
actual class Log {
    actual fun d(message: String) {
        print(message)
    }
    actual fun e(message: String) {
        print(message)
    }

    actual fun i(message: String) {
        print(message)
    }
}