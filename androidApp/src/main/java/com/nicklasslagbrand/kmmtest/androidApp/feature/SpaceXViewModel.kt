package com.nicklasslagbrand.kmmtest.androidApp.feature

import androidx.lifecycle.*
import com.nicklasslagbrand.kmmtest.shared.SpaceXRepository
import com.nicklasslagbrand.kmmtest.shared.domain.entity.RocketLaunch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpaceXViewModel(
    private val spaceXRepository: SpaceXRepository
) : ViewModel(), LifecycleObserver {
    val launchesLiveData = MutableLiveData<List<RocketLaunch>>()
    val errorLiveData = MutableLiveData<Exception>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun getAllRocketLaunches() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                spaceXRepository.getAllRocketLaunches()
            }
            result.fold({
                launchesLiveData.value = it
            },{
                errorLiveData.value = it
            })
        }
    }
}