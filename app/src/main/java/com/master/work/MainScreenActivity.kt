package com.master.work

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        supportActionBar?.hide()
    }
}