package com.example.undong

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.ViewGroup
import com.example.undong.databinding.ActivityMainBinding
import net.daum.mf.map.api.MapView
import java.security.MessageDigest

class Map : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_map)

        val clKakaoMapView = findViewById<ViewGroup>(R.id.clKakaoMapView)
        val mapView = MapView(this)
        clKakaoMapView.addView(mapView)


    }

}