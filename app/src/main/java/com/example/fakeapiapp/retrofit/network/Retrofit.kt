package com.example.fakeapiapp.retrofit.network

import com.example.fakeapiapp.retrofit.methods.ApiEndUrls
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private val Retrofitclient:Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
    }

    val Apicall: ApiEndUrls by lazy {
        Retrofitclient.build().create(ApiEndUrls::class.java)
    }
}