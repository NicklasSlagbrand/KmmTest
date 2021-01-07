package com.nicklasslagbrand.kmmtest.shared.domain

import com.nicklasslagbrand.kmmtest.shared.domain.Result.Failure
import com.nicklasslagbrand.kmmtest.shared.domain.Result.Success
/**
 * Represents a value of one of two possible types
 * Instances of [Result] are result an instance of [Failure] or [Success].
 * FP Convention dictates that [Failure] is used for
 * and [Success] is used for "success".
 *
 * @see Failure
 * @see Success
 */
sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val exception: Exception) : Result<Nothing>()
}

internal inline fun <T> wrapResult(block: () -> T): Result<T> {
    return try {
        Success(block())
    } catch (exception: Exception) {
        Failure(exception)
    }
}
