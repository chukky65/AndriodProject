package com.chuks.houserental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chuks.houserental.UI.Adapter3
import com.chuks.houserental.UI.Myadapter1
import com.chuks.houserental.databinding.ActivityMainBinding
import com.isaac.houserentalapp.ui.MainViewModel
import com.isaac.houserentalapp.ui.Myadapter2
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var myadapter1: Myadapter1
    private lateinit var myadapter2: Myadapter2
    private lateinit var adapter3: Adapter3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Date and time
        val textView:TextView = binding.dateAndTime
        val simpleDateFormat =SimpleDateFormat("yyyy.MM.dd 'at' HH.mm.ss")
        val currentDateAndTime:String=simpleDateFormat.format(Date())
        textView.text = currentDateAndTime

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]


        myadapter1 = Myadapter1(listOf()) {
            val intent = Intent(this@MainActivity, House2screen::class.java)

         //   intent.putExtra("NearImage", it.propertyImages)
            intent.putExtra("description", it.propertyDescription)
            intent.putExtra("type", it.propertyType)
            intent.putExtra("location", it.city)
            intent.putExtra("price", it.propertyPrice.toString())
            intent.putExtra("rooms", it.numberOfRooms.toString())
            intent.putExtra("title", it.title)
            startActivity(intent)
        }
        binding.rvGrid.apply {
            adapter = myadapter1
            viewModel = ViewModelProvider(this@MainActivity)[MainViewModel::class.java]
        }

            adapter3 = Adapter3(listOf()) {
                val intent = Intent(this@MainActivity, House2screen::class.java)
                //   intent.putExtra("NearImage", it.propertyImages)
                intent.putExtra("description", it.propertyDescription)
                intent.putExtra("type", it.propertyType)
                intent.putExtra("location", it.city)
                intent.putExtra("price", it.propertyPrice.toString())
                intent.putExtra("rooms", it.numberOfRooms.toString())
                intent.putExtra("title", it.title)
                startActivity(intent)

            }
            binding.rvHot.apply {
                adapter = adapter3
                viewModel = ViewModelProvider(this@MainActivity)[MainViewModel::class.java]
            }

        myadapter2 = Myadapter2(listOf()) {
            val intent = Intent(this@MainActivity, House2screen::class.java)
            //   intent.putExtra("NearImage", it.propertyImages)
            intent.putExtra("description", it.propertyDescription)
            intent.putExtra("type", it.propertyType)
            intent.putExtra("location", it.city)
            intent.putExtra("price", it.propertyPrice.toString())
            intent.putExtra("rooms", it.numberOfRooms.toString())
            intent.putExtra("title", it.title)
            startActivity(intent)

        }
        binding.rvGrid2.apply {
            adapter = myadapter2
            viewModel = ViewModelProvider(this@MainActivity)[MainViewModel::class.java]
        }

            viewModel.run {
                getUsers()
                userLiveData.observe(this@MainActivity, { users ->

                    myadapter1.users = users
                    myadapter1.notifyDataSetChanged()

                    myadapter2.users = users
                    myadapter2.notifyDataSetChanged()

                    adapter3.users = users
                    adapter3.notifyDataSetChanged()
                })
            }
        }
    }









