// 현재 Kotlin 파일을 위한 패키지를 정의합니다.
package com.example.undong

// 필요한 라이브러리 및 모듈을 가져옵니다.
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import com.example.undong.Fragment.BottomNaviActivity

// AppCompatActivity를 확장하는 StopwatchTab 클래스를 선언합니다.
class StopwatchTab : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch_tab)

        // 스톱워치 관련 UI 요소 초기화
        val chronometer1 = findViewById<Chronometer>(R.id.chronometer)
        val startButton = findViewById<Button>(R.id.start_btn)
        val stopButton = findViewById<Button>(R.id.stop_btn)
        val resetButton = findViewById<Button>(R.id.reset_btn)

        // 스톱워치 상태 변수
        var isRunning = false
        var lastPause: Long = 0

        // 시작 버튼 클릭 이벤트
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
            }
        }

        // 정지 버튼 클릭 이벤트
        stopButton.setOnClickListener {
            if (isRunning) {
                chronometer1.stop()
                lastPause = SystemClock.elapsedRealtime()
                isRunning = false
                startButton.isEnabled = true
                stopButton.isEnabled = false
            }
        }

        // 리셋 버튼 클릭 이벤트
        resetButton.setOnClickListener {
            chronometer1.base = SystemClock.elapsedRealtime()
            chronometer1.stop()
            isRunning = false
            lastPause = 0
            startButton.isEnabled = true
            stopButton.isEnabled = false
            resetButton.isEnabled = false
        }

        // 뒤로가기 버튼
        val MsBack: Button =findViewById(R.id.button17)
        MsBack.setOnClickListener {
            val intent = Intent(this, MusansoTab::class.java)
            startActivity(intent) // 스톱워치 탭으로 이동 후 뒤로가기 버튼
        }
    }
}