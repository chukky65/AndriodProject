package com.isaac.houserentalapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chuks.houserental.Api.Api_Provider
import com.chuks.houserental.model.User
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(){
    val userLiveData = MutableLiveData<List<User>>()

    fun getProperty(){
        viewModelScope.launch {
            userLiveData.postValue(Api_Provider.apiProvider.getProperty())
        }

    }    }


