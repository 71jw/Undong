// 현재 Kotlin 파일을 위한 패키지를 정의합니다.
package com.example.undong

// 필요한 라이브러리 및 모듈을 가져옵니다.
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// AppCompatActivity를 확장하는 PushUp 클래스를 선언합니다.
class PushUp : AppCompatActivity() {
    private lateinit var chronometer1: Chronometer
    private lateinit var startButton: Button
    private lateinit var stopButton: Button
    private lateinit var resetButton: Button
    private lateinit var restTimerText: TextView
    private lateinit var vibrator: Vibrator

    private var isRunning = false
    private var lastPause: Long = 0
    private var restTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pushup)

        // UI 요소 초기화
        chronometer1 = findViewById(R.id.chronometer)
        startButton = findViewById(R.id.start_btn)
        stopButton = findViewById(R.id.stop_btn)
        resetButton = findViewById(R.id.reset_btn)
        restTimerText = findViewById(R.id.rest_timer)
        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        // 시작 버튼 클릭 이벤트 설정
        startButton.setOnClickListener {
            if (!isRunning) {
                if (lastPause == 0L) {
                    chronometer1.base = SystemClock.elapsedRealtime()
                } else {
                    val interval = SystemClock.elapsedRealtime() - lastPause
                    chronometer1.base += interval
                }
                chronometer1.start()

                isRunning = true
                startButton.isEnabled = false
                stopButton.isEnabled = true
                resetButton.isEnabled = true

                // 푸시업 1분 후 쉬는 시간 설정
                restTimer = object : CountDownTimer(20000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        val secondsRemaining = millisUntilFinished / 1000
                        restTimerText.text = "쉬는 시간: ${secondsRemaining}초"
                    }

                    override fun onFinish() {
                        restTimerText.text = "쉬는 시간 끝! 다시 타이머를 눌러주세요"
                    }
                }

                chronometer1.postDelayed({
                    stopButton.performClick()
                    restTimer?.start()
                }, 61000)
            }
        }

        // 정지 버튼 클릭 이벤트 설정
        stopButton.setOnClickListener {
            if (isRunning) {
                chronometer1.stop()
                lastPause = SystemClock.elapsedRealtime()
                isRunning = false
                startButton.isEnabled = true
                stopButton.isEnabled = false
                restTimer?.cancel()
                restTimerText.text = ""
            }
        }

        // 리셋 버튼 클릭 이벤트 설정
        resetButton.setOnClickListener {
            chronometer1.base = SystemClock.elapsedRealtime()
            chronometer1.stop()
            isRunning = false
            lastPause = 0
            startButton.isEnabled = true
            stopButton.isEnabled = false
            resetButton.isEnabled = false
            restTimer?.cancel()
            restTimerText.text = ""
        }
    }
}