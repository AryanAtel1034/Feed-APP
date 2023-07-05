package com.example.aryan_atel.api

import com.example.aryan_atel.models.Jokes
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/get_memes")
    suspend fun getImages(): Response<Jokes>
}