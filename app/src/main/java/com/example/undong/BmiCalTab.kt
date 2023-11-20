// 현재 Kotlin 파일을 위한 패키지를 정의합니다.
package com.example.undong

// 필요한 Android 및 제3자 라이브러리를 가져옵니다.
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.Slider

// AppCompatActivity를 확장하는 BmiCalTab 클래스를 선언합니다.
class BmiCalTab : AppCompatActivity() {
    // 나중에 초기화하기 위해 lateinit을 사용하여 UI 요소에 대한 변수를 선언합니다.
    lateinit var heightInput: EditText
    lateinit var weightInput: EditText
    lateinit var fab: FloatingActionButton
    lateinit var card: CardView
    lateinit var bmiText: TextView
    lateinit var label: TextView
    lateinit var res: TextView
    lateinit var feedback: TextView
    lateinit var maleButton: Button
    lateinit var femaleButton: Button

    // 활동이 생성될 때 설정을 수행하기 위해 onCreate 메서드를 재정의합니다.
    override fun onCreate(savedInstanceState: Bundle?) {
        // 상위 클래스의 onCreate 메서드를 호출합니다.
        super.onCreate(savedInstanceState)

        // XML 레이아웃 리소스에서 활동의 레이아웃을 설정합니다.
        setContentView(R.layout.activity_bmical)

        // 액션 바가 존재하면 숨깁니다.
        if (supportActionBar != null) supportActionBar?.hide()

        // UI 요소를 ID로 찾아 초기화합니다.
        heightInput = findViewById(R.id.slider1)
        weightInput = findViewById(R.id.slider2)
        fab = findViewById(R.id.floatingActionButton)
        card = findViewById(R.id.cardView)
        bmiText = findViewById(R.id.bmitext)
        res = findViewById(R.id.Result)
        label = findViewById(R.id.yourBmi)
        feedback = findViewById(R.id.Feedback)
        maleButton = findViewById(R.id.male)
        femaleButton = findViewById(R.id.female)

        // 남성 및 여성 버튼에 클릭 리스너를 설정하여 UI 요소를 변경하고 cardChanger 메서드를 호출합니다.
        maleButton.setOnClickListener {
            maleButton.isActivated = true
            femaleButton.isActivated = false
            maleButton.setBackgroundColor(Color.parseColor("#FEA595"))
            femaleButton.setBackgroundColor(Color.WHITE)
            cardChanger()
        }

        femaleButton.setOnClickListener {
            femaleButton.isActivated = true
            maleButton.isActivated = false
            femaleButton.setBackgroundColor(Color.parseColor("#FEA595"))
            maleButton.setBackgroundColor(Color.WHITE)
            cardChanger()
        }

        // 플로팅 액션 버튼에 클릭 리스너를 설정하여 cardChanger 메서드를 호출합니다.
        fab.setOnClickListener {
            cardChanger()
        }

        // "뒤로" 버튼을 찾아 클릭 리스너를 설정하여 MusansoTab 활동으로 이동합니다.
        val BCBack: Button = findViewById(R.id.button16)
        BCBack.setOnClickListener {
            val intent = Intent(this, MusansoTab::class.java)
            startActivity(intent)
            // "뒤로" 버튼이 클릭되면 MusansoTab 활동으로 이동합니다.
        }
    }

    // 카드의 가시성 변경 및 BMI에 따른 피드백을 업데이트하는 메서드를 정의합니다.
    private fun cardChanger() {
        // 특정 UI 요소의 가시성을 설정합니다.
        bmiText.visibility = View.GONE
        res.visibility = View.VISIBLE
        feedback.visibility = View.VISIBLE
        label.visibility = View.VISIBLE

        // 키와 몸무게에 대한 사용자 입력을 검색합니다.
        val heightStr = heightInput.text.toString()
        val weightStr = weightInput.text.toString()

        // 키 또는 몸무게가 제공되지 않은 경우 처리합니다.
        if (heightStr.isBlank() || weightStr.isBlank()) {
            // 키 또는 몸무게가 제공되지 않으면 메시지를 표시합니다.
            feedback.text = "키와 몸무게를 입력하세요."
            feedback.setTextColor(Color.RED)
            return
        }

        // 문자열에서 키와 몸무게를 부동 소수점으로 변환합니다.
        val height: Float = heightStr.toFloat()
        val weight: Float = weightStr.toFloat()

        // BMI를 계산합니다.
        val ans: Float = (weight) / ((height / 100) * (height / 100))
        val BMI: Double = Math.round(ans * 10.0) / 10.0

        // 계산된 BMI를 표시합니다.
        res.text = BMI.toString()

        // BMI 및 성별에 따라 피드백을 결정합니다.
        when {
            //남성 버튼이 활성화 될 경우
            maleButton.isActivated -> {
                when {
                    //BMI 가 20 미만이면 저체중
                    BMI < 20 -> {
                        feedback.text = getString(R.string.under)
                        feedback.setTextColor(Color.MAGENTA)
                    }
                    //BMI 가 24.9 이하이고 20이상이면 정상 체중
                    BMI >= 20 && BMI <= 24.9 -> {
                        feedback.text = getString(R.string.normal_weight)
                        feedback.setTextColor(Color.GREEN)
                    }
                    //BMI 가 24.9 초과면 과체중
                    BMI > 24.9 -> {
                        feedback.text = getString(R.string.over)
                        feedback.setTextColor(Color.RED)
                    }
                }
            }
            //여성 버튼이 활성화 될 경우ㅜ
            femaleButton.isActivated -> {
                when {
                    //BMI 가 18.5 미만이면 저체중
                    BMI < 18.5 -> {
                        feedback.text = getString(R.string.under)
                        feedback.setTextColor(Color.MAGENTA)
                    }
                    //BMI 가 23.9 이하이고 18.5이상이면 정상 체중
                    BMI >= 18.5 && BMI <= 23.9 -> {
                        feedback.text = getString(R.string.normal_weight)
                        feedback.setTextColor(Color.GREEN)
                    }
                    //BMI 가 23.9 초과면 과체중
                    BMI > 23.9 -> {
                        feedback.text = getString(R.string.over)
                        feedback.setTextColor(Color.RED)
                    }
                }
            }
        }
    }
}
