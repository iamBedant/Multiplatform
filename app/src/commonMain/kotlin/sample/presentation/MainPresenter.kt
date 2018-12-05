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
         repository.data?.let {
           view.displayData(getDisplayData(it))
        }
    }

    /**
     * Made this function internal to make it accessible while writing tests.
     */

    internal fun getDisplayData(allData : AllData) = DisplayData(
        name = allData.name ?: allData.login,
        publicGists = "${allData.public_gists} $PUBLIC_GISTS",
        publicRepos = "${allData.public_repos} $PUBLIC_REPOS",
        avatarUrl = allData.avatar_url ?: DEFAULT_AVATAR,
        bio = allData.bio ?: NO_BIO_AVAILABLE
    )
}