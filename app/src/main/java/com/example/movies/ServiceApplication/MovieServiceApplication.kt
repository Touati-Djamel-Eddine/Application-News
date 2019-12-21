package com.example.movies.ServiceApplication

import android.app.Application
import com.djamel.apirequestlibrary.MoviesService
import com.djamel.apirequestlibrary.`View-Model`.MovieViewModel
import com.example.movies.View.UI.MainActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MovieServiceApplication : Application() {

    private lateinit  var retrofit : Retrofit
    private lateinit var service : MoviesService

    // Called when the application is starting, before any other application objects have been created.
    // Overriding this method is totally optional!
    override fun onCreate() {
        super.onCreate()
    }

    fun seturl (url : String) {

        retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(MoviesService::class.java)
    }

    fun getService () : MoviesService {
        return service
    }



}