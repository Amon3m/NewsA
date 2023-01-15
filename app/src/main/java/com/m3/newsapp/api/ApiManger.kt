package com.m3.newsapp.api

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiManger {
    companion object{
      private  var retrofit:Retrofit?=null
       private fun retrofitGetInstance():Retrofit {
            if (retrofit==null){
                val interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger{
                    override fun log(message: String) { Log.e("api",message) }})
                interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
                //                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

                retrofit=Retrofit.Builder().client(client).baseUrl("")
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit!!
        }



    }
    fun getApis():WebServices{
        return retrofitGetInstance().create(WebServices::class.java)
    }
}