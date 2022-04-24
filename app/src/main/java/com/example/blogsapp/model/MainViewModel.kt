package com.example.blogsapp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.blogsapp.repository.BlogsRepository

class MainViewModel : ViewModel() {
    val repository  = BlogsRepository()
    val error = MutableLiveData<String>()
    val usersData = MutableLiveData<List<UserModel>>()
    val postsData = MutableLiveData<List<PostModel>>()

    fun getUsers(){
        repository.getUsers(error,usersData)
    }

    fun getPosts(){
        repository.getPost(error,postsData)
    }
}