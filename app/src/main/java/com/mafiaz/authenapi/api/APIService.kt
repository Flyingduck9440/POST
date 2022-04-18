package com.mafiaz.authenapi.api

import com.mafiaz.authenapi.model.RespondToken
import com.mafiaz.authenapi.model.UserCredential
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {

    @POST("/api/login")
    suspend fun login(@Body user: UserCredential): Response<RespondToken>
}