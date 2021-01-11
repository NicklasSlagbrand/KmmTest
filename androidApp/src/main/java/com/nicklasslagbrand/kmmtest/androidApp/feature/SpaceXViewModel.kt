package com.nicklasslagbrand.kmmtest.androidApp.feature

import androidx.lifecycle.*
import com.nicklasslagbrand.kmmtest.shared.domain.Result
import com.nicklasslagbrand.kmmtest.shared.domain.entity.RocketLaunch
import com.nicklasslagbrand.kmmtest.shared.domain.usecase.GetAllLaunchesUseCase
import com.nicklasslagbrand.kmmtest.shared.domain.usecase.UseCase
import kotlinx.coroutines.launch
import java.lang.Exception

class SpaceXViewModel(
    private val getAllLaunchesUseCase: GetAllLaunchesUseCase,
) : ViewModel(), LifecycleObserver {
    val launchesLiveData = MutableLiveData<List<RocketLaunch>>()
    val errorLiveData = MutableLiveData<Exception>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun getAllRocketLaunches() {
        viewModelScope.launch {
            when (val result = getAllLaunchesUseCase.call(UseCase.None)) {
                is Result.Success<List<RocketLaunch>> -> launchesLiveData.value = result.data
                is Result.Failure-> errorLiveData.value = result.exception
            }
        }
    }
}