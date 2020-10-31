package com.example.lab4_task3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager mSensorManager;
    Sensor mGyroscope;
    ImageView detailImage;
    int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        detailImage = (ImageView) findViewById(R.id.iv);
        detailImage.setImageResource(R.drawable.img1);
    }
        @Override
        protected void onResume(){
            super.onResume();
            mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        }
        @Override
        protected void onPause () {
            super.onPause();
            mSensorManager.unregisterListener(this);
        }


        @Override
        public void onSensorChanged (SensorEvent event){
            if (event.values[0] > 0.5) {
                //Anti-Clockwise along x-axis
                detailImage.setImageResource(images[0]);
                Toast.makeText(getApplicationContext(), "Anti-Clockwise x-axis" , Toast.LENGTH_SHORT).show();

            }
            if (event.values[0] < -0.5) {
                //Clockwise along x-axis
                detailImage.setImageResource(images[1]);
                Toast.makeText(getApplicationContext(), "Clockwise x-axis" , Toast.LENGTH_SHORT).show();
            }
            if (event.values[1] > 0.5) {
                //Anti-Clockwise along y-axis
                detailImage.setImageResource(images[2]);
                Toast.makeText(getApplicationContext(), "Anti-Clockwise y-axis" , Toast.LENGTH_SHORT).show();
            }
            if (event.values[1] < -0.5) {
                //Clockwise along y-axis
                detailImage.setImageResource(images[3]);
                Toast.makeText(getApplicationContext(), "Clockwise y-axis" , Toast.LENGTH_SHORT).show();
            }
            if (event.values[2] > 0.5) {
                //Anti-Clockwise along z-axis
                detailImage.setImageResource(images[4]);
                Toast.makeText(getApplicationContext(), "Anti-Clockwise z-axis" , Toast.LENGTH_SHORT).show();
            }
            if (event.values[2] < -0.5) {
                //Clockwise along z-axis
                detailImage.setImageResource(images[5]);
                Toast.makeText(getApplicationContext(), "Clockwise z-axis" , Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onAccuracyChanged (Sensor sensor,int i){

        }
    }




