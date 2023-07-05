package com.example.aryan_atel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UserChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_choice)

        findViewById<Button>(R.id.btnUpload).setOnClickListener {
            startActivity(Intent(applicationContext, UploadImagesActivity:: class.java))

        }
        findViewById<Button>(R.id.btnFeeds).setOnClickListener {
            startActivity(Intent(applicationContext, ImagesActivity:: class.java))

        }
    }
}