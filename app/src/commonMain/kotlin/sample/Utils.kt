package sample

/**
 * Created by @iamBedant on 13/11/18.
 */

expect object Log{
    fun d(message: String)
    fun e(error:Throwable)
    fun e(message: String)
    fun i(message: String)
}
