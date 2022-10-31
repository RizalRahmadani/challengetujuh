package com.example.challenge6.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge6.R
import com.example.challenge6.databinding.ActivityMainBinding
import com.example.challenge6.viewmodel.ViewModelCar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var  binding : ActivityMainBinding
    lateinit var carAdapter : CarAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVmtoAdapter()
    }

    fun setVmtoAdapter(){
        val viewModel = ViewModelProvider(this).get(ViewModelCar::class.java)
        viewModel.callApiCar()
        viewModel.getliveDataCar().observe(this, Observer {
            carAdapter = CarAdapter(it)
            if ( it != null){
                binding.rvCar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvCar.adapter = CarAdapter(it)

            }

        })
    }
}