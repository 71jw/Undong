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


class OneFragment : Fragment() {

    private var _binding: FragmentOneBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // "팔굽혀펴기1 시작" ImageButton 초기화
        val situpsButton: Button = binding.situps

        situpsButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=5bOjqyL0PGE" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val reverseButton: Button = binding.reversecrunches

        reverseButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=QYNZwyDKmhk" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val bicycleButton: Button = binding.bicycle

        bicycleButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=wDbRpbJyMu8" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val flutterButton: Button = binding.flutter

        flutterButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=WRnq49TAv-w" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val legraisesButton: Button = binding.legraises

        legraisesButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=_OQaO65Vdzs" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val elbowButton: Button = binding.elbowplank

        elbowButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=t3elxPJ1HU4" // 여기에 YouTube 비디오 URL을 추가하세요
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
