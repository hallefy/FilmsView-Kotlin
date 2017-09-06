package com.example.hallefy.filmskotlin.views.moviedetail

import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.hallefy.filmskotlin.NetworkAPI.models.Movie
import com.example.hallefy.filmskotlin.R
import com.example.hallefy.filmskotlin.views.movielist.utils.loadUrl
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by hallefy on 28/08/17.
 */
class DetailPresenter @Inject constructor(private val interactor: DetailMVP.Interactor,
                                          private val view: DetailMVP.View): DetailMVP.Presenter,Observer<Movie>{



    override fun onNext(response : Movie?) {
        view.hideProgressBar()
        view.setDescription("Descrição: " + response!!.overview)
        view.setImage("https://image.tmdb.org/t/p/w500/"+response!!.backdropPath)
        view.setRelease("Release data:" + response!!.releaseDate)

    }

    override fun onSubscribe(d: Disposable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun onError(e: Throwable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun requestDetail(id_movie : Int) {
        view.showProgressBar()
        interactor.getMovieDetail(id_movie, this)
    }
}