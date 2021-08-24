package com.chuks.houserental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chuks.houserental.databinding.ActivityHouse2screenBinding
import com.chuks.houserental.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.regbutton.setOnClickListener {
            register()
        }
        binding.regtext11.setOnClickListener {
            login()
        }
    }
        fun register() {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    fun login() {
        val intent: Intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
    }
