package com.example.blogsapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.blogsapp.api.BaseResponse
import com.example.blogsapp.api.NetworkManager
import com.example.blogsapp.model.PostModel
import com.example.blogsapp.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlogsRepository {
    fun getUsers(error : MutableLiveData<String>,usersData: MutableLiveData<List<UserModel>>){
        NetworkManager.getApiClient().getUser().enqueue(object : Callback<BaseResponse<List<UserModel>>>{
            override fun onResponse(
                call: Call<BaseResponse<List<UserModel>>>,
                response: Response<BaseResponse<List<UserModel>>>
            ) {
                usersData.value = response.body()!!.data
            }

            override fun onFailure(call: Call<BaseResponse<List<UserModel>>>, t: Throwable) {
                error.value = t.localizedMessage
            }
        })
    }

    fun getPost(error : MutableLiveData<String>,postsData: MutableLiveData<List<PostModel>>){
        NetworkManager.getApiClient().getPost().enqueue(object : Callback<BaseResponse<List<PostModel>>>{
            override fun onResponse(
                call: Call<BaseResponse<List<PostModel>>>,
                response: Response<BaseResponse<List<PostModel>>>
            ) {
                postsData.value = response.body()!!.data
            }

            override fun onFailure(call: Call<BaseResponse<List<PostModel>>>, t: Throwable) {
                error.value = t.localizedMessage
            }
        })
    }
}