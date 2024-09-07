package com.prabhat.movieapp.ui_layer

import com.prabhat.movieapp.model.Movie
import kotlin.jvm.internal.Ref.BooleanRef

data class MovieStateHolder(
    val isLoading:Boolean=false,
    val data:List<Movie>?=null,
    val error:String=""
)
