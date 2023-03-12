package com.master.work

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.master.work.algorithmRepository.AlgorithmComponent
import com.master.work.algorithmRepository.DaggerAlgorithmComponent

class AlgorithmSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algorithm_selection)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val appComponent: AlgorithmComponent = DaggerAlgorithmComponent.create()
    }


}