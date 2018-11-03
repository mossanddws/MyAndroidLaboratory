package mossand.myandroidlaboratory;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    private TextView gravityX;
    private TextView gravityY;
    private TextView gravityZ;
    private TextView linearAccelerometerX;
    private TextView linearAccelerometerY;
    private TextView linearAccelerometerZ;
    private TextView rotationVectorX;
    private TextView rotationVectorY;
    private TextView rotationVectorZ;
    private TextView rotationVectorScalar;

    private SensorManager sensorManager;
    private Sensor gravitySensor;
    private Sensor linearAccelerometerSensor;
    private Sensor rotationVectorSensor;

    private float[] gravity;
    private float[] linearAccelerometer;
    private float[] rotationVector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        initWidgets();
        initSensors();
        initData();
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
        sensorManager.registerListener(this, linearAccelerometerSensor, SensorManager.SENSOR_DELAY_UI);
        sensorManager.registerListener(this, rotationVectorSensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case Sensor.TYPE_GRAVITY:
                showGravity(sensorEvent.values);
                break;
            case Sensor.TYPE_LINEAR_ACCELERATION:
                showLinearAccelerometer(sensorEvent.values);
                break;
            case Sensor.TYPE_ROTATION_VECTOR:
                showRotationVector(sensorEvent.values);
                break;
        }
    }

    private void initWidgets() {
        gravityX = findViewById(R.id.textView_GravityX);
        gravityY = findViewById(R.id.textView_GravityY);
        gravityZ = findViewById(R.id.textView_GravityZ);
        linearAccelerometerX = findViewById(R.id.textView_LinearAccelerometerX);
        linearAccelerometerY = findViewById(R.id.textView_LinearAccelerometerY);
        linearAccelerometerZ = findViewById(R.id.textView_LinearAccelerometerZ);
        rotationVectorX = findViewById(R.id.textView_RotationVectorX);
        rotationVectorY = findViewById(R.id.textView_RotationVectorY);
        rotationVectorZ = findViewById(R.id.textView_RotationVectorZ);
        rotationVectorScalar = findViewById(R.id.textView_RotationVectorScalar);
    }

    private void initSensors() {
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //identifySensors();
        gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        linearAccelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        rotationVectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
    }

    private void initData() {
        gravity = new float[3];
        linearAccelerometer = new float[3];
        rotationVector = new float[4];
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
        if (gravity[0] != values[0]) {
            gravity[0] = values[0];
            gravityX.setText(String.format(Locale.getDefault(), "%.3f", gravity[0]));
        }
        if (gravity[1] != values[1]) {
            gravity[1] = values[1];
            gravityY.setText(String.format(Locale.getDefault(), "%.3f", gravity[1]));
        }
        if (gravity[2] != values[2]) {
            gravity[2] = values[2];
            gravityZ.setText(String.format(Locale.getDefault(), "%.3f", gravity[2]));
        }
    }

    private void showLinearAccelerometer(float[] values) {
        if (linearAccelerometer[0] != values[0]) {
            linearAccelerometer[0] = values[0];
            linearAccelerometerX.setText(String.format(Locale.getDefault(), "%.3f", linearAccelerometer[0]));
        }
        if (linearAccelerometer[1] != values[1]) {
            linearAccelerometer[1] = values[1];
            linearAccelerometerY.setText(String.format(Locale.getDefault(), "%.3f", linearAccelerometer[1]));
        }
        if (linearAccelerometer[2] != values[2]) {
            linearAccelerometer[2] = values[2];
            linearAccelerometerZ.setText(String.format(Locale.getDefault(), "%.3f", linearAccelerometer[2]));
        }
    }

    private void showRotationVector(float[] values){
        if(rotationVector[0]!=values[0]){
            rotationVector[0]=values[0];
            rotationVectorX.setText(String.format(Locale.getDefault(), "%.3f", rotationVector[0]));
        }
        if(rotationVector[1]!=values[1]){
            rotationVector[1]=values[1];
            rotationVectorY.setText(String.format(Locale.getDefault(), "%.3f", rotationVector[1]));
        }
        if(rotationVector[2]!=values[2]){
            rotationVector[2]=values[2];
            rotationVectorZ.setText(String.format(Locale.getDefault(), "%.3f", rotationVector[2]));
        }
        if(rotationVector[3]!=values[3]){
            rotationVector[3]=values[3];
            rotationVectorScalar.setText(String.format(Locale.getDefault(), "%.3f", rotationVector[3]));
        }
    }
}
