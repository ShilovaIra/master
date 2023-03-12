package com.master.work.algorithmRepository.impl

import com.chaquo.python.Python

class OtsuThresholdAlgorithmProvider {

    fun executeAlgorithm(path: String): String {
        val python = Python.getInstance()
        val pythonFile = python.getModule("otsu_threshold")
        return pythonFile.callAttr("execute_otsu", path).toString()
    }

}