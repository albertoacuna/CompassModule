package com.example.compassmod1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.example.compassmod1.OrientationMngr;

public class CompassSensorMngr {
    /**
     * The (absolute) pitch angle beyond which the compass will display a message telling the user
     * that his or her head is at too steep an angle to be reliable.
     */
    private static final float TOO_STEEP_PITCH_DEGREES = 70.0f;
	
    private final OrientationMngr mOrientationManager;

}
