package com.nicklasslagbrand.kmmtest.shared

import com.nicklasslagbrand.kmmtest.shared.data.network.SpaceXApi
import com.nicklasslagbrand.kmmtest.shared.domain.Result
import com.nicklasslagbrand.kmmtest.shared.domain.entity.RocketLaunch
import com.nicklasslagbrand.kmmtest.shared.domain.wrapResult
import kotlinx.coroutines.withContext

class SpaceXRepository  {
    private val api = SpaceXApi()
    private val dispatchers: DispatcherProvider = DefaultDispatcherProvider2()

    suspend fun getAllRocketLaunches(): Result<List<RocketLaunch>> = wrapResult {
        withContext(dispatchers.io()) {
            api.getAllRocketLaunches()
        }
    }
}