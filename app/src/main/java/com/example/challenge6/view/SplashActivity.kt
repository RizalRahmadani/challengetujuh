package com.example.challenge6.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.asLiveData
import com.example.challenge6.R
import com.example.challenge6.databinding.ActivitySplashBinding
import com.example.challenge6.datastore.LoginDataStore

class SplashActivity : AppCompatActivity() {

    lateinit var binding : ActivitySplashBinding
    lateinit var dataLogin : LoginDataStore
    lateinit var usernama : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataLogin = LoginDataStore(this)
        dataLogin.userName.asLiveData().observe(this,{
            usernama = it.toString()
        })

        Handler().postDelayed({
            if (usernama.isNullOrEmpty()){
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }


        },3000)




    }
}