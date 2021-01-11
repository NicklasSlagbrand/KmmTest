package com.nicklasslagbrand.kmmtest.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nicklasslagbrand.kmmtest.androidApp.core.errorDialog
import com.nicklasslagbrand.kmmtest.androidApp.databinding.ActivityMainBinding
import com.nicklasslagbrand.kmmtest.androidApp.feature.RocketLaunchesAdapter
import com.nicklasslagbrand.kmmtest.androidApp.feature.SpaceXViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val viewModel: SpaceXViewModel by inject()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        observeLiveData()
        lifecycle.addObserver(viewModel)
    }

    private fun observeLiveData(){
        viewModel.launchesLiveData.observe(this, {
            binding.rvLaunches.adapter = RocketLaunchesAdapter().apply {
                launches = it
            }
        })

        viewModel.errorLiveData.observe(this, {
            this.errorDialog(it.localizedMessage, it.toString())
        })
    }
}
