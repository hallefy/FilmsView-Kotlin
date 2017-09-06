package com.example.hallefy.filmskotlin.movieListTest

import com.example.hallefy.filmskotlin.NetworkAPI.models.MoviesResponse
import com.example.hallefy.filmskotlin.views.movielist.FilmesInteractor
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

/**
 * Created by hallefy on 04/09/17.
 */

@RunWith(MockitoJUnitRunner::class)
class ListagemInteractorTest {

    var observer = mock<Observer<MoviesResponse>>()

    val interactor = FilmesInteractor()

    @Test
    fun testRequest() {
        interactor.requestDados(1,observer)
    }

}