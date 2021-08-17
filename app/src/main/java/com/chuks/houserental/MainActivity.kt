package com.chuks.houserental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.Animation
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.chuks.houserental.UI.Image
import com.chuks.houserental.UI.Myadapter1
import com.chuks.houserental.databinding.ActivityMainBinding
import com.chuks.houserental.databinding.ItemListBinding
import com.isaac.houserentalapp.ui.MainViewModel
import com.isaac.houserentalapp.ui.Myadapter2

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var myadapter1: Myadapter1
    private lateinit var myadapter2: Myadapter2



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]


        myadapter1 = Myadapter1(listOf()){
            val intent = Intent(this@MainActivity, house2screen::class.java)
            startActivity(intent) }
        binding.rvGrid.apply {
            adapter = myadapter1




            viewModel = ViewModelProvider(this@MainActivity)[MainViewModel::class.java]

            myadapter2 = Myadapter2(listOf()){
                val intent = Intent(this@MainActivity, house2screen::class.java)
                startActivity(intent)
            }
            binding.rvGrid2.apply {
                adapter = myadapter2
                layoutManager = LinearLayoutManager(this@MainActivity)

            }
        }
        viewModel.run {
            getUsers()
            userLiveData.observe(this@MainActivity, { users ->

                myadapter1.users = users
                myadapter1.notifyDataSetChanged()

                myadapter2.users = users
                myadapter2.notifyDataSetChanged()
            })
        }
    }}



       // binding.btnAgent.setOnClickListener {
      //      HomePage()
      //  }
 //   }

     //   private fun HomePage() {
       //     val home: Intent = Intent(this, house2screen::class.java)
         //   startActivity(home)
       // }





