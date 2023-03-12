package com.master.work.algorithmRepository

import com.master.work.algorithmRepository.impl.EdgeBasedAlgorithmProvider
import com.master.work.algorithmRepository.impl.KMeansAlgorithmProvider
import com.master.work.algorithmRepository.impl.OtsuThresholdAlgorithmProvider
import com.master.work.algorithmRepository.impl.RegionBasedAlgorithmProvider

data class AlgorithmProvider (
    val edgeBasedAlgorithm: EdgeBasedAlgorithmProvider,
    val kMeansAlgorithm: KMeansAlgorithmProvider,
    val otsuThresholdAlgorithm: OtsuThresholdAlgorithmProvider,
    val regionBasedAlgorithm: RegionBasedAlgorithmProvider
    )