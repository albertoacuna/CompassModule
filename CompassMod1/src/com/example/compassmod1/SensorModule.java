package com.example.compassmod1;

import android.app.Activity;
import android.content.Context;
import android.hardware.SensorManager;

public class SensorModule {

	//instances of sensors
	SensorManager mSensorManager;
	Compass mCompass;
	//Accelerometer mAccelerometer;

	public SensorModule(Activity mActivity) { //passes in a context

		mSensorManager = (SensorManager) mActivity.getSystemService(Context.SENSOR_SERVICE);
		mCompass = new Compass(mSensorManager);
		//mAccelerometer = new Accelerometer(mSensorManager);
	}
	
	public String getHeading(){
		return Float.toString(mCompass.getHeading());
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