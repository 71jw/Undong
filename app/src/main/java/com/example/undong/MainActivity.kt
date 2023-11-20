// 현재 Kotlin 파일을 위한 패키지를 정의합니다.
package com.example.undong

// 필요한 라이브러리 및 모듈을 가져옵니다.
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import com.example.undong.Fragment.BottomNaviActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

// 앱의 메인 화면을 담당하는 MainActivity 클래스를 정의합니다.
class MainActivity : AppCompatActivity() {
    // 액티비티가 생성될 때 호출되는 메서드를 재정의합니다.
    override fun onCreate(savedInstanceState: Bundle?) {
        // 상위 클래스의 onCreate 메서드를 호출합니다.
        super.onCreate(savedInstanceState)

        // 레이아웃 리소스를 설정합니다.
        setContentView(R.layout.activity_main)

        // BottomNavigationView를 찾아와 초기화합니다.
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // "유산소" 버튼을 찾아와 클릭 이벤트를 설정합니다.
        val yusansoBT: Button = findViewById(R.id.button)
        yusansoBT.setOnClickListener {
            // 유산소 탭으로 이동하는 인텐트를 생성하고 실행합니다.
            val intent = Intent(this, YusansoTab::class.java)
            startActivity(intent)
        }

        // "무산소" 버튼을 찾아와 클릭 이벤트를 설정합니다.
        val MusansoBT: Button = findViewById(R.id.button1)
        MusansoBT.setOnClickListener {
            // 무산소 탭으로 이동하는 인텐트를 생성하고 실행합니다.
            val intent = Intent(this, MusansoTab::class.java)
            startActivity(intent)
        }

        // "식단" 버튼을 찾아와 클릭 이벤트를 설정합니다.
        val SikdanBT: Button = findViewById(R.id.button2)
        SikdanBT.setOnClickListener {
            // 식단 탭으로 이동하는 인텐트를 생성하고 실행합니다.
            val intent = Intent(this, SikdanTab::class.java)
            startActivity(intent)
        }

        // "커뮤니티" 버튼을 찾아와 클릭 이벤트를 설정합니다.
        val CommunityBT: Button = findViewById(R.id.button3)
        CommunityBT.setOnClickListener {
            // 커뮤니티 탭으로 이동하는 인텐트를 생성하고 실행합니다.
            val intent = Intent(this, CommunityTab::class.java)
            startActivity(intent)
        }

        // "설정" 버튼을 찾아와 클릭 이벤트를 설정합니다.
        val SettingBT: Button = findViewById(R.id.button7)
        SettingBT.setOnClickListener {
            // 설정 탭으로 이동하는 인텐트를 생성하고 실행합니다.
            val intent = Intent(this, SettingTab::class.java)
            startActivity(intent)
        }
    }
}
