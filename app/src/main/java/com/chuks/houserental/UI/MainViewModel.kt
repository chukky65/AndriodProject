package com.isaac.houserentalapp.ui

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
            userLiveData.postValue(Api_Provider.apiProvider.getUsers().data)
        }
    }
}


