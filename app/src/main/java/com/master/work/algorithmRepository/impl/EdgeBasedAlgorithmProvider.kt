package com.master.work.algorithmRepository.impl

import com.chaquo.python.Python

class EdgeBasedAlgorithmProvider {

    fun executeAlgorithm(path: String): String {
        val python = Python.getInstance()
        val pythonFile = python.getModule("watershed")
        return pythonFile.callAttr("execute_watershed", path).toString()
    }

}