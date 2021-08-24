package com.chuks.houserental.UI

import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chuks.houserental.R
import com.chuks.houserental.databinding.ItemImgBinding
import com.chuks.houserental.model.Data
import com.chuks.houserental.model.User


class Myadapter1(var users: List<Data>, val click: (Data) -> Unit) :
    RecyclerView.Adapter<Myadapter1.MyViewHolder1>() {

    inner class MyViewHolder1(private val binding: ItemImgBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Data) {
            binding.apply {
                NearPropertyType.text = user.propertyType
                NearCityTxt.text = user.city
               // NearPropertyPrice.text = user.propertyPrice.toString()
                val domainhost: String = "https://ict-yep.herokuapp.com"
                Glide.with(binding.root)
                    .load(domainhost + user.propertyImages[0])
                    .centerCrop()
                    .error(R.drawable.house)
                    .into(NearImage)
                root.setOnClickListener { click(user) }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter1.MyViewHolder1 {
        val binding = ItemImgBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder1(binding)
    }

    override fun onBindViewHolder(holder: Myadapter1.MyViewHolder1, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}