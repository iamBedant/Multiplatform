package sample

import android.view.View

/**
 * Created by @iamBedant on 20/11/18.
 */

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.hide(){
    this.visibility = View.GONE
}