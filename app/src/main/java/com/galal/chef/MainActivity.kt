package com.galal.chef

import android.annotation.SuppressLint
import android.content.Intent
import android.location.Geocoder
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.galal.chef.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import mumayank.com.airlocationlibrary.AirLocation
import java.lang.Exception

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(),AirLocation.Callback {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var location: AirLocation
    lateinit var navController:NavController
    lateinit var bottomNave:BottomNavigationView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        navController = findNavController(R.id.fragmentContainerView)
        bottomNave = findViewById(R.id.navigationBar)
        bottomNave.setupWithNavController(navController)
        getLocation()

        binding.notificationButton.setOnClickListener {
            val bottomSheetDialog = NotificationBottomFragment()
            bottomSheetDialog.show(supportFragmentManager,"TesT")
        }
        /*binding.navigationBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.historyFragment ->{
                    binding.explore.text = "Your Old Order"
                }
            }
            return@setOnItemSelectedListener true
        }*/
        }

    private fun getLocation(){
        location = AirLocation(this,this,false,0,"")
        location.start()
    }

    override fun onSuccess(locations: ArrayList<Location>) {
        try {
            locations[0].accuracy
            val lat = locations[0].latitude
            val long = locations[0].longitude
            val g = Geocoder(this)
            val address = g.getFromLocation(lat,long,2)
            address?.get(0).let {
                binding.location.text = it?.locality
            }
        }catch (e : Exception){
            Snackbar.make(binding.location,"${e.message}", Snackbar.LENGTH_SHORT).show()
        }

    }
    override fun onFailure(locationFailedEnum: AirLocation.LocationFailedEnum) {
        Snackbar.make(binding.location,"The server not response,Try again later", Snackbar.LENGTH_SHORT).show()
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        location.onActivityResult(requestCode, resultCode, data) // ADD THIS LINE INSIDE onActivityResult
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        location.onRequestPermissionsResult(requestCode, permissions, grantResults) // ADD THIS LINE INSIDE onRequestPermissionResult
    }
}