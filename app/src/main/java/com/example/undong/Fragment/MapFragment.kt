package com.example.undong.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.undong.R
import com.example.undong.databinding.FragmentHomeBinding
import com.example.undong.databinding.FragmentMapBinding

class MapFragment : Fragment() {
    // viewBinding을 사용하기 위한 뷰 바인댕 객체 선언
    private var mBinding: FragmentMapBinding?= null
    private val binding get() = mBinding!!

    //fragment가 화면에 나타날때 호출되는 메서드
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //뷰 바인딩을 사용하여 프래그먼트의 ui를 초기화
        mBinding = FragmentMapBinding.inflate(layoutInflater, container, false)
        // 프래그먼트의 루트뷰를 반환하여 화면에 표시
        return binding.root
    }
    // Fragment가 화면에서 사라질 때 호출되는 메서드
    override fun onDestroyView() {
        //뷰 바인딩 객체를 해제하여 메모리 누수를 방지
        mBinding = null
        super.onDestroyView()
    }

}