package com.example.aryan_atel.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aryan_atel.repository.ImagesRepository

class ImageViewModelFactory(private val imagesRepository: ImagesRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ImagesViewModel(imagesRepository) as T
    }

    
}