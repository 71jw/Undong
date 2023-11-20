package com.example.undong

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.undong.Fragment.BottomNaviActivity

class CommunityTab : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_tab)

        val ComBack: Button =findViewById(R.id.button11)

        ComBack.setOnClickListener {
            val intent = Intent(this, BottomNaviActivity::class.java)
            startActivity(intent)       //커뮤니티 탭 이동 후 뒤로가기 버튼
        }
    }
}