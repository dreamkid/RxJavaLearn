package com.example.rxjavalearn.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rxjavalearn.R
import kotlinx.android.synthetic.main.activity_introduction.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toIntroduction(view:View) {
        startActivity(Intent(this,IntroductionActivity::class.java))
    }

    fun toSimpleUse(view:View) {

    }

    fun toThreadSchedule(view: View) {

    }
}
