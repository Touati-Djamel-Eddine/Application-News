package com.example.movies.View.UI

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.djamel.apirequestlibrary.Interface.LastNewsCallback
import com.djamel.apirequestlibrary.MovieDataModel


import com.example.movies.Adapter.ListAdapter
import com.djamel.apirequestlibrary.Interface.MovieCallback
import com.djamel.apirequestlibrary.Model.LastNewsModel
import com.djamel.apirequestlibrary.`View-Model`.MovieViewModel
import com.example.movies.Adapter.NewsAdapter
import com.example.movies.ServiceApplication.MovieServiceApplication
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import android.widget.AdapterView
import com.example.movies.*


class MainActivity : AppCompatActivity() , MovieCallback, LastNewsCallback, AdapterView.OnItemSelectedListener{

    companion object {
        private const val MOVIEURLREQUESTAPI: String = "https://api.themoviedb.org/3/movie/"
        private const val NEWSURLREQUESTAPI: String = "https://newsapi.org/v2/"
    }


    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerNewsView: RecyclerView
    private var movieViewModel = MovieViewModel()
    private lateinit  var service : MovieServiceApplication
    private lateinit var progressBar : ProgressBar

    private lateinit var imageAddMovie: ImageView

    private var list_of_items = arrayOf("be", "us", "fr")
    private var list_of_items_movie = arrayOf("popular", "top_rated")
    private var country = "be"
    private var keySearch = "popular"

    private lateinit var movie : MovieViewModel
    private var listMovie = ArrayList<MovieDataModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.list_recycler_view)
        recyclerNewsView = findViewById<RecyclerView>(R.id.news_recycler_view)
        progressBar = findViewById<ProgressBar>(R.id.mPrograssBarNews)
        imageAddMovie = findViewById(R.id.imageButton)

        imageButton.isClickable = true;
        imageButton.setOnClickListener{
            var intent = Intent(this@MainActivity, addMovie::class.java)
            startActivity(intent)
        }
        service = (application as MovieServiceApplication)

        getListMovie()


        mButton.setOnClickListener(View.OnClickListener {
            getListMovie()
        })

        mButtonNews.setOnClickListener(View.OnClickListener {
            getLastNews()
        })

        if(BuildConfig.BUILD_TYPE == "debug") {
            Timer().schedule(object : TimerTask(){
                override fun run() {
                    getLastNews()
                }}, 0,600*1000)
        } else {
            Timer().schedule(object : TimerTask(){
                override fun run() {
                    getLastNews()
                }}, 0,600*1000)
        }



        val spinnerMovie: Spinner = findViewById(R.id.spinnerMovie)
        spinnerMovie.setOnItemSelectedListener(this)
        // Create an ArrayAdapter using a simple spinner layout and languages array
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_items_movie)
        // Set layout to use when the list of choices appear
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinnerMovie.setAdapter(arrayAdapter)



        val spinner: Spinner = findViewById(R.id.spinnerNews)
        spinner.setOnItemSelectedListener(this)
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_items)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(aa)


    }

    fun addMovie(movie : MovieDataModel){
        listMovie.add(movie)
    }



    fun getListMovie(){
        mPrograssBar.visibility= View.VISIBLE
        recyclerView.visibility=View.INVISIBLE
        imageAddMovie.visibility= View.INVISIBLE
        service.seturl(MOVIEURLREQUESTAPI)
        movieViewModel.getListMovie(this, service.getService().listMovies(keySearch))
    }

    fun getLastNews(){
        ServiceAsynctask(progressBar, recyclerNewsView,imageAddMovie).execute()
        service.seturl(NEWSURLREQUESTAPI)
        movieViewModel.getLastNews(this,(service.getService().lastNews(country, "511b81375acf4b80be0e0c1236c7f218")))
    }



    //Adapter Movie recyclerView

    private fun adapterView(mlist : ArrayList<MovieDataModel>){
        listMovie = mlist
        val layout_Manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        var listener = object : OnItemClickListener {
            override fun OnItemClick(id : Int) {
                service.seturl(MOVIEURLREQUESTAPI)
                var intent = Intent(this@MainActivity, DetailsActivity::class.java)
                intent.putExtra("idMovie",id)
                startActivity(intent)

            }
        }

        recyclerView.apply {
            layoutManager = layout_Manager
            adapter = ListAdapter(mlist,listener)

        }

    }



    //Adapter News RecyclerView
    private fun adapterNewsView(mlist : List<LastNewsModel>){
        val layout_Manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        var listener = object : OnItemClickListenerNews{
            override fun OnItemClick(url: String) {
                service.seturl(MOVIEURLREQUESTAPI)
                var intent = Intent(this@MainActivity, activity_details_news::class.java)
                intent.putExtra("url",url)
                startActivity(intent)

            }

        }
        recyclerNewsView.apply {
            layoutManager = layout_Manager
            adapter = NewsAdapter(mlist, listener)

        }

    }



    //Implementation Movie Callback
    override fun onError() {
        mPrograssBar.visibility= View.INVISIBLE
        Toast.makeText(this,"erreur !", Toast.LENGTH_SHORT)
    }

    override fun onSuccess(value: ArrayList<MovieDataModel>) {
        mPrograssBar.visibility= View.GONE
        recyclerView.visibility= View.VISIBLE
        imageAddMovie.visibility=View.VISIBLE
        Log.d("debug", "data :$value")
        adapterView(value)
    }




    //Implementation News callback

    override fun getNewsOnSuccess(value: ArrayList<LastNewsModel>) {
        progressBar.visibility= View.GONE
        recyclerNewsView.visibility= View.VISIBLE
        adapterNewsView(value)
    }

    override fun getNewsOnError() {

    }

    class ServiceAsynctask (progressBar: ProgressBar, recyclerView: RecyclerView, imageButton: ImageView) : AsyncTask<Int, Int, Int>(){
        var progressBar2 = progressBar
        var recyclerView2 = recyclerView
        var imageView = imageButton
        override fun doInBackground(vararg params: Int?): Int {
            return 0
        }

        override fun onPostExecute(result: Int?) {
            super.onPostExecute(result)
            progressBar2.visibility= View.VISIBLE
            imageView.visibility= View.INVISIBLE
            recyclerView2.visibility= View.INVISIBLE
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        if (parent.id == R.id.spinnerMovie) {
            keySearch = list_of_items_movie[pos]
            getListMovie()
        } else if (parent.id == R.id.spinnerNews) {
            country = list_of_items[pos]
            getLastNews()
        }
    }



}
