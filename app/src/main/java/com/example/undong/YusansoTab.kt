// 현재 Kotlin 파일을 위한 패키지를 정의합니다.
package com.example.undong

// 필요한 라이브러리 및 모듈을 가져옵니다.
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.undong.Fragment.BottomNaviActivity

// AppCompatActivity를 확장하는 YusansoTab 클래스를 선언합니다.
class YusansoTab : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yusanso_tab)

        // 스톱워치 버튼 초기화
        val manbogiBT: Button = findViewById(R.id.stbutton)
        manbogiBT.setOnClickListener {
            val intent = Intent(this, manbogiTab::class.java)
            startActivity(intent)
        }

        // 운동 칼로리 계산기 버튼 초기화
        val ExCalBT: Button = findViewById(R.id.excalbutton)
        ExCalBT.setOnClickListener {
            val intent = Intent(this, ExerciseCalTab::class.java)
            startActivity(intent)
        }

        // 뒤로가기 버튼 초기화
        val YsBack: Button = findViewById(R.id.button8)
        YsBack.setOnClickListener {
            val intent = Intent(this, BottomNaviActivity::class.java)
            startActivity(intent) // 유산소탭 이동 후 뒤로가기 버튼
        }
    }
}