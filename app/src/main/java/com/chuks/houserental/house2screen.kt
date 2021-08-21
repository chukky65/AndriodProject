package com.chuks.houserental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chuks.houserental.databinding.ActivityHouse2screenBinding

class house2screen : AppCompatActivity() {
    lateinit var binding: ActivityHouse2screenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHouse2screenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCall.setOnClickListener {
            makeCall()
        }
        binding.btnArrow.setOnClickListener {
            back()
        }
        supportActionBar!!.title = "View Property"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
        fun makeCall() {
            val intent: Intent = Intent(Intent.ACTION_DIAL)
            startActivity(intent)
        }
    fun back() {
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    }
