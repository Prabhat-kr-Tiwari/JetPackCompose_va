package com.prabhat.movieapp.data

import com.prabhat.movieapp.network.ApiService
import javax.inject.Inject

class MovieDataSource @Inject constructor(private val apiService: ApiService) {


    suspend fun getMovieList()=apiService.getMovieList(apiKey = "b52b167cdd0627e0ecc0924ce311cf15")

    suspend fun getMovieDetails(id:String)=apiService.getMovieDetails(id,apiKey = "b52b167cdd0627e0ecc0924ce311cf15")
}