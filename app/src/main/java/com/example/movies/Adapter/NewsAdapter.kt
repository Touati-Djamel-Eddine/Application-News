package com.example.movies.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.djamel.apirequestlibrary.Model.LastNewsModel
import com.example.movies.OnItemClickListener
import com.example.movies.OnItemClickListenerNews

class NewsAdapter (private val list: List<LastNewsModel>, var listener : OnItemClickListenerNews)
    : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news : LastNewsModel = list[position]
        holder.bind(news,listener)
    }

    override fun getItemCount(): Int = list.size

}