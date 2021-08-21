package com.isaac.houserentalapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chuks.houserental.R
import com.chuks.houserental.databinding.ItemListBinding
import com.chuks.houserental.model.User


class Myadapter2(var users:List<User>, val click:(User) -> Unit):
    RecyclerView.Adapter<Myadapter2.MyViewHolder2>() {

   inner  class MyViewHolder2(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind ( user: User){
            binding.apply {
                listBuildingName.text = user.username
                //email.text = user.email

                Glide.with(binding.root)
                    //.load("https://www.picsum.photos/200/300")
                    .load(R.drawable.house)
                    .centerCrop()
                    .into(RecommendedImage)
                root.setOnClickListener { click(user) }


            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter2.MyViewHolder2 {
        val binding= ItemListBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder2(binding)
    }

    override fun onBindViewHolder(holder: Myadapter2.MyViewHolder2, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}
