package com.isaac.houserentalapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chuks.houserental.Api.Api_Provider
import com.chuks.houserental.model.Data
import com.chuks.houserental.model.User
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val userLiveData = MutableLiveData<List<Data>>()

    fun getUsers() {
        viewModelScope.launch {
            try{
                userLiveData.postValue(Api_Provider.apiProvider.getUsers().data)
            }catch (t: Throwable){
                Log.e("Main Project", t.message.toString())
            }
        }
    }
}


