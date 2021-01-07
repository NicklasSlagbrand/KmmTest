package com.nicklasslagbrand.kmmtest.androidApp.testUtils

import com.nicklasslagbrand.kmmtest.shared.domain.entity.Links
import com.nicklasslagbrand.kmmtest.shared.domain.entity.Rocket
import com.nicklasslagbrand.kmmtest.shared.domain.entity.RocketLaunch

@SuppressWarnings("MagicNumber")
val testRocket = Rocket(
    id = "1234",
    name = "name",
    type = "type"
)
@SuppressWarnings("MagicNumber")
val testLinks = Links(
    missionPatchUrl = null,
    articleUrl = null
)
@SuppressWarnings("MagicNumber")
val testRocketLaunch = RocketLaunch(
    flightNumber = 1,
    missionName = "mission",
    launchYear = 2013,
    launchDateUTC = "",
    rocket = testRocket,
    details = "Lorem",
    launchSuccess = true,
    links = testLinks
)

