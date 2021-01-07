package com.nicklasslagbrand.kmmtest.androidApp.feature

import androidx.lifecycle.*
import com.nicklasslagbrand.kmmtest.shared.SpaceXRepository
import com.nicklasslagbrand.kmmtest.shared.domain.Result
import com.nicklasslagbrand.kmmtest.shared.domain.entity.RocketLaunch
import kotlinx.coroutines.launch
import java.lang.Exception
import java.net.UnknownHostException

class SpaceXViewModel(
    private val spaceXRepository: SpaceXRepository,
) : ViewModel(), LifecycleObserver {
    val launchesLiveData = MutableLiveData<List<RocketLaunch>>()
    val errorLiveData = MutableLiveData<Exception>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun getAllRocketLaunches() {
        viewModelScope.launch {
            when (val result = spaceXRepository.getAllRocketLaunches()) {
                is Result.Success<List<RocketLaunch>> -> launchesLiveData.value = result.data
                is Result.Failure-> errorLiveData.value = result.exception
            }
        }
    }
}