// 현재 Kotlin 파일을 위한 패키지를 정의합니다.
package com.example.undong

// 필요한 라이브러리 및 모듈을 가져옵니다.
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.undong.Fragment.BottomNaviActivity

// AppCompatActivity를 확장하는 MusansoTab 클래스를 선언합니다.
class MusansoTab : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_musanso_tab)

        // "스톱워치" 버튼 초기화
        val stopwatchButton: Button = findViewById(R.id.manmombutton)

        // "스톱워치" 버튼 클릭 이벤트
        stopwatchButton.setOnClickListener {
            // ManmomTab 화면으로 이동
            val intent = Intent(this, ManmomTab::class.java)
            startActivity(intent)
        }

        // "운동 칼로리 계산기" 버튼 초기화
        val exerciseCalButton: Button = findViewById(R.id.bmibutton)

        // "운동 칼로리 계산기" 버튼 클릭 이벤트
        exerciseCalButton.setOnClickListener {
            // BmiCalTab 화면으로 이동
            val intent = Intent(this, BmiCalTab::class.java)
            startActivity(intent)
        }

        // "지도" 버튼 초기화
        val mapButton: Button = findViewById(R.id.mapbutton)

        // "지도" 버튼 클릭 이벤트
        mapButton.setOnClickListener {
            // Map 화면으로 이동
            val intent = Intent(this, Map::class.java)
            startActivity(intent)
        }

        // "뒤로가기" 버튼 초기화
        val backButton: Button = findViewById(R.id.button8)

        // "뒤로가기" 버튼 클릭 이벤트
        backButton.setOnClickListener {
            // BottomNaviActivity 화면으로 이동
            val intent = Intent(this, BottomNaviActivity::class.java)
            startActivity(intent)
        }
    }
}