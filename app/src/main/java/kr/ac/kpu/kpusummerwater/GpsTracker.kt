/*
package kr.ac.kpu.kpusummerwater

import android.app.Service
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.IBinder

class GpsTracker : Service(), LocationListener {

    lateinit private var mContext: Context
    lateinit var location: Location
    lateinit var locationManager: LocationManager
    var latitude:Double = 0.0
    var longitude:Double = 0.0

    private val MIN_DISTANCE_CHANGE_FOR_UPDATES: Long = 10
    private val MIN_TIME_BW_UPDATES = 1000 * 60 * 1.toLong()

    }


    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onLocationChanged(p0: Location) {
        TODO("Not yet implemented")
    }

}
*/