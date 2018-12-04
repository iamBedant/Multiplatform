package sample.presentation

import sample.*
import kotlin.coroutines.CoroutineContext

/**
 * Created by @iamBedant on 13/11/18.
 */
class MainPresenter(private val view: MainView,
                    private val repository: DataRepository,
                    private val uiContext: CoroutineContext = getMainDispetcher()) {

    fun loadData(userName: String) {
        if (userName.isNullOrEmpty()) {
            view.showError(USER_NAME_NOT_VALID)
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