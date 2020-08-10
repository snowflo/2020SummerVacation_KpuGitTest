package kr.ac.kpu.kpusummerwater

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_get_address_test.*
import java.io.IOException
import java.util.*

class GetAddressTest : AppCompatActivity() {

    //debug
    var locationManager : LocationManager? = null
    private val REQUEST_CODE_LOCATION : Int = 2
    var currentLocation : String = ""
    var latitude : Double? = null
    var longitude : Double? = null

    private fun getCurrentLoc(){
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        var userLocation : Location = getLatLng()
        if (userLocation != null){
            latitude = userLocation.latitude
            longitude = userLocation.longitude
            Log.d("CheckCurrentLocation","현재 내 위치 값 : $latitude, $longitude")

            var mGeocoder = Geocoder(applicationContext, Locale.KOREAN)
            var mResultList : List<Address>? = null

            try{ //???
                mResultList = mGeocoder.getFromLocation(
                    latitude!!, longitude!!, 1
                )
            } catch (e: IOException){
                e.printStackTrace()
            }
            if (mResultList != null){
                Log.d("CheckCurrentLocation",mResultList[0].getAddressLine(0))
                currentLocation = mResultList[0].getAddressLine(0)
                //currentLocation = currentLocation.substring(11)
                test1.text = latitude as String
                test2.text = longitude as String
                test3.text = currentLocation
            }
        }
    }

    private fun getLatLng(): Location {
        var currentLatLng: Location? = null
        if(ActivityCompat.checkSelfPermission(applicationContext,
                Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(applicationContext,
                Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            getLatLng()
        }else{
            val locationProvider = LocationManager.GPS_PROVIDER
            currentLatLng = locationManager?.getLastKnownLocation(locationProvider)
        }
        return currentLatLng!!
    }
    //debug -end

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_address_test)
    }

    override fun onResume() {
        super.onResume()
        getCurrentLoc()
    }
}