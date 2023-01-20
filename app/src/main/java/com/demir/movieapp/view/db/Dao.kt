package com.demir.movieapp.view.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demir.movieapp.view.model.Genre
import com.demir.movieapp.view.model.Movie

@Dao
interface Dao {
    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun insert(movie:Movie)
    @Query("SELECT*FROM movie ORDER BY id DESC")
    fun getMovie():LiveData<List<Movie>>
    @Delete
    suspend fun deleteMovie(movie: Movie)

}