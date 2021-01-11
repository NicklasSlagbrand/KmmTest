package com.nicklasslagbrand.kmmtest.androidApp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nicklasslagbrand.kmmtest.androidApp.feature.SpaceXViewModel
import com.nicklasslagbrand.kmmtest.androidApp.testUtils.CoroutineTestRule
import com.nicklasslagbrand.kmmtest.androidApp.testUtils.startKoin
import com.nicklasslagbrand.kmmtest.androidApp.testUtils.testObserver
import com.nicklasslagbrand.kmmtest.androidApp.testUtils.testRocketLaunch
import com.nicklasslagbrand.kmmtest.shared.data.repository.SpaceXRepository
import com.nicklasslagbrand.kmmtest.shared.domain.Result
import com.nicklasslagbrand.kmmtest.shared.domain.usecase.GetAllLaunchesUseCase
import com.nicklasslagbrand.kmmtest.shared.domain.usecase.UseCase
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import java.lang.Exception


@ExperimentalCoroutinesApi
class SpaceXViewModelTest : AutoCloseKoinTest() {
    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val viewModel: SpaceXViewModel by inject()
    private val useCase = mockk<GetAllLaunchesUseCase>()

    @Test
    fun `check viewmodel recieves launches correctly`() = runBlockingTest  {
        val observer = viewModel.launchesLiveData.testObserver()
        coEvery {
            useCase.call(UseCase.None)
        } returns Result.Success(listOf(testRocketLaunch))

        viewModel.getAllRocketLaunches()
        observer.shouldContainValues(listOf(testRocketLaunch))
    }

    @Test
    fun `check viewmodel recieves handles exception correctly`() = runBlockingTest  {
        val observer = viewModel.errorLiveData.testObserver()
        val exception = Exception()
        coEvery {
            useCase.call(UseCase.None)
        } returns Result.Failure(exception)

        viewModel.getAllRocketLaunches()
        observer.shouldContainValues(exception)
    }


    @Before
    fun setup(){
        clearAllMocks()

        startKoin(overridesModule = module(override=true) { single { useCase } })
    }

}