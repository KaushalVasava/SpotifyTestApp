package com.kaushalvasava.app.spofitytestapp.data.remote.interceptor

import com.kaushalvasava.app.spofitytestapp.data.remote.util.TokenManager
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(private val tokenManager: TokenManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        // Add the token to the header if available
        val token = tokenManager.getToken()
        if (token != null) {
            val header = "Bearer $token"
            request = request.newBuilder()
                .header("Authorization", header)
                .build()
        }

        val response = chain.proceed(request)

        // Check for token expiration
        if (response.code() == 401) { // Assuming 401 is the token expiration status code
            // Token expired, refresh it
            runBlocking {
                tokenManager.refreshToken()
                // Retry the request with the new token
            }
            val newRequest = request.newBuilder()
                .header("Authorization", "Bearer ${tokenManager.getToken()}")
                .build()
            response.close()
            return chain.proceed(newRequest)
        }
        return response
    }
}
