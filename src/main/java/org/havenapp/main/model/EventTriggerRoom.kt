package org.havenapp.main.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.content.Context
import org.havenapp.main.R
import java.util.*

/**
 * Created by Arka Prava Basu <arkaprava94@gmail.com> on 22/5/18.
 */
@Entity(tableName = "event_trigger_table")
class EventTriggerRoom {
    companion object {
        /**
         * Acceleration detected message
         */
        val ACCELEROMETER = 0

        /**
         * Camera motion detected message
         */
        val CAMERA = 1

        /**
         * Mic noise detected message
         */
        val MICROPHONE = 2

        /**
         * Pressure change detected message
         */
        val PRESSURE = 3

        /**
         * Light change detected message
         */
        val LIGHT = 4

        /**
         * Power change detected message
         */
        val POWER = 5

        /**
         * Significant motion detected message
         */
        val BUMP = 6

        /**
         * Significant motion detected message
         */
        val CAMERA_VIDEO = 7

        /**
         * Heartbeat notification message
         */
        val HEART = 8
    }

    @PrimaryKey(autoGenerate = true)
    private var id : Long = 0

    private var mType: Int = 0

    // Trigger time
    private val mTime: Date = Date()

    var mEventId: Long = 0

    private var mPath: String? = null

    fun getStringType(context: Context): String {
        var sType = ""

        sType = when (mType) {
            ACCELEROMETER -> context.getString(R.string.sensor_accel)
            LIGHT -> context.getString(R.string.sensor_light)
            CAMERA -> context.getString(R.string.sensor_camera)
            MICROPHONE -> context.getString(R.string.sensor_sound)
            POWER -> context.getString(R.string.sensor_power)
            BUMP -> context.getString(R.string.sensor_bump)
            CAMERA_VIDEO -> context.getString(R.string.sensor_camera_video)
            HEART -> context.getString(R.string.sensor_heartbeat)
            else -> context.getString(R.string.sensor_unknown)
        }

        return sType
    }

    fun getMimeType(): String? {
        var mimeType: String? = ""

        mimeType = when (mType) {
            CAMERA -> "image/*"
            MICROPHONE -> "audio/*"
            CAMERA_VIDEO -> "video/*"
            else -> null
        }

        return mimeType
    }
}