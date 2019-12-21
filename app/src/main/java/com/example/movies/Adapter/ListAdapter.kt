package com.example.movies.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.djamel.apirequestlibrary.MovieDataModel
import com.example.movies.OnItemClickListener

class ListAdapter(private val list: List<MovieDataModel>, var listener : OnItemClickListener)
    : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: MovieDataModel = list[position]
        holder.bind(movie, listener)
    }

    override fun getItemCount(): Int = list.size

}