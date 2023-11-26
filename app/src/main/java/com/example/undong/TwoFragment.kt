package com.example.undong

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.undong.databinding.FragmentOneBinding
import com.example.undong.databinding.FragmentTwoBinding


class TwoFragment : Fragment() {

    private var _binding: FragmentTwoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // "팔굽혀펴기1 시작" ImageButton 초기화
        val lungeButton: Button = binding.lunges

        lungeButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=UpyDdQjBTa0" // 여기에 YouTube 비디오 URL을 추가하세요
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))
            intent.setPackage("com.google.android.youtube")

            if (intent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(intent)
            } else {
                // YouTube 앱이 설치되어 있지 않을 경우 브라우저로 열기
                intent.setPackage(null)
                startActivity(intent)
            }
        }

        val highkneesButton: Button = binding.highknees

        highkneesButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=DfjpR6dzLVg" // 여기에 YouTube 비디오 URL을 추가하세요
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))
            intent.setPackage("com.google.android.youtube")

            if (intent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(intent)
            } else {
                // YouTube 앱이 설치되어 있지 않을 경우 브라우저로 열기
                intent.setPackage(null)
                startActivity(intent)
            }
        }

        val turningkicksButton: Button = binding.turningkicks

        turningkicksButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=ZqQY9SlJiiQ" // 여기에 YouTube 비디오 URL을 추가하세요
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))
            intent.setPackage("com.google.android.youtube")

            if (intent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(intent)
            } else {
                // YouTube 앱이 설치되어 있지 않을 경우 브라우저로 열기
                intent.setPackage(null)
                startActivity(intent)
            }
        }

        val climbersButton: Button = binding.climbers

        climbersButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=w2iTOneGPdU" // 여기에 YouTube 비디오 URL을 추가하세요
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))
            intent.setPackage("com.google.android.youtube")

            if (intent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(intent)
            } else {
                // YouTube 앱이 설치되어 있지 않을 경우 브라우저로 열기
                intent.setPackage(null)
                startActivity(intent)
            }
        }

        val plankjumpButton: Button = binding.plankjump

        plankjumpButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=b-83f_fZ-H0" // 여기에 YouTube 비디오 URL을 추가하세요
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))
            intent.setPackage("com.google.android.youtube")

            if (intent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(intent)
            } else {
                // YouTube 앱이 설치되어 있지 않을 경우 브라우저로 열기
                intent.setPackage(null)
                startActivity(intent)
            }
        }

        val lungeupButton: Button = binding.lungeup

        lungeupButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=KM6-6xTRpow" // 여기에 YouTube 비디오 URL을 추가하세요
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))
            intent.setPackage("com.google.android.youtube")

            if (intent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(intent)
            } else {
                // YouTube 앱이 설치되어 있지 않을 경우 브라우저로 열기
                intent.setPackage(null)
                startActivity(intent)
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
