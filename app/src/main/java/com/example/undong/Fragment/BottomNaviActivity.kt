package com.example.undong.Fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.undong.CalenderTab
import com.example.undong.CommunityTab
import com.example.undong.Fragment.HomeFragment
import com.example.undong.Fragment.MapFragment
import com.example.undong.Fragment.VideoFragment
import com.example.undong.HomeTab
import com.example.undong.MusansoTab
import com.example.undong.MypageTab
import com.example.undong.R
import com.example.undong.SettingTab
import com.example.undong.SikdanTab
import com.example.undong.YusansoTab
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNaviActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navi)



        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)


        // 앱 실행 시 초기 프래그먼트를 표시
        if (savedInstanceState == null) {
            val initialFragment = HomeFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, initialFragment)
                .commit()
        }

        // MainActivity에서의 버튼들을 추가
        val includedButton = findViewById<Button>(R.id.button)
        val includedButton1 = findViewById<Button>(R.id.button1)
        val includedButton2 = findViewById<Button>(R.id.button2)
        val includedButton3 = findViewById<Button>(R.id.button3)



        val includedButton7 = findViewById<Button>(R.id.button7)

        // 버튼에 대한 작업을 추가
        includedButton.setOnClickListener {
            // 버튼의 작업
            val intent = Intent(this, YusansoTab::class.java)
            startActivity(intent)

        }

        includedButton1.setOnClickListener {
            // 버튼1의 작업
            val intent = Intent(this, MusansoTab::class.java)
            startActivity(intent)
        }

        includedButton2.setOnClickListener {
            // 버튼2의 작업
            val intent = Intent(this, SikdanTab::class.java)
            startActivity(intent)
        }

        includedButton3.setOnClickListener {
            // 버튼3의 작업
            val intent = Intent(this, CommunityTab::class.java)
            startActivity(intent)
        }







        includedButton7.setOnClickListener {
            // 버튼7의 작업
            val intent = Intent(this, SettingTab::class.java)
            startActivity(intent)
        }

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            val fragment: Fragment = when (menuItem.itemId) {
                R.id.navigation_video -> {
                    val intent = Intent(this, CalenderTab::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_home -> {
                    val intent = Intent(this, HomeTab::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_list -> {
                    val intent = Intent(this, MypageTab::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }


                else -> HomeFragment() // 기본적으로 HomeFragment를 표시
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, fragment)
                .commit()
            true
        }

    }
}