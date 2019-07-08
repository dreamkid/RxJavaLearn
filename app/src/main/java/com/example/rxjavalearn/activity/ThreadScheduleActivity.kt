package com.example.rxjavalearn.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.example.rxjavalearn.R
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_simple_use.*
import java.lang.Thread.sleep

class ThreadScheduleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_use)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { finish() }
        webview.loadUrl("file:///android_asset/threadscheduler.html")
    }

    fun testNet(view: View) {
        startLoading()
        Observable.create(
            object : ObservableOnSubscribe<String> {
                override fun subscribe(e: ObservableEmitter<String>?) {
                    e ?: return
                    sleep(2000)
                    e.onNext("请求成功")
                    e.onComplete()
                }

            }).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<String> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(value: String?) {
                    Toast.makeText(this@ThreadScheduleActivity, value, Toast.LENGTH_SHORT).show()
                    loadSuccess()
                }

                override fun onError(e: Throwable?) {
                    loadFailed()
                }
            })
    }

    private fun loadSuccess() {
        btn_test.isEnabled = true
        progressbar.hide()
    }

    private fun loadFailed() {
        btn_test.isEnabled = true
        progressbar.hide()
    }

    private fun startLoading() {
        btn_test.isEnabled = false
        progressbar.visibility = View.VISIBLE
    }
}
