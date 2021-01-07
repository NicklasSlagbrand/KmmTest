package com.nicklasslagbrand.kmmtest.androidApp.di

import com.nicklasslagbrand.kmmtest.androidApp.feature.SpaceXViewModel
import com.nicklasslagbrand.kmmtest.shared.SpaceXRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoriesModule = module{
    single { SpaceXRepository() }
}

val viewModelModel = module {
    viewModel { SpaceXViewModel(get()) }
}
