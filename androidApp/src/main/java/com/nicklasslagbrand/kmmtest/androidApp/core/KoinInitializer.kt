package com.nicklasslagbrand.kmmtest.androidApp.core

import android.content.Context
import androidx.startup.Initializer
import com.nicklasslagbrand.kmmtest.androidApp.di.repositoriesModule
import com.nicklasslagbrand.kmmtest.androidApp.di.useCaseModel
import com.nicklasslagbrand.kmmtest.androidApp.di.viewModelModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KoinInitializer: Initializer<KoinApplication> {

    override fun create(context: Context): KoinApplication {
        return startKoin {
            androidLogger(Level.ERROR)
            androidContext(context)

            modules(
                listOf(
                    repositoriesModule,
                    useCaseModel,
                    viewModelModel
                )
            )
        }
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()
}