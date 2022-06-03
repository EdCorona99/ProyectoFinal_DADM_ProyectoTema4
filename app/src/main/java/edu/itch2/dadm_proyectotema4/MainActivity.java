package edu.itch2.dadm_proyectotema4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);


        // This is checking if the sensor is null, if it is, it will finish the activity.
        if (sensor == null){
            finish();
        }

        // Creating a new SensorEventListener and then calling the start method.
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.values[0]<sensor.getMaximumRange()){
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                } else {
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        start();


    }

    /**
     * Register a SensorEventListener to receive updates from the sensor at a rate of 2Hz.
     */
    public void start(){
        sensorManager.registerListener(sensorEventListener, sensor,2000*1000);
    }

    /**
     * Stop listening for sensor events.
     */
    public void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    /**
     * It stops the camera preview.
     */
    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    /**
     * `start()` will start the camera preview and will also start the `onFrame()` callback
     */
    @Override
    protected void onResume() {
        start();
        super.onResume();
    }

}