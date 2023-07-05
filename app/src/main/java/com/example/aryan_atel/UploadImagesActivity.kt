package com.example.aryan_atel

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class UploadImagesActivity : AppCompatActivity() {


    private lateinit var btnSelected: Button
    private lateinit var imgSelectedImage: ImageView
    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()){
        imgSelectedImage.setImageURI(it)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_images)

        btnSelected = findViewById(R.id.btnSelect)
        imgSelectedImage = findViewById(R.id.imgSelectedImage)

        btnSelected.setOnClickListener {

            contract.launch("image/*")
        }


    }


    fun backPress(view: View) {
        finish()
    }

}