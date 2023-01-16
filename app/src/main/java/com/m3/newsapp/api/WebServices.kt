package com.m3.newsapp.api

import android.app.appsearch.AppSearchSchema
import com.m3.newsapp.api.model.NewsResponse
import com.m3.newsapp.api.model.SourceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.nio.channels.spi.AbstractSelectionKey

interface WebServices {

    @GET("top-headlines/sources")
    fun getNewsSources(
            @Query("apiKey")key: String,
            @Query("language")lang: String,
            @Query("country")country: String):Call<SourceResponse>

    @GET("everything")
    fun getNews(
        @Query("apiKey")key: String,
        @Query("language")lang: String,
        @Query("q")searchKeyword: String,
        @Query("source")source: String
    ):Call<NewsResponse>
}


