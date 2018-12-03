package sample.presentation

import io.mockk.*
import kotlinx.coroutines.Dispatchers
import sample.*
import kotlin.test.BeforeTest
import kotlin.test.Test

/**
 * Created by @iamBedant on 03/12/18.
 */
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
    fun `calls getData and display result if call is successfull`() = runTest {

        every { repository.data } returns allData
        presenter.loadData("iamBedant")

        coVerify {
            repository.getData("iamBedant")
        }

        verify( ordering = Ordering.ORDERED) {
            view.showLoader()
            view.displayData(getDisplayData(allData))
            view.hideLoader()
        }
    }
}