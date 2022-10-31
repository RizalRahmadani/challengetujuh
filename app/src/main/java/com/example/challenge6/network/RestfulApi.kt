package com.example.challenge6.network

import com.example.challenge6.model.ResponseDataCarItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface RestfulApi {
    @GET("admin/car")
    fun getAllCar(): Call<List<ResponseDataCarItem>>

    @GET("admin/car/{id}")
    fun getDetailCar(@Path("id") id : Int): Call<List<ResponseDataCarItem>>
}