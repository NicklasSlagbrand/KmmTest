package com.nicklasslagbrand.kmmtest.androidApp.di

import android.content.Context
import android.content.Context.*
import android.hardware.SensorManager
import androidx.core.content.ContextCompat.getSystemService
import com.nicklasslagbrand.kmmtest.androidApp.feature.SpaceXViewModel
import com.nicklasslagbrand.kmmtest.shared.data.repository.SpaceXRepository
import com.nicklasslagbrand.kmmtest.shared.domain.usecase.CountStepsUseCase
import com.nicklasslagbrand.kmmtest.shared.domain.usecase.GetAllLaunchesUseCase
import dev.bluefalcon.BlueFalcon
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun androidModule() = module{
    single { BlueFalcon(get(), Context.BLUETOOTH_SERVICE)
    }
}

val repositoriesModule = module{
    single { SpaceXRepository() }
}

val useCaseModel = module {
    single { GetAllLaunchesUseCase(get()) }
    single { CountStepsUseCase(get()) }
}

val viewModelModel = module {
    viewModel { SpaceXViewModel(get()) }
}
