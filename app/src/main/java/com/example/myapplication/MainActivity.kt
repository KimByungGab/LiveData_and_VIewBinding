package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)   // 뷰 바인딩 inflate (코틀린 익스텐션 deprecated...됐넹...)
        setContentView(activityMainBinding.root)        // 화면에 뷰 적용. 이제 접근하고 싶으면 binding변수를 통해 접근하면 된다!

        activityMainBinding.upButton.setOnClickListener {
            mainViewModel.updateValue(1)
        }

        activityMainBinding.downButton.setOnClickListener {
            mainViewModel.updateValue(2)
        }

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)  // 뷰모델 가져오기

        // 값이 변경되면 관찰되어 괄호안의 코드 실행.
        mainViewModel.currentValue.observe(this, Observer {
            activityMainBinding.textview.text = it.toString()
        })
    }
}