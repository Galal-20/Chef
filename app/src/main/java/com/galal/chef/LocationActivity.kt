package com.galal.chef

import android.content.Intent
import android.location.Geocoder
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.Debug.getLocation
import com.galal.chef.databinding.ActivityLocationBinding
import com.google.android.material.snackbar.Snackbar
import mumayank.com.airlocationlibrary.AirLocation

class LocationActivity : AppCompatActivity() {
    private val binding: ActivityLocationBinding by lazy {
        ActivityLocationBinding.inflate(layoutInflater)
    }
    private lateinit var location: AirLocation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}