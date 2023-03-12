package com.master.work

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.master.work.constants.Constants.Companion.IMAGE_REQUEST_CODE
import com.master.work.imageUtilities.ImageLoader
import com.master.work.imageUtilities.RealPathUtil


class MainScreenActivity : AppCompatActivity() {

    private var imagePath = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        supportActionBar?.hide()
        ImageLoader.loadImageToGallery(contentResolver, this)
        val button: Button = findViewById(R.id.LoadFromLibrary)
        button.setOnClickListener{
            pickImage()
        }
    }

    private fun pickImage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val returnUri: Uri? = data?.data
        returnUri?.let { contentResolver.query(it, null, null, null, null) }
        imagePath = RealPathUtil.getImagePath(this, returnUri!!).toString()
    }
}