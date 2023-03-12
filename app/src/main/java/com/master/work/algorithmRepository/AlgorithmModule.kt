package com.master.work.algorithmRepository

import com.master.work.algorithmRepository.impl.EdgeBasedAlgorithmProvider
import com.master.work.algorithmRepository.impl.KMeansAlgorithmProvider
import com.master.work.algorithmRepository.impl.OtsuThresholdAlgorithmProvider
import com.master.work.algorithmRepository.impl.RegionBasedAlgorithmProvider
import dagger.Module
import dagger.Provides

@Module
class AlgorithmModule {

    @Provides
    fun provideAlgorithmProvider(edgeBasedAlgorithm: EdgeBasedAlgorithmProvider,
                                 kMeansAlgorithm: KMeansAlgorithmProvider,
                                 otsuThresholdAlgorithm: OtsuThresholdAlgorithmProvider,
                                 regionBasedAlgorithm: RegionBasedAlgorithmProvider): AlgorithmProvider {
        return AlgorithmProvider(
            edgeBasedAlgorithm = edgeBasedAlgorithm,
            kMeansAlgorithm = kMeansAlgorithm,
            otsuThresholdAlgorithm = otsuThresholdAlgorithm,
            regionBasedAlgorithm = regionBasedAlgorithm
        )
    }

    @Provides
    fun provideEdgeBasedAlgorithmProvider(): EdgeBasedAlgorithmProvider {
        return EdgeBasedAlgorithmProvider()
    }

    @Provides
    fun provideKMeansAlgorithmProvider(): KMeansAlgorithmProvider {
        return KMeansAlgorithmProvider()
    }

    @Provides
    fun provideOtsuThresholdAlgorithmProvider(): OtsuThresholdAlgorithmProvider {
        return OtsuThresholdAlgorithmProvider()
    }

    @Provides
    fun provideRegionBasedAlgorithmProvider(): RegionBasedAlgorithmProvider {
        return RegionBasedAlgorithmProvider()
    }

}