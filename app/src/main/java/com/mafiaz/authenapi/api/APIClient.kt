package com.mafiaz.authenapi.api

import com.mafiaz.authenapi.model.RespondToken
import com.mafiaz.authenapi.model.UserCredential
import retrofit2.Response

class APIClient(private val service: APIService) {
    suspend fun login(email: String, pwd: String): Response<RespondToken>{
        return service.login(UserCredential(email, pwd))
    }
}