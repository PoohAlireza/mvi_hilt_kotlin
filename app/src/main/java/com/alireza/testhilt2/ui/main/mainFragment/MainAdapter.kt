package com.alireza.testhilt2.ui.main.mainFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.alireza.testhilt2.R
import com.alireza.testhilt2.model.User

class MainAdapter constructor(private var users:List<User> , private val context: Context?) : RecyclerView.Adapter<MainAdapter.ItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler,null))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var user:User = users[position]

        // init
        holder.id.text = user.id.toString()
        holder.name.text = user.name
        holder.username.text = user.username
        holder.phone.text = user.phone
        holder.email.text = user.email
        holder.website.text = user.website
        holder.itemView.setOnClickListener {
            val bundle:Bundle = Bundle()
            bundle.putInt("id",user.id)
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_userFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }


    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id:TextView = itemView.findViewById(R.id.tv_id)
        var name:TextView = itemView.findViewById(R.id.tv_name)
        var username:TextView = itemView.findViewById(R.id.tv_username)
        var phone:TextView = itemView.findViewById(R.id.tv_phone)
        var email:TextView = itemView.findViewById(R.id.tv_email)
        var website:TextView = itemView.findViewById(R.id.tv_website)
    }

}