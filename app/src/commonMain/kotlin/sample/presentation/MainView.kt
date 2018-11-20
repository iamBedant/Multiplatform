package sample.presentation
import sample.DisplayData

/**
 * Created by @iamBedant on 13/11/18.
 */
interface MainView : BaseView{
    fun displayData(data: DisplayData)
    fun showLoader()
    fun hideLoader()
}