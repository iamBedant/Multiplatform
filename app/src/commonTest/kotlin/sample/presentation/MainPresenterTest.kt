package sample.presentation

import io.mockk.*
import kotlinx.coroutines.Dispatchers
import sample.*
import kotlin.test.*

/**
 * Created by @iamBedant on 03/12/18.
 */
@Ignore
open class MainPresenterTest {

    lateinit var view: MainView
    lateinit var repository: DataRepository
    lateinit var presenter: MainPresenter


    @BeforeTest
    fun initDeps() {

        view = mockk(relaxed = true)
        repository = mockk(relaxed = true)

        presenter = MainPresenter(
            view = view,
            repository = repository,
            uiContext = Dispatchers.Default
        )
    }

    @Test
    fun `when load data is empty, it shows an error message`() {

        presenter.loadData("")
        verify {
            view.showError(USER_NAME_NOT_VALID)

        }
    }

    @Test
    fun `shows loader while calling an API`() {

        presenter.loadData("iamBedant")
        verify {
            view.showLoader()
        }
    }

    @Test
    fun `calls getData and displays result if call is successfull`() = runTest {

        every { repository.data } returns allData
        presenter.loadData("iamBedant")
        coVerify {
            repository.getData("iamBedant")
        }
        verify(ordering = Ordering.ORDERED) {
            view.showLoader()
            view.hideLoader()
        }
    }


    @Test
    fun `if user name is valid show actual name`() {
        val displayData = presenter.getDisplayData(allData.copy("Test Name"))
        assertEquals(displayData.name, allData.name)
    }

    @Test
    fun `if user name is empty or null show login id as name`() {
        val displayData = presenter.getDisplayData(allData.copy(name = null))
        assertEquals(displayData.name, allData.login)
    }

    @Test
    fun `if user bio is valid show bio`() {
        val displayData = presenter.getDisplayData(allData.copy(bio = "This is test Bio"))
        assertEquals(displayData.bio, "This is test Bio")
    }

    @Test
    fun `if user bio is empty or null show no bio available`() {
        val displayData = presenter.getDisplayData(allData.copy(bio = null))
        assertEquals(displayData.bio, NO_BIO_AVAILABLE)
    }

    @Test
    fun `if user avatar is valid show avatar`() {
        val displayData = presenter.getDisplayData(allData.copy(avatar_url = "https://abc.def"))
        assertEquals(displayData.avatarUrl, "https://abc.def")
    }


    @Test
    fun `if user avatar is empty or null show default avatar`() {
        val displayData = presenter.getDisplayData(allData.copy(avatar_url = null))
        assertEquals(displayData.avatarUrl, DEFAULT_AVATAR)
    }

    @Test
    fun `shows gists and repos in proper format`() {
        val displayData = presenter.getDisplayData(allData.copy(public_gists = 4, public_repos = 5))
        assertEquals(displayData.publicGists, "4 $PUBLIC_GISTS")
        assertEquals(displayData.publicRepos, "5 $PUBLIC_REPOS")
    }

    @AfterTest
    fun tearDown() {

    }
}