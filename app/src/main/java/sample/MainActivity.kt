package sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import sample.model.DataRepositoryImpl
import sample.presentation.MainPresenter
import sample.presentation.MainView
import timber.log.Timber
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), MainView {

    override fun showLoader() {
        pb.show()
        tvBio.hide()
        tvName.hide()
        tvGists.hide()
        tvRepos.hide()
        ivAvatar.hide()
    }

    override fun hideLoader() {
        pb.hide()
        tvBio.show()
        tvName.show()
        tvGists.show()
        tvRepos.show()
        ivAvatar.show()
    }

    override fun displayData(data: DisplayData) {
        with(data) {
            tvName.text = name
            Glide.with(this@MainActivity).load(avatarUrl).into(ivAvatar)
            tvRepos.text = publicRepos
            tvGists.text = publicGists
            tvBio.text = bio
        }
    }

    override fun showError(error: Throwable) {
        error.localizedMessage?.let {
            Toast.makeText(this, error.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    private val presenter by lazy { MainPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fabGo.setOnClickListener {
            presenter.loadData(etUserName.text.toString())
        }
    }
}