package com.example.rxjavalearn.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjavalearn.R
import kotlinx.android.synthetic.main.activity_introduction.*

class IntroductionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)
        setSupportActionBar(toolbar)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        webview.loadUrl("file:///android_asset/introduction.html")
    }
}
