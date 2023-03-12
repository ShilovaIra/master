package com.master.work.repository

import android.content.Context

class InternalPhotoRepository(private var context: Context): PhotoRepository {
    override fun addPhoto(photo: Photo): Boolean {
        TODO("Not yet implemented")
    }

    override fun getPhoto(fileName: String): Photo {
        val note = Photo(fileName)
        context.openFileInput(fileName).use { stream ->
            val text = stream.bufferedReader().use {
                it.readText()
            }
        }
        return note
    }

    override fun deletePhoto(fileName: String): Boolean {
        TODO("Not yet implemented")
    }
}