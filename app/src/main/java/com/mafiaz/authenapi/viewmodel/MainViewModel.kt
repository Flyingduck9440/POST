package com.mafiaz.authenapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mafiaz.authenapi.model.RespondToken
import com.mafiaz.authenapi.repository.AuthenRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val authenRepository = AuthenRepository()
    private val tokenData = MutableLiveData<RespondToken?>()
    val token: LiveData<RespondToken?> = tokenData

    fun loginRequest(email: String, pwd: String){
        viewModelScope.launch (Dispatchers.IO){
            val result = authenRepository.getToken(email,pwd)
            tokenData.postValue(result)
        }
    }
}