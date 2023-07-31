package com.galal.chef

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.galal.chef.databinding.ActivitySignBinding

class SignActivity : AppCompatActivity() {
    private val binding: ActivitySignBinding by lazy {
        ActivitySignBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textView10.setOnClickListener {
            Intent(this,LoginActivity::class.java).also { startActivity(it) }
        }

        binding.loginButton.setOnClickListener {
            Intent(this,MainActivity::class.java).also { startActivity(it) }
        }
    }
}