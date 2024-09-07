package com.prabhat.movieapp.di

import com.prabhat.movieapp.data.MovieDataSource
import com.prabhat.movieapp.data.MovieRepository
import com.prabhat.movieapp.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {



    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    }

    @Provides
    fun provideApiService(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)

    }

    @Provides
    fun provideDataSource(apiService: ApiService):MovieDataSource{
        return MovieDataSource(apiService)

    }
    @Provides
    fun provideMovieRepo(dataSource: MovieDataSource):MovieRepository{
        return MovieRepository(dataSource)

    }
}