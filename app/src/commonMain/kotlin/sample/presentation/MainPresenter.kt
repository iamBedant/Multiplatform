package sample.presentation

import sample.Log
import sample.launchAndCatch
import kotlin.coroutines.CoroutineContext

/**
 * Created by @iamBedant on 13/11/18.
 */
class MainPresenter(
    private val uiContext: CoroutineContext,
    private val view: MainView,
    private val repository: DataRepository
) {

    fun loadData(userName: String) {
        launchAndCatch(uiContext, view::showError) {
            repository.getData(userName)
            showData()
        } finally {
            view.isUpdating = false
        }
    }

    private fun showData() {
        val userInfo = repository.data
        if(userInfo==null){
            Log.d("data is null")
        }

        userInfo?.let {
            view.displayData(it)
        }
    }
}