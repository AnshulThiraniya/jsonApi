package com.example.fakeapiapp.retrofit.methods

import com.example.fakeapiapp.retrofit.response.CommentList
import com.example.fakeapiapp.retrofit.response.PostList
import com.example.fakeapiapp.retrofit.response.TodoList
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndUrls {
    @GET("/posts")
    fun getPosts():Call<PostList>

    @GET("/comments")
    fun getComment():Call<CommentList>

    @GET("/todos")
    fun getTodos():Call<TodoList>

}

