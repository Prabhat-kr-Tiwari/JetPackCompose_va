package com.prabhat.movieapp.ui_layer.details

import com.prabhat.movieapp.model.details.MovieDetails

data class MovieDetailsStateHolder (
    val isLoading:Boolean=false,
    val data:MovieDetails?=null,
    val error:String=""
)