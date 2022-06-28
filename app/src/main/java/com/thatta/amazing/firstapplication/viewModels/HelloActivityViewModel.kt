package com.thatta.amazing.firstapplication.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HelloActivityViewModel: ViewModel() {

    private var _diceValue = MutableLiveData<Int>()

    var diceValue: LiveData<Int> = _diceValue

    fun getDiceValue() {
        _diceValue.value = (1..7).random()
    }

}