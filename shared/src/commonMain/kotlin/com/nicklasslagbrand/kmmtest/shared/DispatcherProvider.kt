package com.nicklasslagbrand.kmmtest.shared

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Unconfined

class DefaultDispatcherProvider {
    fun main(): CoroutineDispatcher = Main
    fun default(): CoroutineDispatcher = Background
    fun io(): CoroutineDispatcher = Io
    fun unconfined(): CoroutineDispatcher = Unconfined
}