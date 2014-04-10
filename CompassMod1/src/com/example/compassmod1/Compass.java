package com.example.compassmod1;

import com.example.compassmod1.MathUtils1;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.widget.TextView;

public class Compass implements SensorEventListener {
	
	private Sensor mMagneticSensor = null;
	private Sensor mRotationSensor = null;
	private float mHeading;
    private float mPitch;
	TextView mHeadingView;
	SensorManager mSensorManager;
    private final float[] mRotationMatrix;
    private final float[] mOrientation;

	
	public Compass (SensorManager mSM){
        mRotationMatrix = new float[16];
        mOrientation = new float[9];
		mSensorManager = mSM;
		mMagneticSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		mRotationSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
		mSensorManager.registerListener(this, mMagneticSensor, SensorManager.SENSOR_DELAY_NORMAL);
		mSensorManager.registerListener(this, mRotationSensor, SensorManager.SENSOR_DELAY_NORMAL);
	}

    @Override
    public void onSensorChanged(SensorEvent event) {
    	//mHeading = Math.round(event.values[0]); // Current angle relative to magnetic north.
    	//if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
    	      updateAzimuth(event);
    	//    }
    }
    
    public void updateAzimuth(SensorEvent event){
    		mSensorManager.getRotationMatrixFromVector(mRotationMatrix, event.values);
    		mSensorManager.remapCoordinateSystem(mRotationMatrix, SensorManager.AXIS_X, SensorManager.AXIS_Z, mRotationMatrix);
    		mSensorManager.getOrientation(mRotationMatrix, mOrientation);
    		
    		// Store the pitch (used to display a message indicating that the user's head
            // angle is too steep to produce reliable results.
            mPitch = (float) Math.toDegrees(mOrientation[1]);

            // Convert the heading (which is relative to magnetic north) to one that is
            // relative to true north, using the user's current location to compute this.
            float magneticHeading = (float) Math.toDegrees(mOrientation[0]);
            mHeading = magneticHeading; // TODO: Calculate True North
    }
    
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // not in use
    }
    
	public float getHeading() // Returns heading
	{
		return mHeading;
	}
	
    /*
    private float computeTrueNorth(float heading) {
        if (mGeomagneticField != null) {
            return heading + mGeomagneticField.getDeclination();
        } else {
            return heading;
        }
    }*/

}
