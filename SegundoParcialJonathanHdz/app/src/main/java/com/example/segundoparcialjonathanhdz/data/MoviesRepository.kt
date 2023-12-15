package com.example.segundoparcialjonathanhdz.data

import com.example.segundoparcialjonathanhdz.data.model.MovieDomain
import com.example.segundoparcialjonathanhdz.data.model.MovieProvider
import com.example.segundoparcialjonathanhdz.data.network.MovieService

class MoviesRepository {
    private val api = MovieService()
    suspend fun getAllMovies(): List<MovieDomain> {
        val response = api.getAllMovies()
        MovieProvider.movies= response
        return response
    }
}