package com.master.work

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.master.work.imageUtilities.ImageLoader

class MainScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        supportActionBar?.hide()
        ImageLoader.loadImageToGallery(contentResolver, this);
    }
}