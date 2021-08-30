package com.chuks.houserental

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.chuks.houserental.databinding.ActivityHouse2ScreenBinding


class House2screen : AppCompatActivity() {
    lateinit var binding: ActivityHouse2ScreenBinding
    val mobile: String="07068929914"
    val REQUEST_PHONE_CALL=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHouse2ScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // text scroll
        val text: String = "Everyone desires to own their own home, but the actual purchase" +
                " is usually reserved for those with work ethic, who are brave and committed"
        val textView: TextView=binding.scroll
        textView.text = text
        textView.isSelected = true

        binding.apply {
            textView8.text = intent.getStringExtra("description")
            propertyOneName.text = intent.getStringExtra("type")
            city.text = intent.getStringExtra("location")
            bedroom.text = intent.getStringExtra("rooms").toString()
            propertyPrice.text = intent.getStringExtra("price").toString()
            textView11.text = intent.getStringExtra("title")
        }
        // adapter 3

        // adapter 2

            binding.callbtn.setOnClickListener {
                if (ActivityCompat.checkSelfPermission
                        (this,android.Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),REQUEST_PHONE_CALL)
                }
                else
                {
                    makeCall()
                }
            }
            // binding.arrow.setOnClickListener {
            //  back()
            //  }
            setSupportActionBar(binding.myToolbar)
            supportActionBar!!.title = "View Property"
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
          fun makeCall() {
           val intent: Intent = Intent(Intent.ACTION_CALL, Uri.fromParts("tel",mobile,null))
           startActivity(intent)
         }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
       if (requestCode==REQUEST_PHONE_CALL)
       {
           makeCall()
       }
    }

    fun back() {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
