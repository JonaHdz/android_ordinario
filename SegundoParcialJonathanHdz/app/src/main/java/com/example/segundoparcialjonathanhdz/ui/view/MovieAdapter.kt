package com.example.segundoparcialjonathanhdz.ui.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.segundoparcialjonathanhdz.data.model.MovieDomain
import com.example.segundoparcialjonathanhdz.R

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.movieItemViewHolder>(){
    private var movies = mutableListOf<MovieDomain>()
    lateinit var context : MainActivity
    inner class movieItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val movieName : TextView = itemView.findViewById(R.id.tvMovieItem)
        val btnShowMovie : TextView = itemView.findViewById(R.id.btnShowMovie)


        fun bind(movieItem : MovieDomain) {

            movieName.text = movieItem.title
            btnShowMovie.setOnClickListener(){
                selectMovie(movieItem.title)
            }
        }

        private fun selectMovie(text: String) {
            println("peli "+ text)
            for (item in movies){
                if(item.title.equals(text)){
                    context.nextView(item.id)
                }
            }
        }
    }
    fun setItem(movieItem : MovieDomain){
        movies.add(movieItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.movieItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return movieItemViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MovieAdapter.movieItemViewHolder,
        position: Int
    ) {
        val step = movies[position]
        holder.bind(step)
    }

    override fun getItemCount(): Int {
        return movies.count()
    }
}