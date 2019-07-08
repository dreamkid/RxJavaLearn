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
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_simple_use.*
import java.lang.Thread.sleep

class SimpleUseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_use)

        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
        webview.loadUrl("file:///android_asset/simpleUse.html")
    }

    fun testNet(view:View) {
        //1. 被观察者
        val observable = Observable.create(object :ObservableOnSubscribe<String>{
            override fun subscribe(e: ObservableEmitter<String>?) {
                if(e == null)
                    return
                sleep(2000)
                e.onNext("请求成功！")
                e.onComplete()
            }

        })

        // 2.创建观察者
        val observer = object :Observer<String>{
            override fun onComplete() {
                Toast.makeText(this@SimpleUseActivity,"请求完成",Toast.LENGTH_SHORT).show()
            }

            override fun onSubscribe(d: Disposable?) {
            }

            override fun onNext(value: String?) {
                if(!TextUtils.isEmpty(value)) {
                    Toast.makeText(this@SimpleUseActivity,value,Toast.LENGTH_SHORT).show()
                }
            }

            override fun onError(e: Throwable?) {
            }

        }

        // 3.建立订阅关系
        observable.subscribe(observer)
    }
}
