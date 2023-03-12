package com.master.work.imageUtilities

import android.content.ContentResolver
import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import java.io.File
import java.io.OutputStream
import java.util.Objects

import com.master.work.constants.Constants

class ImageLoader {

    companion object {
        fun loadImageToGallery(contentResolver: ContentResolver, context: Context) {

            val images: Uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
            } else {
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            }
            val contentValues = ContentValues()
            contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, "testImage1.png") // change name
            contentValues.put(MediaStore.Images.Media.MIME_TYPE, "images/*")
            val uri: Uri? = contentResolver.insert(images, contentValues)
            loadFromContext(contentResolver, uri!!, context)
        }

        private fun loadFromContext(contentResolver: ContentResolver, uri: Uri, context: Context) {
            val imgFile = File(context.filesDir.path + "/chaquopy/AssetFinder/app/images/3.png")
            try {
                val myBitmap = BitmapFactory.decodeFile(imgFile.absolutePath)
                val outputStream: OutputStream? = contentResolver.openOutputStream(uri)
                myBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
                Objects.requireNonNull(outputStream)
                Toast.makeText(
                    context,
                    Constants.SUCCESS_TO_LOAD_IMAGE_FROM_CONTEXT,
                    Toast.LENGTH_SHORT
                ).show()
            } catch (_: Exception) {
                Toast.makeText(
                    context,
                    Constants.UNABLE_TO_LOAD_IMAGE_FROM_CONTEXT,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}