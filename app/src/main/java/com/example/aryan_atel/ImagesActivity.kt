package com.example.aryan_atel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.aryan_atel.api.ApiInterface
import com.example.aryan_atel.api.ApiUtilities
import com.example.aryan_atel.repository.ImagesRepository
import com.example.aryan_atel.viewModel.ImageViewModelFactory
import com.example.aryan_atel.viewModel.ImagesViewModel

class ImagesActivity : AppCompatActivity() {

    private lateinit var imagesViewModel: ImagesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)


        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)
        val imagesRepository = ImagesRepository(apiInterface)
        imagesViewModel = ViewModelProvider(
            this, ImageViewModelFactory(imagesRepository)
        ).get(ImagesViewModel::class.java)

        imagesViewModel.image.observe(this) {

            it.data.memes.iterator().forEach { pics ->

                Log.d("original", "---------> " + pics.url)


            }

        }

    }
}