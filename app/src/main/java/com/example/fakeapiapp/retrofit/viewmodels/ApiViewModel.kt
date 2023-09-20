package com.example.fakeapiapp.retrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fakeapiapp.retrofit.repository.CommentRepository
import com.example.fakeapiapp.retrofit.repository.PostRepository
import com.example.fakeapiapp.retrofit.repository.TodoRepository
import com.example.fakeapiapp.retrofit.response.CommentList
import com.example.fakeapiapp.retrofit.response.PostList
import com.example.fakeapiapp.retrofit.response.TodoList

class ApiViewModel: ViewModel() {
    val PostRepo= PostRepository()
    val CommentRepo=CommentRepository()
     val TodoRepo=TodoRepository()

    var isLoding:MutableLiveData<Boolean> = PostRepo.isLoding
   var cmtLoding:MutableLiveData<Boolean> = CommentRepo.cmtLoding
   var todoLoding:MutableLiveData<Boolean> = TodoRepo.todoLoding

    fun getPosts():LiveData<PostList>{
        return PostRepo.GetPost()
    }

    fun getComment():LiveData<CommentList>{
        return CommentRepo.GetComment()
    }

    fun getTodo():LiveData<TodoList>{
        return TodoRepo.GetTodo()
    }

}