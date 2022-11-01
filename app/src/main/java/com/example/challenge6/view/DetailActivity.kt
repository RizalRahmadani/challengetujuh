package com.example.challenge6.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.challenge6.R
import com.example.challenge6.databinding.ActivityDetailBinding
import com.example.challenge6.model.ResponseDataCarItem
import com.example.challenge6.viewmodel.ViewModelCar
import dagger.hilt.android.AndroidEntryPoint
import kotlin.properties.Delegates

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailBinding
    lateinit var dataCar : ResponseDataCarItem

    var b:Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        b = intent.extras
        var id = b!!.getInt("detail")
        Log.d("id", id.toString())
        getDetailCar(id)

    }



    fun getDetailCar(id : Int){
        val viewModel = ViewModelProvider(this).get(ViewModelCar::class.java)
        viewModel.callDetailCar(id)
        viewModel.getDetailCar(id).observe(this, Observer {
//            binding.nameCarDetail.setText("Merek : "+ it!!.name)
//            binding.categoryCarDetail.setText("Kategori : "+ it!!.category)
//            binding.priceCarDetail.setText("Harga : "+ it!!.price)
//            Glide.with(this).load(dataCar.image).into(binding.imgCarDetail)

        })

    }
}