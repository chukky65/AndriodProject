package com.chuks.houserental.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chuks.houserental.R
import com.chuks.houserental.databinding.ItemHotBinding
import com.chuks.houserental.databinding.ItemImgBinding
import com.chuks.houserental.model.User

class Adapter3 (var users:List<User>, val click:(User) -> Unit): RecyclerView.Adapter<Adapter3.ViewHolder3>() {

    inner  class ViewHolder3(private val binding: ItemHotBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind ( user: User){
            binding.apply {
   /**             hotCityTxt.text = user.property.city
               hotPropertyPrice.text = user.property.propertyPrice
               hotPropertyType.text = user.property.propertyType     **/

                Glide.with(binding.root)
                    .load(R.drawable.imagetwo)
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