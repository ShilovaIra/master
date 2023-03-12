package com.master.work.repository

interface PhotoRepository {
    fun addPhoto(photo: Photo): Boolean
    fun getPhoto(fileName: String): Photo
    fun deletePhoto(fileName: String): Boolean
}