package sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import sample.model.DataRepositoryImpl
import sample.presentation.MainPresenter
import sample.presentation.MainView
import timber.log.Timber
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), MainView {
    override var isUpdating: Boolean by Delegates.observable(false) { _, _, isUpdating ->
        Timber.d(isUpdating.toString())
    }
    lateinit var tvName: TextView
    override fun displayData(data: AllData) {
        tvName.text = data.name
    }

    override fun showError(error: Throwable) {
        error.localizedMessage?.let {
            Toast.makeText(this, error.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }


    private val repository by lazy { DataRepositoryImpl() }

    private val presenter by lazy { MainPresenter(Dispatchers.Main, this, repository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvName = findViewById(R.id.tvName)
        presenter.loadData("iamBedant")

    }
}