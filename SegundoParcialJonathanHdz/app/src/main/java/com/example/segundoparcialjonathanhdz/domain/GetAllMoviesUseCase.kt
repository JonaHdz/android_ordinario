package com.example.segundoparcialjonathanhdz.domain

import com.example.segundoparcialjonathanhdz.data.MoviesRepository
import com.example.segundoparcialjonathanhdz.data.model.MovieDomain

class GetAllMoviesUseCase {
    private val repository = MoviesRepository()
    suspend operator fun invoke(): List<MovieDomain>? = repository.getAllMovies()
}