package com.example.compassmod1;

import android.app.Activity;
import android.content.Context;
import android.hardware.SensorManager;
import android.location.LocationManager;

public class SensorModule {

	//instances of sensors
	SensorManager mSensorManager;
	LocationManager mLocationManager;
	Compass mCompass;
	Position mPosition;
	//Accelerometer mAccelerometer;

	public SensorModule(Activity mActivity) { //passes in a context
		mLocationManager = (LocationManager) mActivity.getSystemService(Context.LOCATION_SERVICE);
		mSensorManager = (SensorManager) mActivity.getSystemService(Context.SENSOR_SERVICE);
		
		mPosition = new Position(mLocationManager);
		
		mCompass = new Compass(mSensorManager, mPosition);
		//mAccelerometer = new Accelerometer(mSensorManager);
	}
	
	public String getHeading(){
		return Float.toString(mCompass.getHeading());
	}
	
	public double getLatitude(){
		return mPosition.getLatitude();
	}
	
	public double getLongitude(){
		return mPosition.getLongitude();
	}


	//public String getAccelerationX()
	//{
	//return Float.toString(mAccelerometer.getAccelerationX());
	//}

	//public String getAccelerationY()
	//{
	//return Float.toString(mAccelerometer.getAccelerationY());
	//}

	//public String getAccelerationZ()
	//{
	//return Float.toString(mAccelerometer.getAccelerationZ());
	//}
	}