package sample.presentation

import sample.AllData

/**
 * Created by @iamBedant on 13/11/18.
 */
interface MainView : BaseView{
    var isUpdating: Boolean
    fun displayData(data: AllData)
}