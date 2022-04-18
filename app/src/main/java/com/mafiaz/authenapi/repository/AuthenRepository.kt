package com.mafiaz.authenapi.repository

import com.mafiaz.authenapi.api.APIUtilities
import com.mafiaz.authenapi.model.RespondToken

class AuthenRepository {

    suspend fun getToken(email:String, pwd:String): RespondToken? {
        val result = APIUtilities.apiClient.login(email, pwd)
        if(result.isSuccessful){
            return result.body()
        }
        return null
    }
}