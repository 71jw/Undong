// 현재 Kotlin 파일을 위한 패키지를 정의합니다.
package com.example.undong

// 필요한 라이브러리 및 모듈을 가져옵니다.
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.undong.Fragment.BottomNaviActivity
import com.example.undong.databinding.ActivityVideoTabBinding
import com.google.android.material.tabs.TabLayout
import kotlin.collections.Map

// AppCompatActivity를 확장하는 MusansoTab 클래스를 선언합니다.
class VideoTab : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityVideoTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.tabContent, OneFragment()).commit()

        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when(tab?.text){
                    "복근" -> transaction.replace(R.id.tabContent, OneFragment())
                    "허벅지" -> transaction.replace(R.id.tabContent, TwoFragment())
                    "엉덩이" -> transaction.replace(R.id.tabContent, ThreeFragment())
                    "팔(삼두)" -> transaction.replace(R.id.tabContent, FourFragment())
                    "팔(이두)" -> transaction.replace(R.id.tabContent, FiveFragment())
                    "등" -> transaction.replace(R.id.tabContent, SixFragment())
                    "가슴+어께" -> transaction.replace(R.id.tabContent, SevenFragment())
                }
                transaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
        })
    }
}