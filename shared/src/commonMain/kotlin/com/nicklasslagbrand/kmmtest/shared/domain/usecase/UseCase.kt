package com.nicklasslagbrand.kmmtest.shared.domain.usecase

import com.nicklasslagbrand.kmmtest.shared.domain.Result


interface UseCase<Output : Any?, in Params : Any> {
    suspend fun call(params: Params): Result<Output>

    object None
}