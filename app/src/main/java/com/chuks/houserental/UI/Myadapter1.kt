package com.chuks.houserental.UI

import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chuks.houserental.R
import com.chuks.houserental.databinding.ItemImgBinding
import com.chuks.houserental.model.User


class Myadapter1(var users:List<User>, val click:(User) -> Unit):RecyclerView.Adapter<Myadapter1.MyViewHolder1>() {

   inner  class MyViewHolder1(private val binding: ItemImgBinding) :
        RecyclerView.ViewHolder(binding.root){
    fun bind ( user: User){
    binding.apply {
        //propertyOneName.text = user.username
        //description.text = user.email

       Glide.with(binding.root)
            //.load("https://www.picsum.photos/200/300")
           .load(R.drawable.imageone)
            .centerCrop()
            .into(NearImage)
        root.setOnClickListener { click (user) }
    }
    }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter1.MyViewHolder1 {
        val binding= ItemImgBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder1(binding)
    }

    override fun onBindViewHolder(holder: Myadapter1.MyViewHolder1, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
    return users.size
    }
}