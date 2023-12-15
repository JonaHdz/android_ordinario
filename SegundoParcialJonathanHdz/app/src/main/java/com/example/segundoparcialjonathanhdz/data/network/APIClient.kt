package com.example.segundoparcialjonathanhdz.data.network

import com.example.segundoparcialjonathanhdz.data.model.MovieDomain
import retrofit2.Response
import retrofit2.http.GET

interface APIClient
{
    @GET("movies/horror")
    suspend fun getAllMovies(): Response<List<MovieDomain>>

}