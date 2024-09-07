package com.prabhat.movieapp.network

import com.prabhat.movieapp.model.MovieListResponse
import com.prabhat.movieapp.model.details.MovieDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

//    https://api.themoviedb.org/3/movie/popular?api_key=b52b167cdd0627e0ecc0924ce311cf15
//https://api.themoviedb.org/3/movie/76600?api_key=b52b167cdd0627e0ecc0924ce311cf15
    @GET("3/movie/popular")
    suspend fun getMovieList(
        @Query("api_key") apiKey:String
    ):MovieListResponse



    @GET("/3/movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id :String,
        @Query("api_key") apiKey:String
    ):MovieDetails
}