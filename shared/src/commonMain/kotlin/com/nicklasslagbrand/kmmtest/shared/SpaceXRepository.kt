package com.nicklasslagbrand.kmmtest.shared

import com.nicklasslagbrand.kmmtest.shared.data.network.SpaceXApi
import com.nicklasslagbrand.kmmtest.shared.domain.Result
import com.nicklasslagbrand.kmmtest.shared.domain.entity.RocketLaunch
import com.nicklasslagbrand.kmmtest.shared.domain.wrapResult

class SpaceXRepository {
    private val api = SpaceXApi()

    suspend fun getAllRocketLaunches(): Result<List<RocketLaunch>, Exception>{
       return wrapResult { api.getAllRocketLaunches() }
    }
}