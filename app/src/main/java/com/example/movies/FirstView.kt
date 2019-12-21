package com.example.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import com.example.movies.View.UI.MainActivity

class FirstView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_first_view)

        val splash_time_out = 2000
        Handler().postDelayed({
            val intent = Intent(this@FirstView, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splash_time_out.toLong())
    }
}
