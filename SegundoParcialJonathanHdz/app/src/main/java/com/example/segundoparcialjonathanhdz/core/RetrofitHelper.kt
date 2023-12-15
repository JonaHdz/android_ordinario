package com.example.segundoparcialjonathanhdz.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.sampleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}