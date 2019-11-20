package com.github.iamwee.livedataunittestingsample.utils

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    val main: CoroutineContext
    val io: CoroutineContext
}

class CoroutineContextProviderImpl(
    override val main: CoroutineContext = Dispatchers.Main,
    override val io: CoroutineContext = Dispatchers.IO
) : CoroutineContextProvider {
    companion object {
        fun create() =
            CoroutineContextProviderImpl()
    }
}
