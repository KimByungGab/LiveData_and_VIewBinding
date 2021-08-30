package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// 데이터의 변경사항을 알려주는 라이브데이터를 가지는 뷰모델
class MainViewModel: ViewModel() {

    private val _currentValue = MutableLiveData<Int>()  // 변경가능한 Mutable타입의 라이브데이터. 라이브데이터 변수는 암묵적으로 맨 앞에 언더바를 붙인다고 한다.

    // Getter
    val currentValue: LiveData<Int>
        get() = _currentValue

    // 초기값
    init {
        _currentValue.value = 0
    }

    // Setter
    fun updateValue(type: Int) {
        when(type) {
            1 -> _currentValue.value = _currentValue.value?.plus(1)
            2 -> _currentValue.value = _currentValue.value?.minus(1)
        }
    }
}