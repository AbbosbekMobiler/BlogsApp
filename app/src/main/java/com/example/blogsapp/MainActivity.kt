package com.example.blogsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blogsapp.adapter.PostAdapter
import com.example.blogsapp.adapter.UserAdapter
import com.example.blogsapp.model.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerUser.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.error.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
        viewModel.usersData.observe(this, Observer {
            recyclerUser.adapter = UserAdapter(it)
        })

        recyclerPost.layoutManager = LinearLayoutManager(this)
        viewModel.error.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
        viewModel.postsData.observe(this, Observer {
            recyclerPost.adapter = PostAdapter(it)
        })

        loadData()
    }
    fun loadData(){
        viewModel.getUsers()
        viewModel.getPosts()
    }
}

