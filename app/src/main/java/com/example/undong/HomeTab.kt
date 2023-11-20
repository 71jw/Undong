package com.example.undong

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.undong.Fragment.BottomNaviActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeTab : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_tab)

        val CalBack: Button =findViewById(R.id.button13)

        CalBack.setOnClickListener {
            val intent = Intent(this, BottomNaviActivity::class.java)
            startActivity(intent)       //홈 탭 이동 후 뒤로가기 버튼
        }
    }
}