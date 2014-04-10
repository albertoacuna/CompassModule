package com.example.compassmod1;

import java.util.Timer;
import java.util.TimerTask;

import com.example.compassmod1.MathUtils1;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class MainActivity extends Activity{
	

	private Handler handler = new Handler();
	private TextView txtvHeading;
	private SensorModule mModule;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mModule = new SensorModule(this);
        
        txtvHeading = (TextView) findViewById(R.id.txtvHeading);
        
    	handler.postDelayed(runnable, 0);
	}

	private Runnable runnable = new Runnable() {
		@Override
		public void run() {
			txtvHeading.setText("Heading: " + mModule.getHeading());
			//yAView.setText("Y Acceleration: " + mModule.getAccelerationY());
			//zAView.setText("Z Acceleration: " + mModule.getAccelerationZ());
			handler.postDelayed(this, 0);
		}
	};

    @Override
    protected void onResume() {
        super.onResume();
        
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    
}
