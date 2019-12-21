package com.example.movies.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.djamel.apirequestlibrary.Model.LastNewsModel
import com.example.movies.OnItemClickListener
import com.example.movies.OnItemClickListenerNews
import com.example.movies.R
import com.squareup.picasso.Picasso

class NewsViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.news_layout, parent, false)) {
    private var mTitleView: TextView? = null
    private var mPublishedAt: TextView? = null
    private var mImageView: ImageView?=null


    init {
        mTitleView = itemView.findViewById(R.id.textViewTitle)
        mPublishedAt = itemView.findViewById((R.id.mPublishedAt))
        mImageView = itemView.findViewById(R.id.image_news)
    }

    fun bind(news: LastNewsModel,  listener : OnItemClickListenerNews) {

        mTitleView?.text = news.title
        mPublishedAt?.text= "Date : ${news.publishedAt.substring(0,10)}"


        val picasso = Picasso.get()
        picasso.load("${news.urlToImage}").into(mImageView)

        itemView.setOnClickListener(View.OnClickListener { listener.OnItemClick( news.url)})

    }


}