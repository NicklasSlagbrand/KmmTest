package com.nicklasslagbrand.kmmtest.shared.domain.usecase

import com.nicklasslagbrand.kmmtest.shared.data.repository.SpaceXRepository
import com.nicklasslagbrand.kmmtest.shared.domain.Result
import com.nicklasslagbrand.kmmtest.shared.domain.entity.RocketLaunch

class GetAllLaunchesUseCase(
    private val repository: SpaceXRepository
) : UseCase<Any, UseCase.None> {

    override suspend fun call(params: UseCase.None): Result<List<RocketLaunch>> =
        repository.getAllRocketLaunches()

}

