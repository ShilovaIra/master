package com.master.work.algorithmRepository.impl

import com.chaquo.python.Python

class RegionBasedAlgorithmProvider {

    fun executeAlgorithm(path: String): String {
        val python = Python.getInstance()
        val pythonFile = python.getModule("contour_detection")
        return pythonFile.callAttr("execute_otsu", path).toString()
    }

}