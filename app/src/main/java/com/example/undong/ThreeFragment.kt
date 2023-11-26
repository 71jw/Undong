package com.example.undong

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.undong.databinding.FragmentThreeBinding


class ThreeFragment : Fragment() {

    private var _binding: FragmentThreeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // "팔굽혀펴기1 시작" ImageButton 초기화
        val squatsButton: Button = binding.squats

        squatsButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=Zqc_lc93hak" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val donkeykicksButton: Button = binding.donkeykicks

        donkeykicksButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=QGiiuBOQn3Y" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val sidelegraisesButton: Button = binding.sidelegraises

        sidelegraisesButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=H8RrfDOLiZU" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val bridgesButton: Button = binding.bridges

        bridgesButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=N48d7sm8dbU" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val jumpkneetucksButton: Button = binding.jumpkneetucks

        jumpkneetucksButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=ArZXCfbjxWs" // 여기에 YouTube 비디오 URL을 추가하세요
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

        val flystepsButton: Button = binding.flysteps

        flystepsButton.setOnClickListener {
            val youtubeUrl = "https://www.youtube.com/watch?v=pHPNrrcMobE" // 여기에 YouTube 비디오 URL을 추가하세요
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
