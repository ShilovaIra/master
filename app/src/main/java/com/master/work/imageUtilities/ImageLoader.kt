package com.master.work.imageUtilities

import android.provider.MediaStore

class ImageLoader {

    fun loadImageToGallery() {
        MediaStore.Images.Media.insertImage(getContentResolver(), path, "", "");
    }

    private fun imageNameGenerator() {

    }
}