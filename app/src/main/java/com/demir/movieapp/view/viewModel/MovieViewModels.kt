package com.demir.movieapp.view.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.demir.movieapp.view.model.Genre
import com.demir.movieapp.view.model.Genres
import com.demir.movieapp.view.model.Movie
import com.demir.movieapp.view.model.MovieResponse
import com.demir.movieapp.view.repository.MovieRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieViewModels(app:Application):AndroidViewModel(app) {
val repository=MovieRepository(app)
    val popularMovie=MutableLiveData<MovieResponse>()
    val recentMovie=MutableLiveData<MovieResponse>()
    val genresMovie=MutableLiveData<Genres>()
    val loading= MutableLiveData<Boolean>()
    var page=1



    fun getPopularMovies()=viewModelScope.launch {
        loading.value=true
       val response = repository.getPopularMovie(page.toString())
        if (response.isSuccessful){
            response.body()?.let {
                popularMovie.value=it


            }
        }

    }
    fun getRecentMovies()=viewModelScope.launch {

        val response=repository.getRecentMovie(page.toString())
        if (response.isSuccessful){
            response.body()?.let {
                recentMovie.value=it
            }
        }
    }

    fun getGenres()=viewModelScope.launch {

       val response= repository.getGenres()
        if (response.isSuccessful){
            response.body()?.let {
                genresMovie.value=it
            }
        }
    }
    fun insertMovie(movie: Movie)=viewModelScope.launch {
        repository.insertMovie(movie)
    }
    fun delete(movie: Movie)=viewModelScope.launch {
        repository.deleteMovie(movie)
    }
    fun readMovies():LiveData<List<Movie>>{
       return repository.readMovies()
    }

}