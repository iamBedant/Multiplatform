package sample.model

import kotlinx.serialization.json.JsonTreeParser
import kotlinx.serialization.json.content
import sample.AllData
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
            throw UpdateProblem()
        }

//        val result = AllData(JsonTreeParser(data).read().jsonObject["name"].content)
//        this.data = result

    }

    override suspend fun update() {
    }


}