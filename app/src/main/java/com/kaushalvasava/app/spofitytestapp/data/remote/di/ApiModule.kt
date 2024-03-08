package com.kaushalvasava.app.spofitytestapp.data.remote.di

import android.content.Context
import android.content.SharedPreferences
import com.kaushalvasava.app.spofitytestapp.data.remote.api.AuthApi
import com.kaushalvasava.app.spofitytestapp.data.remote.api.SpotifyApi
import com.kaushalvasava.app.spofitytestapp.data.remote.interceptor.TokenInterceptor
import com.kaushalvasava.app.spofitytestapp.data.remote.util.TokenManager
import com.kaushalvasava.app.spofitytestapp.data.remote.repo.SpotifyRepoImpl
import com.kaushalvasava.app.spofitytestapp.data.remote.util.ApiConstants
import com.kaushalvasava.app.spofitytestapp.util.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext app: Context): SharedPreferences =
        app.getSharedPreferences(AppConstants.APP_SHARED_PREF, Context.MODE_PRIVATE)

    @Named("token")
    @Provides
    @Singleton
    fun provideTokenManager(): Retrofit = Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideAuthApi(@Named("token") retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)

    @Provides
    @Singleton
    fun providerTokenManager(api: AuthApi, sharedPref: SharedPreferences) =
        TokenManager(api, sharedPref)

    @Provides
    @Singleton
    fun provideInterceptor(tokenManager: TokenManager): TokenInterceptor {
        return TokenInterceptor(tokenManager)
    }

    @Provides
    @Singleton
    fun provideClient(tokenInterceptor: TokenInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(3, TimeUnit.SECONDS)
            .readTimeout(3, TimeUnit.SECONDS)
            .addInterceptor(tokenInterceptor)
            // Add other interceptors and configurations as needed
            .build()
    }

    @Named("search")
    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(ApiConstants.SEARCH_BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideSpotifyApi(@Named("search") retrofit: Retrofit): SpotifyApi =
        retrofit.create(SpotifyApi::class.java)

    @Provides
    @Singleton
    fun providerSpotifyRepo(api: SpotifyApi) = SpotifyRepoImpl(api)
}
