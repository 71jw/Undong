// 현재 Kotlin 파일을 위한 패키지를 정의합니다.
package com.example.undong

// 필요한 라이브러리 및 모듈을 가져옵니다.
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

// AppCompatActivity를 확장하는 ManmomTab 클래스를 선언합니다.
class ManmomTab : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manmom)

        // "뒤로가기" 버튼 초기화
        val backButton: Button = findViewById(R.id.button9)

        // "뒤로가기" 버튼 클릭 이벤트
        backButton.setOnClickListener {
            // 무산소 탭으로 이동
            val intent = Intent(this, MusansoTab::class.java)
            startActivity(intent)
        }

        // "팔굽혀펴기1 시작" 버튼 초기화
        val pushUp1Button: Button = findViewById(R.id.startpushup1)

        // "팔굽혀펴기1 시작" 버튼 클릭 이벤트
        pushUp1Button.setOnClickListener {
            // 팔굽혀펴기 화면으로 이동
            val intent = Intent(this, PushUp::class.java)
            startActivity(intent)
        }

        // "팔굽혀펴기2 시작" 버튼 초기화
        /*val pushUp2Button: Button = findViewById(R.id.startpushup2)

        // "팔굽혀펴기2 시작" 버튼 클릭 이벤트
        pushUp2Button.setOnClickListener {
            // ThirdActivity 화면으로 이동 (주석 해제 후 사용)
            // val intent = Intent(this, ThirdActivity::class.java)
            // startActivity(intent)
        }*/
    }
}
