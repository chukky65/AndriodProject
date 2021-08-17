package com.chuks.houserental.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.chuks.houserental.MainActivity
import com.chuks.houserental.R

class Splashscreen : AppCompatActivity() {

    val SPLASH_SCREEN = 5000

    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation

    private lateinit var imageView : ImageView
    private lateinit var titletxt : TextView
    private lateinit var descriptiontxt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splashscreen)



        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        imageView = findViewById(R.id.hr_dshr)
        titletxt = findViewById(R.id.title_text)
        descriptiontxt = findViewById(R.id.text_vieww)

        imageView.animation = topAnimation
        titletxt.animation = bottomAnimation
        descriptiontxt.animation = bottomAnimation

        Handler((Looper.getMainLooper())).postDelayed({

            val intent = Intent(this, MainActivity :: class.java)
            startActivity(intent)
            finish()


        }, 3000)

    }
}