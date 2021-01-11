package com.nicklasslagbrand.kmmtest.shared.domain.usecase

import com.nicklasslagbrand.kmmtest.shared.data.repository.SpaceXRepository
import com.nicklasslagbrand.kmmtest.shared.domain.Result

class CountStepsUseCase(
    private val repository: SpaceXRepository
) : UseCase<Any, UseCase.None> {

    override suspend fun call(params: UseCase.None): Result<Int> {
        return Result.Success(1)
    }
}

