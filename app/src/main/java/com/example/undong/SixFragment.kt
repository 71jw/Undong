package com.example.undong

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.undong.databinding.FragmentSixBinding



class SixFragment : Fragment() {

    private var _binding: FragmentSixBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSixBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // "팔굽혀펴기1 시작" ImageButton 초기화
        val pullupButton: Button = binding.pullup

        pullupButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=eGo4IYlbE5g" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val supermanButton: Button = binding.superman

        supermanButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=67rgxYNKbZY" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val bearwalkButton: Button = binding.bearwalk

        bearwalkButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=bfT5TaRFKQw" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val birddogButton: Button = binding.birddog

        birddogButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=RY98u-mgJoc" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val crabkicksButton: Button = binding.crabkicks

        crabkicksButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=d_57140plEE" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val bentoverrowButton: Button = binding.bentoverrow

        bentoverrowButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/shorts/dD-jK2l_zQE" // 여기에 YouTube 비디오 URL을 추가하세요
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
