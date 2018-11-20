package sample.presentation

import sample.DisplayData
import sample.Log
import sample.getMainDispetcher
import sample.launchAndCatch
import sample.model.DataRepositoryImpl
import kotlin.coroutines.CoroutineContext

/**
 * Created by @iamBedant on 13/11/18.
 */
class MainPresenter(private val view: MainView) {

    private val uiContext = getMainDispetcher()
    private val repository = DataRepositoryImpl()

    fun loadData(userName: String) {
        if (userName.isNullOrEmpty()) {
            view.showError(Throwable("Please enter a valid user name"))
        } else {
            view.showLoader()
            launchAndCatch(uiContext, view::showError) {
                repository.getData(userName)
                showData()
            } finally {
                view.hideLoader()
            }
        }
    }

    private fun showData() {
        val userInfo = repository.data

        if (userInfo == null) {
            Log.d("data is null")
        }
        userInfo?.let {
            val displayData = DisplayData(
                name = userInfo.name ?: userInfo.login,
                publicGists = "${userInfo.public_gists} Public Gists",
                publicRepos = "${userInfo.public_repos} Public Repos",
                avatarUrl = userInfo.avatar_url ?: "https://api.adorable.io/avatars/285/abott@adorable.png",
                bio = userInfo.bio ?: "No Bio Available"
            )
            view.displayData(displayData)
        }
    }
}