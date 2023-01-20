package com.demir.movieapp.view.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.demir.movieapp.view.api.ApiService
import com.demir.movieapp.view.db.MovieDataBase
import com.demir.movieapp.view.model.Genre
import com.demir.movieapp.view.model.Genres
import com.demir.movieapp.view.model.Movie
import com.demir.movieapp.view.model.MovieResponse
import retrofit2.Response

class MovieRepository(application:Application) {
    val apıService= ApiService
    val movieDataBase=MovieDataBase(application)

    suspend fun getPopularMovie(page:String):Response<MovieResponse>{
        return apıService.api.getPopularMovie(page)
    }
    suspend fun getRecentMovie(page:String):Response<MovieResponse> {
        return apıService.api.getRecentMovie(page)
    }
    suspend fun getGenres():Response<Genres>{
        return apıService.api.getGenres()
    }
    suspend fun insertMovie(movie: Movie){
        movieDataBase.movieDao().insert(movie)
    }
    suspend fun deleteMovie(movie: Movie){
        movieDataBase.movieDao().deleteMovie(movie)
    }
    fun readMovies():LiveData<List<Movie>>{
        return movieDataBase.movieDao().getMovie()
    }

}