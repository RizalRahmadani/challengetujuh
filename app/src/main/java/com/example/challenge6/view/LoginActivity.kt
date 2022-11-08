package com.example.challenge6.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.asLiveData
import com.example.challenge6.R
//import com.example.challenge6.databinding.ActivityLoginBinding
import com.example.challenge6.databinding.ActivityLoginBinding
//import com.example.challenge6.datastore.LoginDataStore
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        binding.tvToRegister.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener{
            val email = binding.edtEmailLogin.text.toString()
            val password = binding.edtPasswordLogin.text.toString()

            //validasi email
            if(email.isEmpty()){
                binding.edtEmailLogin.error = "Email Harus Diisi"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }
            //validasi email tidak sesuai
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.edtEmailLogin.error = "Email Tidak Valid"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }

            //validasi password
            if(email.isEmpty()){
                binding.edtPasswordLogin.error = "Password Harus Diisi"
                binding.edtPasswordLogin.requestFocus()
                return@setOnClickListener
            }


            LoginFirebase(email,password)
        }
    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this, "Selamat datang $email", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Maaf Password dan Email Anda Salah", Toast.LENGTH_SHORT).show()
                }
            }

    }
}