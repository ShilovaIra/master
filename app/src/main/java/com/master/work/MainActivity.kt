package com.master.work

import android.content.Context
import android.content.ContextWrapper
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.Python
import com.master.work.constants.Constants.Companion.DEFAULT_DIR_FOR_READING
import com.master.work.constants.Constants.Companion.IMAGE_PATH_OTSU_ALGORITHM
import com.master.work.imageUtilities.ImageLoader
import com.master.work.repository.InternalPhotoRepository
import com.master.work.repository.PhotoRepository
import java.io.File

class MainActivity : AppCompatActivity() {

    private var txtPythonShow: TextView? = null
    private val repo: PhotoRepository by lazy { InternalPhotoRepository(this) }
    var read: Button? = null
    var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtPythonShow = findViewById(R.id.txtPythonShow)
        txtPythonShow?.text = getPythonHelloWorld()
        imageView = findViewById(R.id.imageView);
        read = findViewById(R.id.read);
        read!!.setOnClickListener {
            var cw: ContextWrapper = ContextWrapper(applicationContext);
            println(filesDir.path)
            //var image = IMAGE_PATH_OTSU_ALGORITHM
            var file: File =  File(DEFAULT_DIR_FOR_READING, IMAGE_PATH_OTSU_ALGORITHM);
            imageView!!.setImageDrawable(Drawable.createFromPath(file.toString()));
        }
        //MediaStore.Images.Media.insertImage(contentResolver, path, "", "");
    }

    private fun getPythonHelloWorld(): String {
        val python = Python.getInstance()
        val pythonFile = python.getModule("OtsuThreshold")
        return pythonFile.callAttr("execute_otsu", "Ira").toString()
    }
}