package com.nicklasslagbrand.kmmtest.androidApp.core

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.nicklasslagbrand.kmmtest.androidApp.R
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


fun Activity.errorDialog(errorMsg: String?, errorTitle: String?) {
    MaterialAlertDialogBuilder(this)
        .setTitle(errorTitle)
        .setMessage(errorMsg)
        .setPositiveButton(android.R.string.ok) { dialog, _ ->
            dialog.dismiss()
        }
        .show()

}

fun String.toYearMonthDay(): String {
    val inputFormatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    val outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
    val date4 = LocalDate.parse(this, inputFormatter)
    return outputFormatter.format(date4)
}

