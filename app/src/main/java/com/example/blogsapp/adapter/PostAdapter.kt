package com.example.blogsapp.adapter

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.blogsapp.R
import com.example.blogsapp.model.PostModel
import kotlinx.android.synthetic.main.post_item_layout.view.*
import java.time.format.DateTimeFormatterBuilder

class PostAdapter(val items : List<PostModel>):RecyclerView.Adapter<PostAdapter.ItemHolder>() {
    inner class ItemHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.post_item_layout,parent,false))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: PostAdapter.ItemHolder, position: Int) {
        var item = items[position]
        holder.itemView.postTitle.text = item.text
        Glide.with(holder.itemView.context).load(item.image).into(holder.itemView.postImage)
        holder.itemView.postDate.text = item.publishDate
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}