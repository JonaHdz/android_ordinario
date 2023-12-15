package com.example.segundoparcialjonathanhdz.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.segundoparcialjonathanhdz.R
import com.example.segundoparcialjonathanhdz.data.model.MovieDomain
import com.example.segundoparcialjonathanhdz.data.model.MovieProvider
import com.example.segundoparcialjonathanhdz.databinding.ActivityMainBinding
import com.example.segundoparcialjonathanhdz.ui.viewModel.MovieViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val movieViewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieViewModel.onCreate()
        setListenerViewModel()
    }

    private fun setListenerViewModel() {
        movieViewModel.movieViewModel.observe(this){
            println("lista de peliculas "+ MovieProvider.movies.size)
            loadView()
        }
    }

    //carga las peliculas en el recycleView
    private fun loadView() {
        val adapter = MovieAdapter()
        adapter.context = this
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = adapter
        for (position in 0 until MovieProvider.movies.size) {
            adapter.setItem(MovieProvider.movies[position])
        }

    }

    private fun setListenerBtn() {
        val adapterMovies = binding.rvMovies.adapter as MovieAdapter
        for (position in 0 until adapterMovies.itemCount) {
            val viewHolder = binding.rvMovies.findViewHolderForAdapterPosition(position) as? MovieAdapter.movieItemViewHolder
            if (viewHolder != null) {
                viewHolder.btnShowMovie.setOnClickListener(){
                    println("clic desde main")
                }
            }
        }
    }

    fun nextView(id : Int){
        val intent = Intent(this, MainActivity2::class.java)
        // Agrega el String al Intent como un extra
        intent.putExtra("key_idMovie", id.toString())
        // Inicia la nueva Activity
        startActivity(intent)
    }
}