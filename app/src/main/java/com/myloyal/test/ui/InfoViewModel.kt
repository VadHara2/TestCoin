package com.myloyal.test.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.myloyal.test.App
import com.myloyal.test.data.ApiModule
import com.myloyal.test.models.Currency
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList


class InfoViewModel: ViewModel() {

    lateinit var navigator: InfoNavigator
    var currencies: MutableLiveData<MutableList<Currency>> = MutableLiveData(ArrayList())

    var onClick: (Currency) -> Unit = {

    }


    fun getInfo(){
        val api = App.api
        viewModelScope.launch {
            runCatching {
                val result = api.getData("usd")
                currencies.value?.clear()
                currencies.value?.addAll(result)
                currencies.postValue(currencies.value)
                result.forEach {
                    Log.w("myLog", "getInfo: " + it.name )
                }
            }.onFailure {
              it.printStackTrace()
            }
        }
    }
}