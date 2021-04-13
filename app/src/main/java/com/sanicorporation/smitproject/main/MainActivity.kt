package com.sanicorporation.smitproject.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.sanicorporation.smitproject.R
import com.sanicorporation.smitproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setUpBinding()
    }

    private fun setUpBinding() {
        binding.viewmodel = viewModel
    }
}