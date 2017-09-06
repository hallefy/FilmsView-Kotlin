package com.example.hallefy.filmskotlin.MovieDetailTest

import android.app.Activity
import android.widget.ProgressBar
import com.example.hallefy.filmskotlin.NetworkAPI.models.Movie
import com.example.hallefy.filmskotlin.NetworkAPI.models.MoviesResponse
import com.example.hallefy.filmskotlin.views.moviedetail.DetailInteractor
import com.example.hallefy.filmskotlin.views.moviedetail.DetailMVP
import com.example.hallefy.filmskotlin.views.moviedetail.DetailPresenter
import com.nhaarman.mockito_kotlin.mock
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

/**
 * Created by hallefy on 31/08/17.
 */


@RunWith(MockitoJUnitRunner::class)
class DetailPresenterTest{

    private val view = mock<DetailMVP.View>()
    private val interactor = DetailInteractor()
    private val presenter = DetailPresenter(interactor,view)

    @Test
    fun testRequestDetail() {
        presenter.requestDetail(1)
    }

    @Test
    fun testOnNext() {

        val movies = Movie("teste","teste","data",1,"titulo","titulobr",
                "backdropPath",9.9)
        val r : Response<Movie> = Response.success(movies)
        presenter.onNext(r.body())
    }

}