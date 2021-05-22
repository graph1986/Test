package com.example.books.model

import com.example.books.model.entities.Book
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject


interface ApiClient {

    @GET("covers")
    fun fetchBooks(): Single<List<Book>>

    class Factory @Inject constructor() {
        fun create() = Retrofit.Builder().run {
            client(OkHttpClient.Builder().build())
            baseUrl(BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            build().create(ApiClient::class.java)
        }
    }

    private companion object {
        private const val BASE_URL = "https://pivl.github.io/sample_api/"
    }

}