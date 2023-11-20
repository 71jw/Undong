package com.example.undong

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.undong.Fragment.BottomNaviActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

// AppCompatActivity를 확장하는 SettingTab 클래스를 선언합니다.
class SettingTab : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_tab)

        // 로그아웃 버튼
        val logoutButton: Button = findViewById(R.id.logoutbutton)
        logoutButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent) // 설정 탭 이동 후 로그아웃 버튼
        }

        // 회원 탈퇴 버튼
        val deleteAndLoginBack: Button = findViewById(R.id.deleteIDbutton)
        deleteAndLoginBack.setOnClickListener {
            // 아이디와 비밀번호를 가져오는 함수 호출
            val id = getIDFromSharedPreferences()
            val password = getPasswordFromSharedPreferences()

            // 아이디와 비밀번호에 해당하는 정보만 삭제
            deleteUserFromDatabase(id, password)

            // 로그인 화면으로 이동
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent) // 설정 탭 이동 후 회원탈퇴 버튼
            finish()
        }

        // 뒤로가기 버튼
        val setBack: Button = findViewById(R.id.button15)
        setBack.setOnClickListener {
            val intent = Intent(this, BottomNaviActivity::class.java)
            startActivity(intent) // 설정 탭 이동 후 뒤로가기 버튼
        }
    }

    // 회원 정보 삭제 함수
    private fun deleteUserFromDatabase(id: String, password: String) {
        val host = "database-2.c6crgkzu6rzu.ap-northeast-2.rds.amazonaws.com"
        val user = "admin"
        val dbPassword = "12345678"
        val database = "healthme"
        val url = "http://54.180.29.241:3306/user/delete?id=$id&password=$password"

        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope.launch {
            try {
                val connection = URL(url).openConnection() as HttpURLConnection
                connection.requestMethod = "DELETE"

                // 서버 응답 코드 확인
                val responseCode = connection.responseCode
                Log.d("ServerResponse", "Response Code: $responseCode")

                // UI 작업을 메인 스레드에서 처리
                runOnUiThread {
                    when (responseCode) {
                        HttpURLConnection.HTTP_NO_CONTENT -> {
                            // 삭제 성공
                            showToast("회원 탈퇴가 완료되었습니다.")
                            // 여기에서 필요한 추가 UI 작업 수행
                        }
                        else -> {
                            // 삭제 실패
                            showToast("회원 탈퇴에 실패했습니다. 응답 코드: $responseCode")
                            // 여기에서 필요한 추가 UI 작업 수행
                        }
                    }
                }

                connection.disconnect()
            } catch (e: Exception) {
                e.printStackTrace()
                // UI 작업을 메인 스레드에서 처리
                runOnUiThread {
                    // 오류 발생
                    // 여기에서 필요한 UI 작업 수행
                    showToast("오류가 발생했습니다.")
                }
            }
        }
    }

    // SharedPreferences에서 아이디 가져오는 함수
    private fun getIDFromSharedPreferences(): String {
        val sharedPreferences = getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
        return sharedPreferences.getString("id", "") ?: ""
    }

    // SharedPreferences에서 비밀번호 가져오는 함수
    private fun getPasswordFromSharedPreferences(): String {
        val sharedPreferences = getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
        return sharedPreferences.getString("password", "") ?: ""
    }

    // Toast 메시지를 띄우는 함수
    private fun showToast(message: String) {
        Toast.makeText(this@SettingTab, message, Toast.LENGTH_SHORT).show()
    }
}
