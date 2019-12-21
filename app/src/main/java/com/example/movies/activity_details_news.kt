package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details_news.*

class activity_details_news : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_news)

        run {
            val webSettings = mWebView.getSettings()
            mWebView.getSettings().setSupportZoom(true)
            mWebView.getSettings().setBuiltInZoomControls(true)
            webSettings.setJavaScriptEnabled(true)
            mWebView.loadUrl(intent.getStringExtra("url"))
        }
    }
}
