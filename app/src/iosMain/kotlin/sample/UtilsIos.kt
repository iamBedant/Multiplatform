package sample

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.runBlocking
import platform.Foundation.NSRunLoop
import platform.Foundation.performBlock
import kotlin.coroutines.CoroutineContext

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

object MainLoopDispatcher: CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        NSRunLoop.mainRunLoop().performBlock {
            block.run()
        }
    }
}

actual fun getMainDispetcher(): CoroutineDispatcher {
    return MainLoopDispatcher
}

actual fun <T> runTest(block: suspend () -> T) {
    runBlocking { block() }
}