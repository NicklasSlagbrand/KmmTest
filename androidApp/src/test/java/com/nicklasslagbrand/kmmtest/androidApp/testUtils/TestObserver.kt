package com.nicklasslagbrand.kmmtest.androidApp.testUtils

import androidx.lifecycle.*
import org.amshove.kluent.shouldContainSame
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class TestObserver<T> : Observer<T> {
    private val observedValues = mutableListOf<T>()

    override fun onChanged(value: T) {
        observedValues.add(value)
    }

    fun <T> shouldContainValues(vararg values: T) {
        observedValues.shouldContainSame(values.asList())
    }
}

fun <T> LiveData<T>.testObserver() = TestObserver<T>().also {
    observeForever(it)
}

