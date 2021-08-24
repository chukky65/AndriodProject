package com.chuks.houserental.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chuks.houserental.R
import com.chuks.houserental.databinding.ItemHotBinding
import com.chuks.houserental.databinding.ItemImgBinding
import com.chuks.houserental.model.Data
import com.chuks.houserental.model.User

class Adapter3 (var users:List<Data>, val click:(Data) -> Unit): RecyclerView.Adapter<Adapter3.ViewHolder3>() {

    inner  class ViewHolder3(private val binding: ItemHotBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind ( user: Data){
            binding.apply {
               hotCityTxt.text = user.city
              // hotPropertyPrice.text = user.propertyPrice.toString()
               hotPropertyType.text = user.propertyType

                val domainhost: String = "https://ict-yep.herokuapp.com"
                Glide.with(binding.root)
                    .load(domainhost + user.propertyImages[0])
                    .error(R.drawable.imagetwo)
                    .centerCrop()
                    .into(hotImage)
                root.setOnClickListener { click (user) }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter3.ViewHolder3 {
        val binding= ItemHotBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder3(binding)
    }

    override fun onBindViewHolder(holder: Adapter3.ViewHolder3, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}