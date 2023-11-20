package com.example.undong

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.JsonObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import android.text.Editable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject


class SignupActivity : AppCompatActivity() {
    private var emailEditText: TextInputEditText? = null
    private var passwordEditText: TextInputEditText? = null
    private var confirmPasswordEditText: TextInputEditText? = null
    private var nameEditText: TextInputEditText? = null
    private var phoneNumberEditText: TextInputEditText? = null
    private var nicknameEditText: TextInputEditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val signUpButton = findViewById<Button>(R.id.signup_button)
        emailEditText = findViewById(R.id.ID_textField_editText)
        passwordEditText = findViewById(R.id.PW_textField_editText)
        confirmPasswordEditText = findViewById(R.id.PW_Re_textField_editText)
        nameEditText = findViewById(R.id.username_editText)
        phoneNumberEditText = findViewById(R.id.user_phone_number_editText)
        nicknameEditText = findViewById(R.id.user_nickname_editText)

        signUpButton.setOnClickListener { view: View? ->
            if (validateForm()) {
                val email = emailEditText?.getText().toString()
                val password = passwordEditText?.getText().toString()
                val name = nameEditText?.getText().toString()
                val phoneNumber = phoneNumberEditText?.getText().toString()
                val username = nicknameEditText?.getText().toString()
                val url = "http://54.180.29.241:3306/signup"
                val client = OkHttpClient()
                val json = JsonObject()
                json.addProperty("email", email)
                json.addProperty("password", password)
                json.addProperty("name", name)
                json.addProperty("phoneNumber", phoneNumber)
                json.addProperty("username", username)
                val requestBody = json.toString().toRequestBody("application/json".toMediaType())
                val request = Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build()


                val coroutineScope = CoroutineScope(IO)
                coroutineScope.launch {
                    try {
                        val response = client.newCall(request).execute()
                        if (response.isSuccessful) {
                            val intent =
                                Intent(this@SignupActivity, LoginActivity::class.java)
                            startActivity(intent)
                            runOnUiThread {
                                Toast.makeText(
                                    this@SignupActivity,
                                    "회원가입 성공!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            runOnUiThread {
                                Toast.makeText(
                                    this@SignupActivity,
                                    "회원가입 실패",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        runOnUiThread {
                            Toast.makeText(
                                this@SignupActivity,
                                "오류 발생",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }


        val checkIdButton = findViewById<Button>(R.id.check_id_button)
        val checkNicknameButton = findViewById<Button>(R.id.check_nickname_button)

        checkIdButton.setOnClickListener {
            val email = emailEditText?.text.toString()


            fun isIdUnique(email: String): Boolean {
                val client = OkHttpClient()
                val url = "http://54.180.29.241:3306/signup1?email=$email" // 실제 서버 URL로 대체하세요.
                val request = Request.Builder()
                    .url(url)
                    .get()
                    .build()

                val response = client.newCall(request).execute()
                val responseData = response.body?.string()

                return try {
                    val jsonObject = JSONObject(responseData)
                    val result = jsonObject.getInt("result")
                    result == 0
                } catch (e: Exception) {
                    e.printStackTrace()
                    false
                }
            }

            fun isNicknameUnique(username: String): Boolean {
                val client = OkHttpClient()
                val url = "http://54.180.29.241:3306/signup2?username=$username" // 실제 서버 URL로 대체하세요.
                val request = Request.Builder()
                    .url(url)
                    .get()
                    .build()

                val response = client.newCall(request).execute()
                val responseData = response.body?.string()

                return try {
                    val jsonObject = JSONObject(responseData)
                    val result = jsonObject.getInt("result")
                    result == 0
                } catch (e: Exception) {
                    e.printStackTrace()
                    false
                }
            }

            CoroutineScope(IO).launch {
                val isUnique = isIdUnique(email)
                withContext(Dispatchers.Main) {
                    if (isUnique) {
                        Toast.makeText(this@SignupActivity, "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        emailEditText?.error = "이미 사용 중인 아이디입니다."
                    }
                }
            }
        }

        checkNicknameButton.setOnClickListener {
            val username = nicknameEditText?.text.toString()


            fun isIdUnique(email: String): Boolean {
                val client = OkHttpClient()
                val url = "http://54.180.29.241:3306/signup1?email=$email" // 실제 서버 URL로 대체하세요.
                val request = Request.Builder()
                    .url(url)
                    .get()
                    .build()

                val response = client.newCall(request).execute()
                val responseData = response.body?.string()

                return try {
                    val jsonObject = JSONObject(responseData)
                    val result = jsonObject.getInt("result")
                    result == 0
                } catch (e: Exception) {
                    e.printStackTrace()
                    false
                }
            }

            fun isNicknameUnique(username: String): Boolean {
                val client = OkHttpClient()
                val url = "http://54.180.29.241:3306/signup2?username=$username" // 실제 서버 URL로 대체하세요.
                val request = Request.Builder()
                    .url(url)
                    .get()
                    .build()

                val response = client.newCall(request).execute()
                val responseData = response.body?.string()

                return try {
                    val jsonObject = JSONObject(responseData)
                    val result = jsonObject.getInt("result")
                    result == 0
                } catch (e: Exception) {
                    e.printStackTrace()
                    false
                }
            }


            CoroutineScope(IO).launch {
                val isUnique = isNicknameUnique(username)
                withContext(Dispatchers.Main) {
                    if (isUnique) {
                        Toast.makeText(this@SignupActivity, "사용 가능한 닉네임입니다.", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        nicknameEditText?.error = "이미 사용 중인 닉네임입니다."
                    }
                }
            }
        }



    }


    private fun validateForm(): Boolean {
        val email = emailEditText!!.text.toString()
        val password = passwordEditText!!.text.toString()
        val confirmPassword = confirmPasswordEditText!!.text.toString()
        val name = nameEditText!!.text.toString()
        val phoneNumber = phoneNumberEditText!!.text.toString()
        val username = nicknameEditText!!.text.toString()
        var valid = true
        if (!isValidEmail(email)) {
            emailEditText!!.error = "올바른 이메일을 입력하세요."
            valid = false
        } else {
            emailEditText!!.error = null
        }
        if (password.length < 7) {
            passwordEditText!!.error = "비밀번호는 7자 이상 입력해주세요."
            valid = false
        } else {
            passwordEditText!!.error = null
        }
        if (password != confirmPassword) {
            confirmPasswordEditText!!.error = "비밀번호가 일치하지 않습니다."
            valid = false
        } else {
            confirmPasswordEditText!!.error = null
        }
        if (!isValidPhoneNumber(phoneNumber)) {
            phoneNumberEditText!!.error = "올바른 핸드폰 번호를 입력하세요."
            valid = false
        } else {
            phoneNumberEditText!!.error = null
        }
        if (name.isEmpty() || username.isEmpty()) {
            Toast.makeText(this, "빈칸을 입력하세요.", Toast.LENGTH_SHORT).show()
            valid = false
        }
        return valid
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}"
        return email.matches(emailPattern.toRegex())
    }

    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val phoneNumberPattern = "^01[0-9]{8,9}$"
        return phoneNumber.matches(phoneNumberPattern.toRegex())
    }
}