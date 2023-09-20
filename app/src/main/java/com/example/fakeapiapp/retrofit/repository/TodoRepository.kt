package com.example.fakeapiapp.retrofit.repository

import androidx.lifecycle.MutableLiveData
import com.example.fakeapiapp.retrofit.network.Retrofit
import com.example.fakeapiapp.retrofit.response.TodoList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoRepository {
    val userliveTodo: MutableLiveData<TodoList> = MutableLiveData<TodoList>()
    var todoLoding: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply {
        value=true
    }

    fun GetTodo(): MutableLiveData<TodoList> {
        val call= Retrofit.Apicall.getTodos()
        call.enqueue(object : Callback<TodoList> {
            override fun onResponse(call: Call<TodoList>, response: Response<TodoList>) {
                if(response.isSuccessful){
                    todoLoding.value=false
                    userliveTodo.value=response.body()
                }
            }

            override fun onFailure(call: Call<TodoList>, t: Throwable) {
                todoLoding.value=false
            }

        })

        return userliveTodo
    }
}