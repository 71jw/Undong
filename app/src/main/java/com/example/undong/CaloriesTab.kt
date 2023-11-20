// 현재 Kotlin 파일을 위한 패키지를 정의합니다.
package com.example.undong

// 필요한 라이브러리 및 모듈을 가져옵니다.
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader

// 음식 영양정보를 저장하는 데이터 클래스를 정의합니다.
data class Calories(
    val name: String,
    val totalAmount: Double,
    val calories: Double,
    val carbohydrates: Double,
    val protein: Double,
    val fat: Double,
    val sugar: Double,
    val sodium: Double,
    val cholesterol: Double,
    val saturatedFat: Double,
    val transFat: Double
)

// 칼로리 정보를 검색하고 표시하는 활동을 나타내는 CaloriesTab 클래스를 정의합니다.
class CaloriesTab : AppCompatActivity() {
    // 음식 데이터를 저장할 리스트를 초기화합니다.
    private val foods = mutableListOf<Calories>()

    // 자동 완성 어댑터를 나중에 초기화하기 위해 선언합니다.
    private lateinit var autoCompleteAdapter: ArrayAdapter<String>

    // 활동이 생성될 때 실행되는 메서드를 재정의합니다.
    override fun onCreate(savedInstanceState: Bundle?) {
        // 상위 클래스의 onCreate 메서드를 호출합니다.
        super.onCreate(savedInstanceState)

        // 레이아웃 리소스를 설정합니다.
        setContentView(R.layout.activity_calories)

        // CSV 파일에서 음식 데이터를 읽어옵니다.
        readCsvFile()

        // 검색 버튼 및 자동 완성 텍스트뷰를 찾아 초기화합니다.
        val searchButton = findViewById<Button>(R.id.searchButton)
        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)

        // 자동 완성 어댑터를 초기화하고 텍스트뷰에 적용합니다.
        autoCompleteAdapter =
            ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, getFoodNames())
        autoCompleteTextView.setAdapter(autoCompleteAdapter)
        autoCompleteTextView.threshold = 1 // Threshold 설정

        // 검색 버튼에 클릭 리스너를 설정하여 검색어를 전달하고 결과를 표시합니다.
        searchButton.setOnClickListener(View.OnClickListener {
            val searchKeyword = autoCompleteTextView.text.toString()
            Log.d("TAG", "검색어: $searchKeyword")
            searchAndDisplayResults(searchKeyword)
        })
    }

    // CSV 파일에서 음식 데이터를 읽어와서 foods 리스트에 저장하는 메서드를 정의합니다.
    private fun readCsvFile() {
        // CSV 파일 읽기
        val csvFilePath = "Calorie1.csv"
        val reader = BufferedReader(InputStreamReader(assets.open(csvFilePath)))

        var line: String?
        while (reader.readLine().also { line = it } != null) {
            val tokens = line?.split(",") ?: continue

            if (tokens.size >= 11) {
                try {
                    // 각 열에 해당하는 값을 읽어와서 Calories 객체로 변환하여 리스트에 추가합니다.
                    val food = Calories(
                        name = tokens[0],
                        totalAmount = tokens[1].toDouble(),
                        calories = tokens[2].toDouble(),
                        carbohydrates = tokens[3].toDouble(),
                        protein = tokens[4].toDouble(),
                        fat = tokens[5].toDouble(),
                        sugar = tokens[6].toDouble(),
                        sodium = tokens[7].toDouble(),
                        cholesterol = tokens[8].toDouble(),
                        saturatedFat = tokens[9].toDouble(),
                        transFat = tokens[10].toDouble()
                    )

                    foods.add(food)
                } catch (e: NumberFormatException) {
                    e.printStackTrace()
                }
            }
        }
    }

    // 검색어에 해당하는 음식을 찾아서 결과를 텍스트뷰에 표시하는 메서드를 정의합니다.
    private fun searchAndDisplayResults(keyword: String) {
        // 검색된 음식을 필터링하여 리스트에 저장합니다.
        val searchedFoods =
            foods.filter { it.name.startsWith(keyword, ignoreCase = true) }

        // 검색 결과를 텍스트로 구성합니다.
        val resultText = if (searchedFoods.isNotEmpty()) {
            buildString {
                for (food in searchedFoods) {
                    append("음식명: ${food.name}\n")
                    append("총내용량: ${food.totalAmount} g\n")
                    append("열량(1회 제공량 당): ${food.calories} kcal\n")
                    append("탄수화물(1회 제공량 당): ${food.carbohydrates} g\n")
                    append("단백질(1회 제공량 당): ${food.protein} g\n")
                    append("지방(1회 제공량 당): ${food.fat} g\n")
                    append("당류(1회 제공량 당): ${food.sugar} g\n")
                    append("나트륨(1회 제공량 당): ${food.sodium} mg\n")
                    append("콜레스테롤(1회 제공량 당): ${food.cholesterol} mg\n")
                    append("포화지방산(1회 제공량 당): ${food.saturatedFat} g\n")
                    append("트랜스지방(1회 제공량 당): ${food.transFat} g\n")
                    append("---------------\n")
                }
            }
        } else {
            "검색된 음식이 없습니다."
        }

        // 결과를 표시할 텍스트뷰를 찾아 초기화합니다.
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        resultTextView.text = resultText
    }

    // foods 리스트에서 음식명만 추출하여 리스트로 반환하는 메서드를 정의합니다.
    private fun getFoodNames(): List<String> {
        return foods.map { it.name }
    }
}
