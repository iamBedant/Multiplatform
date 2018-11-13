package sample.presentation

import sample.AllData

/**
 * Created by @iamBedant on 13/11/18.
 */
interface DataRepository{
    val data : AllData?
    suspend fun getData(username:String)
    suspend fun update()
}