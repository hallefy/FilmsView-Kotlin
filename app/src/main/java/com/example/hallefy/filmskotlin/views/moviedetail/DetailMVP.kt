package com.example.hallefy.filmskotlin.views.moviedetail

import android.widget.ImageView
import com.example.hallefy.filmskotlin.NetworkAPI.models.Movie
import io.reactivex.Observable
import io.reactivex.Observer

/**
 * Created by hallefy on 28/08/17.
 */

interface DetailMVP {

    interface Interactor {
        fun getMovieDetail(id_movie: Int, observer: Observer<Movie>)
        fun cancelRequest()
    }


    interface Presenter {
        fun requestDetail(id_movie: Int)
    }

    interface View {
        fun getReceivedData() : Int
        fun setDescription(description: String)
        fun setImage(image : String)
        fun setRelease(release : String)
        fun showProgressBar()
        fun hideProgressBar()
    }

}
