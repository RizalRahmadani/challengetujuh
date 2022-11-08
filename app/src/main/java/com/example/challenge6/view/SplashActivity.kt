package com.example.challenge6.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.asLiveData
import com.example.challenge6.R
import com.example.challenge6.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    lateinit var binding : ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
        },3000)




    }
}