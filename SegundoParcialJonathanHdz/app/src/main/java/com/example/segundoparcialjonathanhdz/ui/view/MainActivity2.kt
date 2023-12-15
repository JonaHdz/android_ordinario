package com.example.segundoparcialjonathanhdz.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.segundoparcialjonathanhdz.R
import com.example.segundoparcialjonathanhdz.data.model.MovieProvider
import com.example.segundoparcialjonathanhdz.databinding.ActivityMain2Binding
import com.example.segundoparcialjonathanhdz.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    lateinit var idmovie : String

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var intent = intent
        try {
            idmovie = intent.getStringExtra("key_idMovie").toString()
            loadInformationMovie()
        }catch (e:Exception)
        {

        }



    }

    private fun loadInformationMovie() {
        for (item in MovieProvider.movies){
            if(item.id == idmovie.toString().toInt()){
                binding.tbMovieInfo.text = item.title
                Picasso.get().load(item.posterURL).into(binding.imgMovie)
            }
        }
    }
}