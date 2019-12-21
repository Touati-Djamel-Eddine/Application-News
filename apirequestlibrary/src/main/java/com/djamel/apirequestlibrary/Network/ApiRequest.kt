package com.djamel.apirequestlibrary.Network

import com.djamel.apirequestlibrary.Model.RateMovie
import com.djamel.apirequestlibrary.Model.WapperDetailsMovie
import com.djamel.apirequestlibrary.WapperMovie
import com.djamel.apirequestlibrary.`View-Model`.MovieViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.os.AsyncTask.execute
import com.djamel.apirequestlibrary.Model.WapperLastNews
import java.util.*


open class ApiRequest  {



    fun getPopularMovie(movieViewModel: MovieViewModel, movieRequest : Call<WapperMovie>){


        movieRequest.enqueue(object : Callback<WapperMovie> {

            override fun onFailure(call: Call<WapperMovie>, t: Throwable) {
                movieViewModel.notifyObservateurError()
            }

            override fun onResponse(call: Call<WapperMovie>, response: Response<WapperMovie>)  {
                val allCourse = response.body()
                allCourse?.let { movieViewModel.notifyObservateurSuccess(it.results) }
            }

        })


    }

    fun getDetailsMovie(movieViewModel: MovieViewModel, movieRequest : Call<WapperDetailsMovie>){


        movieRequest.enqueue(object : Callback<WapperDetailsMovie> {

            override fun onFailure(call: Call<WapperDetailsMovie>, t: Throwable) {
                movieViewModel.notifyObservateurError()
            }

            override fun onResponse(call: Call<WapperDetailsMovie>, response: Response<WapperDetailsMovie>)  {
                val allCourse = response.body()
                allCourse?.let { movieViewModel.notifyObservateurSuccessDetails(allCourse ) }
            }

        })


    }

    fun rateMovie( movieRate : Call<RateMovie>){

            movieRate.enqueue(object : Callback<RateMovie> {
                override fun onFailure(call: Call<RateMovie>, t: Throwable) {
                }

                override fun onResponse(call: Call<RateMovie>, response: Response<RateMovie>) {
                }


            })
    }


    fun getLastNews(movieViewModel: MovieViewModel, lastNewsRequest : Call<WapperLastNews>){




                lastNewsRequest.enqueue(object : Callback<WapperLastNews> {

                    override fun onFailure(call: Call<WapperLastNews>, t: Throwable) {
                        movieViewModel.notifyObservateurError()
                    }

                    override fun onResponse(
                        call: Call<WapperLastNews>,
                        response: Response<WapperLastNews>
                    ) {
                        val allLastNews = response.body()
                        allLastNews?.let { movieViewModel.notifyObservateurLastNewsSuccess(it.articles) }
                    }

                })


    }



}