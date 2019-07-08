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

        tv_test.text = resources.getString(R.string.text)

    }

    fun toIntroduction(view: View) {
        startActivity(Intent(this, IntroductionActivity::class.java))
    }

    fun toSimpleUse(view: View) {
        startActivity(Intent(this, SimpleUseActivity::class.java))
    }

    fun toThreadSchedule(view: View) {

    }

    fun formatStr(view: View) {
        var content = et_test.text.toString()
        content = removeStartBlankLine(content)
        val formatStr = removeEndBlankLine(content)
        val p = Pattern.compile("(\r?\n(\\s*\r?\n)+)")
        val m = p.matcher(content)
        val groupCount = m.groupCount()
        if (groupCount > 1) {
            content = m.replaceAll("\n\n")
        } else {
            content = m.replaceAll("\n")
        }

        tv_test.text = formatStr
    }

    private fun removeEndBlankLine(comment: String): String {
        if (comment.endsWith("\n")) {
            val lastIndexOf = comment.lastIndexOf("\n")
            val formatStr = comment.substring(0, lastIndexOf)
            return removeEndBlankLine(formatStr)
        } else {
            return comment
        }
    }

    fun publish(view: View) {
        val content = et_test.text.toString()
        tv_test.text = content
    }

    private fun removeStartBlankLine(comment: String): String {
        if (comment.startsWith("\n")) {
            val formatStr = comment.substring("\n".length , comment.length)
            return removeStartBlankLine(formatStr)
        } else {
            return comment
        }
    }
}
