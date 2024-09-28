package com.udacity.asteroidradar.util

import com.udacity.asteroidradar.Constants
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun getFormattedToday(): String {
    val calendar = Calendar.getInstance()
    val currentTime = calendar.time
    val dateFormat = SimpleDateFormat(Constants.API_QUERY_DATE_FORMAT, Locale.getDefault())

    return dateFormat.format(currentTime)
}