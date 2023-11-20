// 현재 Kotlin 파일을 위한 패키지를 정의합니다.
package com.example.undong

// 필요한 라이브러리 및 모듈을 가져옵니다.
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

// 운동 칼로리 계산을 위한 활동을 나타내는 ExerciseCalTab 클래스를 정의합니다.
class ExerciseCalTab : AppCompatActivity() {
    // 사용할 뷰 요소들을 선언합니다.
    private lateinit var editTextWeight: EditText
    private lateinit var editTextDuration: EditText
    private lateinit var spinnerExercise: Spinner
    private lateinit var calculateButton: FloatingActionButton
    private lateinit var caloriesBurnedTextView: TextView

    // 활동이 생성될 때 실행되는 메서드를 재정의합니다.
    override fun onCreate(savedInstanceState: Bundle?) {
        // 상위 클래스의 onCreate 메서드를 호출합니다.
        super.onCreate(savedInstanceState)

        // 레이아웃 리소스를 설정합니다.
        setContentView(R.layout.activity_exercisecal_tab)

        // 뷰 요소들을 레이아웃에서 찾아 초기화합니다.
        editTextWeight = findViewById(R.id.TextWeight)
        editTextDuration = findViewById(R.id.TextDuration)
        spinnerExercise = findViewById(R.id.spinnerExercise)
        calculateButton = findViewById(R.id.calculateButton)
        caloriesBurnedTextView = findViewById(R.id.calorieTextView)

        // 운동 목록을 정의하고, 이를 스피너 어댑터에 연결하여 초기화합니다.
        val exerciseList = arrayOf("걷기", "계단", "등산", "수영", "요가", "복싱", "줄넘기", "자전거 타기", "달리기", "스쿼트", "사이클", "스쿼시", "훌라후프", "런닝머신", "에어로빅", "윗몸일으키기")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, exerciseList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerExercise.adapter = adapter

        // 칼로리 계산 버튼에 클릭 리스너를 설정합니다.
        calculateButton.setOnClickListener {
            // 입력된 값을 이용하여 칼로리 소모량을 계산하고 결과를 텍스트뷰에 표시합니다.
            calculateCaloriesBurned()
        }

        // 뒤로가기 버튼에 클릭 리스너를 설정하여 이전 화면으로 이동합니다.
        val YsBack: Button =findViewById(R.id.button16)
        YsBack.setOnClickListener {
            val intent = Intent(this, YusansoTab::class.java)
            startActivity(intent) // 칼로리 계산기 탭 이동 후 뒤로가기 버튼
        }
    }

    // 입력된 값을 기반으로 칼로리 소모량을 계산하고 텍스트뷰에 표시하는 메서드를 정의합니다.
    private fun calculateCaloriesBurned() {
        // 입력된 몸무게와 운동 시간을 가져옵니다.
        val weight = editTextWeight.text.toString().toDoubleOrNull()
        val duration = editTextDuration.text.toString().toDoubleOrNull()
        val exercise = spinnerExercise.selectedItem.toString()

        // 입력 값이 유효한지 확인하고, 유효하지 않으면 에러 메시지를 표시합니다.
        if (weight == null || duration == null) {
            caloriesBurnedTextView.text = "올바른 값을 입력하세요."
            return
        }

        // 칼로리 계산 메서드를 호출하여 소모량을 계산하고 결과를 텍스트뷰에 표시합니다.
        val caloriesBurned = calculateCalories(weight, duration, exercise)
        caloriesBurnedTextView.text = "칼로리 소모량: $caloriesBurned kcal"
    }

    // 실제 칼로리 계산을 수행하는 메서드를 정의합니다.
    private fun calculateCalories(weight: Double, duration: Double, exercise: String): Double {
        // 칼로리 계산 상수값을 정의합니다.
        val calPerKcal = 1000.0

        // 운동 종류에 따라 칼로리 소모량을 계산하고 반환합니다.
        return when (exercise) {
            "걷기" -> 66.4 * weight * duration / calPerKcal
            "계단" -> 122.4 * weight * duration / calPerKcal
            "등산" -> 140 * weight * duration / calPerKcal
            "수영" -> 157.5 * weight * duration / calPerKcal
            "요가" -> 43.7 * weight * duration / calPerKcal
            "복싱" -> 175.1 * weight * duration / calPerKcal
            "줄넘기" -> 175.1 * weight * duration / calPerKcal
            "자전거 타기" -> 140 * weight * duration / calPerKcal
            "달리기" -> 122.4 * weight * duration / calPerKcal
            "스쿼트" -> 122.4 * weight * duration / calPerKcal
            "사이클" -> 122.4 * weight * duration / calPerKcal
            "스쿼시" -> 210 * weight * duration / calPerKcal
            "훌라후프" -> 70 * weight * duration / calPerKcal
            "런닝머신" -> 184 * weight * duration / calPerKcal
            "에어로빅" -> 105.1 * weight * duration / calPerKcal
            "윗몸일으키기" -> 140 * weight * duration / calPerKcal
            else -> 0.0
        }
    }
}
