package com.example.aryan_atel.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.aryan_atel.api.ApiInterface
import com.example.aryan_atel.models.Jokes

class ImagesRepository(private val apiInterface: ApiInterface) {

    private val imagesLiveData = MutableLiveData<Jokes>()
    val images: LiveData<Jokes>
        get() = imagesLiveData


    suspend fun getImages() {
        val result = apiInterface.getImages()
        if (result.body() != null) {
            imagesLiveData.postValue(result.body())
        }
    }
}