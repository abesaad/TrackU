package com.uninorte.edu.co.tracku.com.uninorte.edu.co.tracku.gps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;

public class GPSManager implements LocationListener {

    Context context;
    LocationManager locationManager;
    GPSManagerInterface caller;

    public GPSManager(Context applicationContext,GPSManagerInterface caller) {
        context = applicationContext;
        this.caller=caller;
    }

    public void InitLocationManager() {
        try {
            locationManager = (LocationManager) context.
                    getSystemService(Context.LOCATION_SERVICE);
            if (ActivityCompat.checkSelfPermission(context,
                    Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(context,
                    Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.
                    getLastKnownLocation(LocationManager.GPS_PROVIDER);
            locationManager.
                    requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    0, 30, this,
                    Looper.getMainLooper());
        }catch (Exception error){

        }
    }

    @Override
    public void onLocationChanged(Location location) {
        caller.LocationReceived(location.getLatitude(),location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
