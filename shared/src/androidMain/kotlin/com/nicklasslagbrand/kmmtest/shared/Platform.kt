package com.nicklasslagbrand.kmmtest.shared

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual val Main: CoroutineDispatcher = Dispatchers.Main
internal actual val Background: CoroutineDispatcher = Dispatchers.Default
internal actual val Io: CoroutineDispatcher = Dispatchers.IO
internal actual val Unconfined: CoroutineDispatcher = Dispatchers.Unconfined

