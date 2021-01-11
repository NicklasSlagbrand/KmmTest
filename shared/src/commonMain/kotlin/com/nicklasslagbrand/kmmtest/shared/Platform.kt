package com.nicklasslagbrand.kmmtest.shared

import kotlinx.coroutines.CoroutineDispatcher

internal expect val Main: CoroutineDispatcher
internal expect val Background: CoroutineDispatcher
internal expect val Io: CoroutineDispatcher
internal expect val Unconfined: CoroutineDispatcher



