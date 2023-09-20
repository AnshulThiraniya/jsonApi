package com.example.fakeapiapp.retrofit.repository

import androidx.lifecycle.MutableLiveData
import com.example.fakeapiapp.retrofit.network.Retrofit
import com.example.fakeapiapp.retrofit.response.CommentList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentRepository {
    val userliveComment: MutableLiveData<CommentList> = MutableLiveData<CommentList>()
    var cmtLoding: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply {
        value=true
    }

    fun GetComment(): MutableLiveData<CommentList> {
        val call= Retrofit.Apicall.getComment()
        call.enqueue(object : Callback<CommentList> {
            override fun onResponse(call: Call<CommentList>, response: Response<CommentList>) {
                if(response.isSuccessful){
                    cmtLoding.value=false
                    userliveComment.value=response.body()
                }
            }

            override fun onFailure(call: Call<CommentList>, t: Throwable) {
                cmtLoding.value=false
            }

        })

        return userliveComment
    }
}