package com.kaushalvasava.app.spofitytestapp.data.remote.api

import com.kaushalvasava.app.spofitytestapp.data.remote.model.Token
import com.kaushalvasava.app.spofitytestapp.data.remote.util.ApiConstants
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApi {
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("token")
    suspend fun postTokenRequest(
        @Query("grant_type") grantType: String = "client_credentials",
        @Query("client_id") clientId: String = ApiConstants.CLIENT_ID,
        @Query("client_secret") clientSecret: String = ApiConstants.CLIENT_SECRET,
    ): Token
}