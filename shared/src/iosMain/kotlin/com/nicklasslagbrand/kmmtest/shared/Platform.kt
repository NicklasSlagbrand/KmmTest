package com.nicklasslagbrand.kmmtest.shared


import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.UIKit.UIDevice
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

internal actual val Main: CoroutineDispatcher = NsQueueDispatcher(dispatch_get_main_queue())

internal actual val Background: CoroutineDispatcher = Main
internal actual val Io: CoroutineDispatcher = Main
internal actual val Unconfined: CoroutineDispatcher = Main

internal class NsQueueDispatcher(
    private val dispatchQueue: dispatch_queue_t
) : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }
}

