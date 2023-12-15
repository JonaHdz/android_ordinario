package com.example.segundoparcialjonathanhdz.data.network

import com.example.segundoparcialjonathanhdz.core.RetrofitHelper
import com.example.segundoparcialjonathanhdz.data.model.MovieDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllMovies(): List<MovieDomain> {

        return withContext(Dispatchers.IO) {
            try {
                val response = retrofit.create(APIClient::class.java).getAllMovies()
                response.body() ?: emptyList()
            }catch (e : Exception){
                emptyList()
            }

        }


    }

}