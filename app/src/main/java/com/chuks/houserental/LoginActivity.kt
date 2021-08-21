package com.chuks.houserental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chuks.houserental.databinding.ActivityLoginBinding
import com.chuks.houserental.databinding.ActivityRegisterBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginbutton2.setOnClickListener {
            login()
            binding.logintext13.setOnClickListener{
                signup()
            }
        }
    }
    fun login() {
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    fun signup() {
        val intent: Intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}