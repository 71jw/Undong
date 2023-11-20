package com.example.undong

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.undong.SignupActivity
import com.example.undong.Fragment.BottomNaviActivity
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val LoginSignup = findViewById<TextView>(R.id.registerButton)


        loginButton.setOnClickListener(View.OnClickListener {

            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()


            val serverUrl = "http://54.180.29.241:3306/users?email=$email&password=$password"



            Thread {
                try {
                    val url = URL(serverUrl)
                    val connection = url.openConnection() as HttpURLConnection
                    connection.requestMethod = "GET"


                    val responseCode = connection.responseCode

                    if (responseCode == HttpURLConnection.HTTP_OK) {

                        val reader = BufferedReader(InputStreamReader(connection.inputStream))
                        val response = StringBuilder()
                        var line: String?


                        while (reader.readLine().also { line = it } != null) {
                            response.append(line)
                        }


                        val jsonResponse = response.toString()
                        try {
                            val jsonObject = JSONObject(jsonResponse)
                            val result = jsonObject.getInt("result")

                            if (result == 0) {

                                val intent = Intent(this, BottomNaviActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else if (result == 1) {
                                runOnUiThread {
                                    Toast.makeText(applicationContext, "이메일과 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                                }
                            } else {
                                runOnUiThread {
                                    Toast.makeText(applicationContext, "서버 오류 또는 알 수 없는 오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
                                }
                            }
                        } catch (e: JSONException) {
                            e.printStackTrace()
                            runOnUiThread {
                                Toast.makeText(applicationContext, "응답 데이터 파싱 오류입니다", Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {

                        runOnUiThread {
                            Toast.makeText(applicationContext, "서버 응답 실패입니다", Toast.LENGTH_SHORT).show()
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    runOnUiThread {
                        Toast.makeText(applicationContext, "오류 발생입니다: " + e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }.start()
        })
        LoginSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

    }
}