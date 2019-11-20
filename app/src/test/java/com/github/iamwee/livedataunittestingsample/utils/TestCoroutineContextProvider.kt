package com.github.iamwee.livedataunittestingsample.utils

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class TestCoroutineContextProvider(
    override val main: CoroutineContext = Dispatchers.Unconfined,
    override val io: CoroutineContext = Dispatchers.Unconfined
) : CoroutineContextProvider {

    companion object {
        fun create() = TestCoroutineContextProvider()
    }
}