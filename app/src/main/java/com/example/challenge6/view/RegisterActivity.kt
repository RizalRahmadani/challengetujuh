package com.example.challenge6.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.challenge6.R
import com.example.challenge6.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var auth : FirebaseAuth
    lateinit var binding  : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.tvToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener{
            val email = binding.edtEmailRegister.text.toString()
            val password = binding.edtPasswordRegister.text.toString()

            //validasi email
            if(email.isEmpty()){
                binding.edtEmailRegister.error = "Email Harus Diisi"
                binding.edtEmailRegister.requestFocus()
                return@setOnClickListener
            }
            //validasi email tidak sesuai
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.edtEmailRegister.error = "Email Tidak Valid"
                binding.edtEmailRegister.requestFocus()
                return@setOnClickListener
            }

            //validasi password
            if(email.isEmpty()){
                binding.edtPasswordRegister.error = "Password Harus Diisi"
                binding.edtPasswordRegister.requestFocus()
                return@setOnClickListener
            }
            //validasi panjang password
            if(password.length < 6){
                binding.edtPasswordRegister.error = "Password Minimal 6 Karakter"
                binding.edtPasswordRegister.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(email,password)
        }
    }

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}