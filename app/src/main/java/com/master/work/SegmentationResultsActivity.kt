package com.master.work

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SegmentationResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segmentation_results)
        supportActionBar?.hide()
    }
}