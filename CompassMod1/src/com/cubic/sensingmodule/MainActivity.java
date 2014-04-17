package com.cubic.sensingmodule;

import com.example.compassmod1.R;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.os.Handler;


public class MainActivity extends Activity{
	

	private Handler handler = new Handler();
	private TextView txtvHeading;
	private TextView txtLat; 
	private TextView txtLong;
	private SensorModule mModule;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mModule = new SensorModule(this);
        
        txtvHeading = (TextView) findViewById(R.id.txtvHeading);
        txtLat = (TextView) findViewById(R.id.txtLat);
        txtLong = (TextView) findViewById(R.id.txtLong);
    	handler.postDelayed(runnable, 0);
	}

	private Runnable runnable = new Runnable() {
		@Override
		public void run() {
			txtvHeading.setText("Heading: " + mModule.getHeading());
			txtLat.setText("Lat: " + mModule.getLatitude());
			txtLong.setText("Long: " + mModule.getLongitude());
			//yAView.setText("Y Acceleration: " + mModule.getAccelerationY());
			//zAView.setText("Z Acceleration: " + mModule.getAccelerationZ());
			handler.postDelayed(this, 10);
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
