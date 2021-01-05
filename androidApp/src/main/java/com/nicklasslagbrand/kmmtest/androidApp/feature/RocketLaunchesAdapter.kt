package com.nicklasslagbrand.kmmtest.androidApp.feature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nicklasslagbrand.kmmtest.androidApp.R
import com.nicklasslagbrand.kmmtest.androidApp.core.toYearMonthDay
import com.nicklasslagbrand.kmmtest.androidApp.databinding.ItemRocketLaunchBinding
import com.nicklasslagbrand.kmmtest.shared.domain.entity.RocketLaunch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.BASIC_ISO_DATE
import java.time.format.DateTimeFormatter.ofPattern
import java.util.*
import kotlin.properties.Delegates


class RocketLaunchesAdapter : RecyclerView.Adapter<RocketLaunchesAdapter.RocketLaunchViewHolder>(){

    var clickListener: (RocketLaunch) -> Unit = {}

    var launches: List<RocketLaunch> by Delegates.observable(
        emptyList()
    ) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun getItemCount() = launches.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketLaunchViewHolder =
        RocketLaunchViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_rocket_launch,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RocketLaunchViewHolder, position: Int) {
        holder.bind(launches[position], clickListener)
    }

    class RocketLaunchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemRocketLaunchBinding.bind(view)

        fun bind(launch: RocketLaunch, clickListener: (RocketLaunch) -> Unit) {
            with(binding) {
                flightNumber.text = launch.flightNumber.toString()
                missionName.text = launch.missionName
                details.text = launch.details
                launchDateUTC.text = launch.launchDateUTC.toYearMonthDay()

                root.setOnClickListener {
                    clickListener(launch)
                }
            }
        }
    }
}