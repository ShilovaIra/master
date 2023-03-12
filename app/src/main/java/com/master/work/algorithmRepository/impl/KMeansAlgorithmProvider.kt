package com.master.work.algorithmRepository.impl

import com.chaquo.python.Python

class KMeansAlgorithmProvider {

    fun executeAlgorithm(path: String): String {
        val python = Python.getInstance()
        val pythonFile = python.getModule("k_means")
        return pythonFile.callAttr("execute_otsu", path).toString()
    }

}