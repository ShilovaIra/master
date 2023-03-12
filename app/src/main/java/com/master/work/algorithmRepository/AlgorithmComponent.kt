package com.master.work.algorithmRepository

import dagger.Component

@Component(modules = [AlgorithmModule::class])
interface AlgorithmComponent {
    fun getProvider(): AlgorithmProvider
}