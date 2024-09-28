package com.udacity.asteroidradar.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.udacity.asteroidradar.database.AsteroidsDatabase
import com.udacity.asteroidradar.database.getDatabase
import com.udacity.asteroidradar.util.getFormattedToday

class DeleteAsteroidsWorker(appContext: Context,
    params: WorkerParameters
) : Worker(appContext, params) {

    override fun doWork(): Result {
        return try {
            // Add the logic to delete old asteroids here
            val database = getDatabase(applicationContext)
            val today = getFormattedToday()

            // Delete asteroids older than today
            database.asteroidDao.deleteOldAsteroids(today)

            Result.success()
        } catch (exception: Exception) {
            Result.failure()
        }
    }
}