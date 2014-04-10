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
		//mSensorMngr = mSM;
		//mMagneticSensor = mSensorMngr.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		//mRotationSensor = mSensorMngr.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
		//mSensorMngr.registerListener(this, mMagneticSensor, SensorManager.)
		
		mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR), SensorManager.SENSOR_DELAY_UI);

            // The rotation vector sensor doesn't give us accuracy updates, so we observe the
            // magnetic field sensor solely for those.
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_UI);
		
        mRotationMatrix = new float[16];
        mOrientation = new float[9];
	}

    @Override
    public void onSensorChanged(SensorEvent event) {
    	mHeading = Math.round(event.values[0]); // Current angle relative to magnetic north.
    	
    	if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR){
    		mSensorManager.getRotationMatrixFromVector(mRotationMatrix, event.values);
    		mSensorManager.remapCoordinateSystem(mRotationMatrix, SensorManager.AXIS_X,
                    SensorManager.AXIS_Z, mRotationMatrix);
    		mSensorManager.getOrientation(mRotationMatrix, mOrientation);
    		
    		// Store the pitch (used to display a message indicating that the user's head
            // angle is too steep to produce reliable results.
            mPitch = (float) Math.toDegrees(mOrientation[1]);

            // Convert the heading (which is relative to magnetic north) to one that is
            // relative to true north, using the user's current location to compute this.
            float magneticHeading = (float) Math.toDegrees(mOrientation[0]);
            mHeading = magneticHeading; // TODO: Calculate True North
    	}
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
