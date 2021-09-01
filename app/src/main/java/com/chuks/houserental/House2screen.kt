package com.chuks.houserental

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
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
            val images = intent.getStringArrayExtra("images")
            Glide.with(root).load(images?.get(0)).error(R.drawable.imagwthree).into(imageView20)
            Glide.with(root).load(images?.get(1)).error(R.drawable.imagwthree).into(imageView16)
            Glide.with(root).load(images?.get(2)).error(R.drawable.imagwthree).into(imageView17)
            Glide.with(root).load(images?.get(3)).error(R.drawable.imagwthree).into(imageView18)
            textView8.text = intent.getStringExtra("description")
            propertyOneName.text = intent.getStringExtra("type")
            city.text = intent.getStringExtra("location")
            bedroom.text = intent.getStringExtra("rooms").toString()
            propertyPrice.text = intent.getStringExtra("price").toString()
            textView11.text = intent.getStringExtra("title")
        }

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
        binding.callbtn2.setOnClickListener {
            whatsapp()
        }
        binding.textView13.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfnBnINbZKqu_-ZfH0toRDh19-nCz_P8DgNEwEpc2u8K3qZ6g/viewform?vc=0&c=0&w=1&flr=0"))
       startActivity(i)
        }
        binding.feedback.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfnBnINbZKqu_-ZfH0toRDh19-nCz_P8DgNEwEpc2u8K3qZ6g/viewform?vc=0&c=0&w=1&flr=0"))
            startActivity(i)
        }
        binding.feedback2.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfnBnINbZKqu_-ZfH0toRDh19-nCz_P8DgNEwEpc2u8K3qZ6g/viewform?vc=0&c=0&w=1&flr=0"))
            startActivity(i)
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
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
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
    private fun whatsapp() {
        val intent: Intent = Intent(Intent.ACTION_SEND, Uri.fromParts("tel",mobile,null))
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Select App"))
        }
    }


