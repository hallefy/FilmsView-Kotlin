package com.example.hallefy.filmskotlin.views.moviedetail

import android.content.Intent
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.hallefy.filmskotlin.R
import com.example.hallefy.filmskotlin.views.moviedetail.inject.DaggerDetailComponent
import com.example.hallefy.filmskotlin.views.moviedetail.inject.DetailModule
import com.example.hallefy.filmskotlin.views.movielist.utils.loadUrl
import javax.inject.Inject

class ActivityDetalhes : AppCompatActivity(), DetailMVP.View {


    @Inject
    lateinit var presenter : DetailPresenter
    var description : TextView? = null
    var imageFilm : ImageView? = null
    var release : TextView? = null
    var progressBar : ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        release = findViewById(R.id.tvRelease) as TextView
        description = findViewById(R.id.tvDescriptionFilm) as TextView
        imageFilm = findViewById(R.id.imgBannerFilm) as ImageView
        progressBar = findViewById(R.id.progressBarDetail) as ProgressBar

        DaggerDetailComponent.builder()
                .detailModule(DetailModule(this,this))
                .build()
                .inject(this)

        presenter.requestDetail(getReceivedData())
    }


    override fun setDescription(desc: String) {
        description!!.text = desc
    }

    override fun setImage(image: String) {
        imageFilm!!.loadUrl(image)
    }

    override fun setRelease(releaseFilm: String) {
        release!!.text = releaseFilm
    }

    override fun showProgressBar() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar!!.visibility = View.GONE
    }

    override fun getReceivedData(): Int {
        var intent : Intent? = intent
        var bundle : Bundle?

        bundle = intent!!.extras
        val id = bundle!!.getInt("id_movie")

        return id
    }

}
