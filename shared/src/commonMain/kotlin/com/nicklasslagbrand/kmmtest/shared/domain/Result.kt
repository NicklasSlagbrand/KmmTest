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
sealed class Result<out SuccessType, out FailureType> {
    /** * Represents the failure side of [Result] class which by convention is "Failure". */
    data class Failure<out L>(val value: L) : Result<Nothing, L>()

    /** * Represents the success side of [Result] class which by convention is "Success". */
    data class Success<out R>(val value: R) : Result<R, Nothing>()

    val isSuccess get() = this is Success<SuccessType>
    val isFailure get() = this is Failure<FailureType>

    fun fold(onSuccess: (SuccessType) -> Unit, onFailure: (FailureType) -> Unit) {
        when (this) {
            is Failure -> onFailure(value)
            is Success -> onSuccess(value)
        }
    }

    fun <L> newFailure(a: L) = Failure(a)
    fun <R> newSuccess(b: R) = Success(b)

    companion object {
        fun <T> success(from: T): Result<T, Exception> {
            return Success(from)
        }

        fun <T, Exception> failure(from: Exception): Result<T, Exception> {
            return Failure(from)
        }
    }
}

internal inline fun <T> wrapResult(block: () -> T): Result<T, Exception> {
    return try {
        Result.success(block())
    } catch (exception: Exception) {
        Result.failure(exception)
    }
}
