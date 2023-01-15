package com.m3.newsapp.api

import com.m3.newsapp.api.model.SourceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.nio.channels.spi.AbstractSelectionKey

interface WebServices {

    @GET
    fun getNewsSources(
            @Query("apiKey")key: String,
            @Query("language")lang: String,
            @Query("country")country: String):Call<SourceResponse>

}