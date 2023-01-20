package com.demir.movieapp.view.api

import com.demir.movieapp.view.model.Genres
import com.demir.movieapp.view.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.themoviedb.org/3/movie/now_playing?api_key=802b2c4b88ea1183e50e6b285a27696e
//https://api.themoviedb.org/3/genre/movie/list?api_key=802b2c4b88ea1183e50e6b285a27696e

interface MovieApi {
    @GET("movie/popular?api_key=802b2c4b88ea1183e50e6b285a27696e")
    suspend fun getPopularMovie(
        @Query("page")
        page:String
    ):Response<MovieResponse>

    @GET("movie/now_playing?api_key=802b2c4b88ea1183e50e6b285a27696e")
    suspend fun getRecentMovie(
        @Query("page")
        page:String
    ):Response<MovieResponse>
    @GET("genre/movie/list?api_key=802b2c4b88ea1183e50e6b285a27696e")
    suspend fun getGenres():Response<Genres>
    @GET("genre/movie/list?api_key=802b2c4b88ea1183e50e6b285a27696e")
    suspend fun getGenresx():Response<Genres>

}