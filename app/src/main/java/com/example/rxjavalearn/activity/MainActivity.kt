package com.example.rxjavalearn.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rxjavalearn.R
import kotlinx.android.synthetic.main.activity_introduction.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern
import java.util.Collections.replaceAll



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun toIntroduction(view: View) {
        startActivity(Intent(this, IntroductionActivity::class.java))
    }

    fun toSimpleUse(view: View) {
        startActivity(Intent(this, SimpleUseActivity::class.java))
    }

    fun toThreadSchedule(view: View) {
        startActivity(Intent(this,ThreadScheduleActivity::class.java))
    }

}
