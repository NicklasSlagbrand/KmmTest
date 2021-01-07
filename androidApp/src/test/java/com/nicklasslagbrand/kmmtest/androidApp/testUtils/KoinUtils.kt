package com.nicklasslagbrand.kmmtest.androidApp.testUtils


import com.nicklasslagbrand.kmmtest.androidApp.di.repositoriesModule
import com.nicklasslagbrand.kmmtest.androidApp.di.viewModelModel
import org.koin.core.KoinApplication
import org.koin.core.logger.EmptyLogger
import org.koin.core.module.Module

@Suppress("EXPERIMENTAL_API_USAGE")
fun startKoin(
    overridesModule: Module
): KoinApplication {
    // Gather all required dependencies
    val allModules = listOf(
        repositoriesModule,
        viewModelModel,
        overridesModule
    )
    return org.koin.core.context.startKoin {
        modules(allModules)
        logger(EmptyLogger())
    }
}
