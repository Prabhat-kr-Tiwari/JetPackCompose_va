package com.prabhat.movieapp.navigation

sealed class MovieNavigationItem(val route:String) {

    object MovieList: MovieNavigationItem("movie_list")
    object MovieDetails: MovieNavigationItem("movie_details")

}