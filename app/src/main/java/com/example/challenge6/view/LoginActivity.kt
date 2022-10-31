package com.example.challenge6.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.asLiveData
import com.example.challenge6.R
import com.example.challenge6.databinding.ActivityLoginBinding
import com.example.challenge6.datastore.LoginDataStore

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    lateinit var dataLogin : LoginDataStore
    lateinit var useremail : String
    lateinit var userpw : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataLogin = LoginDataStore(this)
        dataLogin.userEmail.asLiveData().observe(this,{
            useremail = it.toString()
        })
        dataLogin.userPw.asLiveData().observe(this,{
            userpw = it.toString()
        })


        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
//            if(email.isEmpty()){
//                Toast.makeText(this,"ISI PASSWORD DAN USERNAME ANDA", Toast.LENGTH_SHORT).show()
//            }else if (password.isEmpty()){
//                Toast.makeText(this,"ISI PASSWORD DAN USERNAME ANDA", Toast.LENGTH_SHORT).show()
//            }else if (email == useremail){
//                startActivity(Intent(this, MainActivity::class.java))
//                finish()
//            }else if (password != userpw){
//                Toast.makeText(this,"ISI PASSWORD DAN USERNAME ANDA", Toast.LENGTH_SHORT).show()
//            }
            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"ISI PASSWORD DAN USERNAME ANDA", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }else if (email == useremail && password == userpw){
                startActivity(Intent(this,MainActivity::class.java))
                Toast.makeText(this,"Anda Berhasil Login", Toast.LENGTH_SHORT).show()

            }else if (email != useremail || password != userpw){
                Toast.makeText(this,"USERNAME DAN PASSWORD ANDA SALAH", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }



        }
        binding.tvRegis.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}