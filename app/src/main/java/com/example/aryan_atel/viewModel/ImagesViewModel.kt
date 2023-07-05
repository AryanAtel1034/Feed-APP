package com.example.aryan_atel.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aryan_atel.models.Jokes
import com.example.aryan_atel.repository.ImagesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImagesViewModel(private val imagesRepository: ImagesRepository) : ViewModel() {


    init {
        viewModelScope.launch ( Dispatchers.IO ){
        imagesRepository.getImages()
        }
    }

    val image: LiveData<Jokes>
        get() = imagesRepository.images


}