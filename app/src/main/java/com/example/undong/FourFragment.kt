package com.example.undong

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.undong.databinding.FragmentFourBinding
import com.example.undong.databinding.FragmentThreeBinding


class FourFragment : Fragment() {

    private var _binding: FragmentFourBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFourBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // "팔굽혀펴기1 시작" ImageButton 초기화
        val closegrippushupsButton: Button = binding.closegripushups

        closegrippushupsButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=SwoNNo4W1OU" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val tricepdipsButton: Button = binding.tricepdips

        tricepdipsButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=JhX1nBnirNw" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val updownplankButton: Button = binding.updownplank

        updownplankButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=AAPpXm-q7lc" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val getupsButton: Button = binding.getups

        getupsButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=n47X4HOhfUk" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val punchesButton: Button = binding.punches

        punchesButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=M_4Vt5lfEUE" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val sidechopsButton: Button = binding.sidechops

        sidechopsButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=LkAIHkKXYB4" // 여기에 YouTube 비디오 URL을 추가하세요
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
