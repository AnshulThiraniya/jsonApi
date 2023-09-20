package com.example.fakeapiapp.retrofit.repository

import androidx.lifecycle.MutableLiveData
import com.example.fakeapiapp.retrofit.network.Retrofit
import com.example.fakeapiapp.retrofit.response.PostList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository {
    val userliveProduct:MutableLiveData<PostList> = MutableLiveData<PostList>()
    var isLoding:MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply {
        value=true
    }

    fun GetPost():MutableLiveData<PostList>{
        val call= Retrofit.Apicall.getPosts()
        call.enqueue(object :Callback<PostList>{
            override fun onResponse(call: Call<PostList>, response: Response<PostList>) {
              if(response.isSuccessful){
                  isLoding.value=false
                  userliveProduct.value=response.body()
              }
            }

            override fun onFailure(call: Call<PostList>, t: Throwable) {
                 isLoding.value=false
            }

        })

        return userliveProduct
    }
}