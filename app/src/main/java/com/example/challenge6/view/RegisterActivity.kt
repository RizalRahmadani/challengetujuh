package com.example.challenge6.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challenge6.R
import com.example.challenge6.databinding.ActivityRegisterBinding
import com.example.challenge6.datastore.LoginDataStore
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    lateinit var binding : ActivityRegisterBinding
    lateinit var dataLogin :LoginDataStore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataLogin = LoginDataStore(this)


        binding.btnRegister.setOnClickListener {
            var saveUser = binding.etUsername.text.toString()
            var saveEmail = binding.etEmail.text.toString()
            var savePw = binding.etPassword.text.toString()
            var getUpw = binding.etKonfirmasiPass.text.toString()
            GlobalScope.launch {
                dataLogin.saveData(saveUser,savePw,saveEmail)
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            }
        }


    }
}