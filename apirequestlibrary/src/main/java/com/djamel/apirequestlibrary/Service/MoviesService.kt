package com.djamel.apirequestlibrary


import com.djamel.apirequestlibrary.Model.RateMovie
import com.djamel.apirequestlibrary.Model.WapperDetailsMovie
import com.djamel.apirequestlibrary.Model.WapperLastNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {
    @GET("{id}?api_key=d707987cde0dea1f51036f521ed41b37")
    fun listMovies(@Path("id") id: String?): Call<WapperMovie>

    @GET("{id}?api_key=d707987cde0dea1f51036f521ed41b37")
    fun detailsMovie(@Path("id") id: Int? ): Call<WapperDetailsMovie>

    @GET("top-headlines")
    fun lastNews(@Query( "country") codeCountry: String? , @Query( "apiKey") key : String ): Call<WapperLastNews>

    @POST("15322/5/api_key=d707987cde0dea1f51036f521ed41b37")
    fun rate() : Call<RateMovie>



}