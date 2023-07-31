package com.galal.chef

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.galal.chef.databinding.ActivitySplashScreenBinding

@Suppress("DEPRECATION")
class Splash_Screen : AppCompatActivity() {
    private val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this, StartActivity::class.java).also { startActivity(it) }
            finish()
        },4000)
        yoyo()
    }

    private fun yoyo(){
        YoYo.with(Techniques.FadeInUp).duration(3000).playOn(binding.imageView)
        YoYo.with(Techniques.FadeInUp).duration(3000).playOn(binding.textView)
        YoYo.with(Techniques.FadeInUp).duration(3000).playOn(binding.textView2)
    }
}