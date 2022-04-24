package com.example.blogsapp.api

import com.example.blogsapp.model.PostModel
import com.example.blogsapp.model.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface Api {
    @Headers("app-id:6264eb16984f9a46f862fabb")
    @GET("user")
    fun getUser() : Call<BaseResponse<List<UserModel>>>

    @Headers("app-id:6264eb16984f9a46f862fabb")
    @GET("post")
    fun getPost() : Call<BaseResponse<List<PostModel>>>
}