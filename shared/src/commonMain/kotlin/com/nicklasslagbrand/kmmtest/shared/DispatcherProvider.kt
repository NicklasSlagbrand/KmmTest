package com.nicklasslagbrand.kmmtest.shared

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Unconfined


interface DispatcherProvider {

    fun main(): CoroutineDispatcher = Main
    fun default(): CoroutineDispatcher = Background
    fun io(): CoroutineDispatcher = Io
    fun unconfined(): CoroutineDispatcher = Unconfined

}

class DefaultDispatcherProvider : DispatcherProvider


class DefaultDispatcherProvider2 : DispatcherProvider {
    override fun main(): CoroutineDispatcher = Main
    override fun default(): CoroutineDispatcher = Background
    override fun io(): CoroutineDispatcher = Io
    override fun unconfined(): CoroutineDispatcher = Unconfined
}