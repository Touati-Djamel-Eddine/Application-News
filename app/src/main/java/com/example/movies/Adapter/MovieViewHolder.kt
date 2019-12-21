package com.example.movies.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.djamel.apirequestlibrary.MovieDataModel
import com.example.movies.R
import com.squareup.picasso.Picasso
import com.example.movies.OnItemClickListener

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup ) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.movie_layout, parent, false)) {
    private var mTitleView: TextView? = null
    private var mMovieVoteAvrage: TextView? = null
    private var mImageView: ImageView?=null


    init {
        mTitleView = itemView.findViewById(R.id.textViewTitle)
        mMovieVoteAvrage = itemView.findViewById((R.id.movieAvrageVote))
        mImageView = itemView.findViewById(R.id.image_movie)
    }

    fun bind(movie: MovieDataModel,  listener : OnItemClickListener) {

        mTitleView?.text = movie.title
        mMovieVoteAvrage?.text= "${movie.vote_average} ⭐"

        val picasso = Picasso.get()
        Log.d("debug","${movie.poster_path}")
        picasso.load("https://image.tmdb.org/t/p/w500/${movie.poster_path}").into(mImageView)





        itemView.setOnClickListener(View.OnClickListener { listener.OnItemClick(movie.id)})
    }


}


