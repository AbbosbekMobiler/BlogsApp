package com.example.blogsapp.model


import com.google.gson.annotations.SerializedName

data class UserModel(

    val firstName: String,
    val id: String,
    val lastName: String,
    val picture: String,
    val title: String
)