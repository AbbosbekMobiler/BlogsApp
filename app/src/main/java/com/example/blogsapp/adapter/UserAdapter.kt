package com.example.blogsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.blogsapp.R
import com.example.blogsapp.model.UserModel
import kotlinx.android.synthetic.main.user_item_layout.view.*

class UserAdapter(val items : List<UserModel>):RecyclerView.Adapter<UserAdapter.ItemHolder>() {
    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var item = items[position]
        holder.itemView.tvNameUser.text = item.firstName
        Glide.with(holder.itemView.context).load(item.picture).into(holder.itemView.imageUser)
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}