package mossand.myandroidlaboratory;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor gravitySensor;
    private int x1 = 0;
    private int x2 = 0;
    private int x3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //identifySensors();
        gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, gravitySensor, SensorManager.SENSOR_DELAY_UI);
    }

    /*
    private void identifySensors() {
        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        System.out.println("---------------------------------------------------");
        for (Sensor sensor : deviceSensors) {
            System.out.println(sensor.getName());
        }
        System.out.println("---------------------------------------------------");
    }
    */

    private void showGravity(float[] values) {
        System.out.print("values[0] : " + values[0]);
        System.out.print(", values[1] : " + values[1]);
        System.out.println(", values[2] : " + values[2]);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case Sensor.TYPE_GRAVITY:
                showGravity(sensorEvent.values);
                break;

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
