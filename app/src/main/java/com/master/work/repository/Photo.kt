package com.master.work.repository

import java.io.Serializable

data class Photo(var fileName: String = "",): Serializable {
    override fun toString(): String {
        return fileName
    }
}
