// 현재 Kotlin 파일을 위한 패키지를 정의합니다.
package com.example.undong

// 필요한 라이브러리 및 모듈을 가져옵니다.
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.undong.Fragment.BottomNaviActivity

class SikdanTab : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sikdan_tab)

        // 뒤로가기 버튼
        val SikBack: Button =findViewById(R.id.button10)
        SikBack.setOnClickListener {
            val intent = Intent(this, BottomNaviActivity::class.java)
            startActivity(intent) // 식단 탭 이동 후 뒤로가기 버튼
        }

        // 칼로리 탭으로 이동하는 버튼
        val CalBT:Button=findViewById(R.id.Calbutton)
        CalBT.setOnClickListener {
            val intent = Intent(this, CaloriesTab::class.java)
            startActivity(intent)
        }
    }
}
