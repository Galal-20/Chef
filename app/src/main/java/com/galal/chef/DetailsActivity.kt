package com.galal.chef

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.galal.chef.databinding.ActivityDetailsBinding

@Suppress("DEPRECATION")
class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodName = intent.getStringExtra("MenuItemName")
        val foodImage = intent.getIntExtra("MenuItemImage",0)
        binding.FoodName.text = foodName
        binding.ImageFood.setImageResource(foodImage)

        binding.imageButtonBackD.setOnClickListener { onBackPressed() }

       /* binding.AddToCart.setOnClickListener {
            val bottomSheetDialog = CongratsBottomSheet()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }*/

    }
}