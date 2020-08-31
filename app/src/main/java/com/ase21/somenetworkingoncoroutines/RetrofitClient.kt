package com.ase21.somenetworkingoncoroutines

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private const val baseUrl = "http://eurotex.leadgroup.cc/new-api/"

    private val gson = GsonBuilder()
        .setLenient()
        .serializeNulls()
        .create()

    private val httpClient = OkHttpClient.Builder()
        .writeTimeout(5, TimeUnit.MINUTES)
        .addInterceptor(createLoggingInterceptor())
        .build()

    private fun createLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    val client = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(httpClient)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(RetrofitApi::class.java)
}