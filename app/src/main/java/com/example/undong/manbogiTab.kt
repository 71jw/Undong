package com.example.undong

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.undong.Fragment.BottomNaviActivity

// AppCompatActivity를 확장하는 manbogiTab 클래스를 선언합니다.
class manbogiTab : AppCompatActivity(), SensorEventListener {



    private lateinit var sensorManager: SensorManager
    private var stepCountSensor: Sensor? = null
    private lateinit var stepCountView: TextView
    private lateinit var resetButton: Button


    private var currentSteps = 0

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manbogi_tab)

        val chronometer1 = findViewById<Chronometer>(R.id.chronometer)
        val startbutton = findViewById<Button>(R.id.start_btn)
        val stopbutton = findViewById<Button>(R.id.stop_btn)
        val resetbutton = findViewById<Button>(R.id.reset_btn)



        var isRunning = false
        var lastPause: Long = 0


        startbutton.setOnClickListener {
            if (!isRunning) {
                if (lastPause == 0L) {
                    chronometer1.base = SystemClock.elapsedRealtime()
                } else {
                    val interval = SystemClock.elapsedRealtime() - lastPause
                    chronometer1.base += interval
                }
                chronometer1.start()
                isRunning = true
                startbutton.isEnabled = false
                stopbutton.isEnabled = true
                resetbutton.isEnabled = true
            }
        }


        stopbutton.setOnClickListener {
            if (isRunning) {
                chronometer1.stop()
                lastPause = SystemClock.elapsedRealtime()
                isRunning = false
                startbutton.isEnabled = true
                stopbutton.isEnabled = false
            }
        }


        resetbutton.setOnClickListener {
            chronometer1.base = SystemClock.elapsedRealtime()
            chronometer1.stop()
            isRunning = false
            lastPause = 0
            startbutton.isEnabled = true
            stopbutton.isEnabled = false
            resetbutton.isEnabled = false
        }



        stepCountView = findViewById(R.id.stepCountView)
        resetButton = findViewById(R.id.resetButton)


        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACTIVITY_RECOGNITION
            ) == PackageManager.PERMISSION_DENIED
        ) {
            requestPermissions(arrayOf(Manifest.permission.ACTIVITY_RECOGNITION), 0)
        }


        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        stepCountSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)


        if (stepCountSensor == null) {
            Toast.makeText(this, "No Step Sensor", Toast.LENGTH_SHORT).show()
        }


        resetButton.setOnClickListener {

            currentSteps = 0
            stepCountView.text = currentSteps.toString()


        }
        val YsBack: Button =findViewById(R.id.button16)

        YsBack.setOnClickListener {
            val intent = Intent(this, YusansoTab::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        stepCountSensor?.let {

            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_FASTEST)
        }
    }

    override fun onSensorChanged(event: SensorEvent) {

        if (event.sensor.type == Sensor.TYPE_STEP_DETECTOR) {
            if (event.values[0] == 1.0f) {

                currentSteps++
                stepCountView.text = currentSteps.toString()
            }

        }
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
}