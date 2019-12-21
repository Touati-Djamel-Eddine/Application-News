package com.example.movies.View.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.djamel.apirequestlibrary.Interface.MovieCallback
import com.djamel.apirequestlibrary.Interface.MovieDetailsCallback
import com.djamel.apirequestlibrary.Model.WapperDetailsMovie
import com.djamel.apirequestlibrary.MovieDataModel
import com.djamel.apirequestlibrary.`View-Model`.MovieViewModel
import com.example.movies.R
import com.example.movies.ServiceApplication.MovieServiceApplication
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity(),MovieDetailsCallback {


    private var movieViewModel = MovieViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        movieViewModel.getDetailsMovie(this, (application as MovieServiceApplication).getService().detailsMovie((intent.getIntExtra("idMovie",429203))))

    }

    override fun onSuccess(value: WapperDetailsMovie) {
        mPrograssBar.visibility= View.GONE
        mLinearLayout.visibility= View.VISIBLE
        movieTitle.setText(value.title)
        movieOverview.append(value.overview)
        movieOriginalLanguage.append(value.original_language)
        movieRelaseDate.append(value.release_date)
        movievoteAverage.append("${value.vote_average}  ⭐")
        //load picture
        val picasso = Picasso.get()
        picasso.load("https://image.tmdb.org/t/p/w500/${value.poster_path}").into(image_movie)
    }

    override fun onError() {
    }
}
