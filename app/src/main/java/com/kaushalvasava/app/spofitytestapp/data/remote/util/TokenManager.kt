package com.kaushalvasava.app.spofitytestapp.data.remote.util

import android.content.SharedPreferences
import com.kaushalvasava.app.spofitytestapp.data.remote.api.AuthApi
import com.kaushalvasava.app.spofitytestapp.util.AppConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TokenManager @Inject constructor(
    private val authService: AuthApi,
    private val sharedPreferences: SharedPreferences,
) {

    private var token: String? = null

    fun getToken(): String? {
        return sharedPreferences.getString(AppConstants.TOKEN_PREF_KEY, null)
    }

    suspend fun refreshToken() {
        return withContext(Dispatchers.IO) {
            try {
                val response = authService.postTokenRequest()
                sharedPreferences.edit()
                    .putString(AppConstants.TOKEN_PREF_KEY, response.accessToken).apply()
                token = response.accessToken
            } catch (e: Exception) {
                token
            }
        }
    }
}
