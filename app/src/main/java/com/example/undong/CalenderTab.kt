// 현재 Kotlin 파일을 위한 패키지를 정의합니다.
package com.example.undong

// 필요한 라이브러리 및 모듈을 가져옵니다.
import android.annotation.SuppressLint
import java.io.FileInputStream
import java.io.FileOutputStream

import android.view.View
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.undong.R

// AppCompatActivity를 확장하는 CalenderTab 클래스를 선언합니다.
class CalenderTab : AppCompatActivity() {
    // 사용자 ID를 저장할 변수를 선언하고 초기값을 설정합니다.
    var userID: String = "userID"

    // 파일 이름 및 문자열 변수를 나중에 초기화하기 위해 lateinit을 사용하여 선언합니다.
    lateinit var fname: String
    lateinit var str: String

    // UI 요소에 대한 변수를 선언합니다.
    lateinit var calendarView: CalendarView
    lateinit var updateBtn: Button
    lateinit var deleteBtn: Button
    lateinit var saveBtn: Button
    lateinit var diaryTextView: TextView
    lateinit var diaryContent: TextView
    lateinit var title: TextView
    lateinit var contextEditText: EditText

    // 활동이 생성될 때 설정을 수행하기 위해 onCreate 메서드를 재정의합니다.
    override fun onCreate(savedInstanceState: Bundle?) {
        // 상위 클래스의 onCreate 메서드를 호출합니다.
        super.onCreate(savedInstanceState)

        // XML 레이아웃 리소스에서 활동의 레이아웃을 설정합니다.
        setContentView(R.layout.activity_calender_tab)

        // UI 요소를 ID로 찾아 초기화합니다.
        calendarView = findViewById(R.id.calendarView)
        diaryTextView = findViewById(R.id.diaryTextView)
        saveBtn = findViewById(R.id.saveBtn)
        deleteBtn = findViewById(R.id.deleteBtn)
        updateBtn = findViewById(R.id.updateBtn)
        diaryContent = findViewById(R.id.diaryContent)
        title = findViewById(R.id.title)
        contextEditText = findViewById(R.id.contextEditText)

        // 화면 상단에 표시될 타이틀을 설정합니다.
        title.text = "운동 캘린더"

        // 캘린더 뷰의 날짜 변경 이벤트를 처리합니다.
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // UI 요소의 가시성을 변경합니다.
            diaryTextView.visibility = View.VISIBLE
            saveBtn.visibility = View.VISIBLE
            contextEditText.visibility = View.VISIBLE
            diaryContent.visibility = View.INVISIBLE
            updateBtn.visibility = View.INVISIBLE
            deleteBtn.visibility = View.INVISIBLE

            // 선택된 날짜를 텍스트뷰에 표시합니다.
            diaryTextView.text = String.format("%d / %d / %d", year, month + 1, dayOfMonth)

            // 텍스트 에디트에 초기값을 설정하고 해당 날짜에 대한 내용을 조회합니다.
            contextEditText.setText("운동 종류: \n" +
                    "운동 시간: (분)\n" +
                    "소모한 칼로리: (kcal)\n" +
                    "섭취한 음식: \n" +
                    "섭취한 칼로리: (kcal)\n" +
                    "몸무게: (kg)")
            checkDay(year, month, dayOfMonth, userID)
        }

        // 저장 버튼에 클릭 리스너를 설정하여 다이어리 내용을 저장하고 UI를 업데이트합니다.
        saveBtn.setOnClickListener {
            saveDiary(fname)
            contextEditText.visibility = View.INVISIBLE
            saveBtn.visibility = View.INVISIBLE
            updateBtn.visibility = View.VISIBLE
            deleteBtn.visibility = View.VISIBLE
            str = contextEditText.text.toString()
            diaryContent.text = str
            diaryContent.visibility = View.VISIBLE
        }
    }

    // 달력 내용을 조회하고 수정하는 메서드를 정의합니다.
    fun checkDay(cYear: Int, cMonth: Int, cDay: Int, userID: String) {
        // 저장할 파일 이름을 설정합니다.
        fname = "" + userID + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt"

        var fileInputStream: FileInputStream
        try {
            // 파일에서 데이터를 읽어옵니다.
            fileInputStream = openFileInput(fname)
            val fileData = ByteArray(fileInputStream.available())
            fileInputStream.read(fileData)
            fileInputStream.close()
            str = String(fileData)

            // UI 요소의 가시성을 조절합니다.
            contextEditText.visibility = View.INVISIBLE
            diaryContent.visibility = View.VISIBLE
            diaryContent.text = str
            saveBtn.visibility = View.INVISIBLE
            updateBtn.visibility = View.VISIBLE
            deleteBtn.visibility = View.VISIBLE

            // 수정 버튼 클릭 시 이벤트 처리
            updateBtn.setOnClickListener {
                contextEditText.visibility = View.VISIBLE
                diaryContent.visibility = View.INVISIBLE
                contextEditText.setText(str)
                saveBtn.visibility = View.VISIBLE
                updateBtn.visibility = View.INVISIBLE
                deleteBtn.visibility = View.INVISIBLE
                diaryContent.text = contextEditText.text
            }

            // 삭제 버튼 클릭 시 이벤트 처리
            deleteBtn.setOnClickListener {
                diaryContent.visibility = View.INVISIBLE
                updateBtn.visibility = View.INVISIBLE
                deleteBtn.visibility = View.INVISIBLE
                contextEditText.setText("")
                contextEditText.visibility = View.VISIBLE
                saveBtn.visibility = View.VISIBLE
                removeDiary(fname)
            }

            // 만약 다이어리 내용이 비어있다면 초기화 상태로 변경합니다.
            if (diaryContent.text == null) {
                diaryContent.visibility = View.INVISIBLE
                updateBtn.visibility = View.INVISIBLE
                deleteBtn.visibility = View.INVISIBLE
                diaryTextView.visibility = View.VISIBLE
                saveBtn.visibility = View.VISIBLE
                contextEditText.visibility = View.VISIBLE
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // 달력 내용을 제거하는 메서드를 정의합니다.
    @SuppressLint("WrongConstant")
    fun removeDiary(readDay: String?) {
        var fileOutputStream: FileOutputStream
        try {
            // 파일에 빈 내용을 작성하여 내용을 제거합니다.
            fileOutputStream = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS)
            val content = ""
            fileOutputStream.write(content.toByteArray())
            fileOutputStream.close()
            diaryContent.text = content
            diaryContent.visibility = View.INVISIBLE
            updateBtn.visibility = View.INVISIBLE
            deleteBtn.visibility = View.INVISIBLE
            contextEditText.visibility = View.VISIBLE
            saveBtn.visibility = View.VISIBLE
            diaryTextView.visibility = View.VISIBLE
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }

        // 텍스트 에디트의 초기값을 설정합니다.
        contextEditText.setText("운동 종류: \n" +
                "운동 시간: (분)\n" +
                "소모한 칼로리: (kcal)\n" +
                "섭취한 음식: \n" +
                "섭취한 칼로리: (kcal)\n" +
                "몸무게: (kg)")
    }

    // 달력 내용을 추가하는 메서드를 정의합니다.
    @SuppressLint("WrongConstant")
    fun saveDiary(readDay: String?) {
        var fileOutputStream: FileOutputStream
        try {
            // 파일에 텍스트 에디트의 내용을 작성하여 내용을 저장합니다.
            fileOutputStream = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS)
            val content = contextEditText.text.toString()
            fileOutputStream.write(content.toByteArray())
            fileOutputStream.close()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}
