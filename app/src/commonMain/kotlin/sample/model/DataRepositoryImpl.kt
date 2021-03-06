package sample.model

import sample.AllData
import sample.Log
import sample.api.NetworkApi
import sample.api.UpdateProblem
import sample.presentation.DataRepository

/**
 * Created by @iamBedant on 13/11/18.
 */
class DataRepositoryImpl : DataRepository {

    private val api = NetworkApi("https://github.com")
    override var data: AllData? = null

    override suspend fun getData(username: String) {

        val data = try {
            api.getAll(username)
        } catch (cause: Throwable) {
            Log.e(cause)

            throw UpdateProblem()
        }

        this.data = data

    }

    override suspend fun update() {
    }


}