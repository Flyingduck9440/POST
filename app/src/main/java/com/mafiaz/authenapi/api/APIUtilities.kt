package com.mafiaz.authenapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIUtilities {

    private const val BASE_URL = "https://reqres.in/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: APIService by lazy {
        retrofit.create(APIService::class.java)
    }

    val apiClient = APIClient(service)
}