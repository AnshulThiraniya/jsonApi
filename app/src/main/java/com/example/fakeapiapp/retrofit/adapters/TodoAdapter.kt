package com.example.fakeapiapp.retrofit.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapiapp.databinding.ActivityTodosListBinding
import com.example.fakeapiapp.retrofit.response.TodoList

class TodoAdapter(val context: Context, val list: TodoList):
    RecyclerView.Adapter<TodoAdapter.MyviewHolder>() {

    inner class MyviewHolder(var binding: ActivityTodosListBinding): RecyclerView.ViewHolder(binding.root){
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        var view= ActivityTodosListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyviewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        var product=list[position]
        holder.binding.todoId.text="Id:-  ${product.id}"
        holder.binding.todoTitle.text="Title:-  ${product.titile}"
        holder.binding.todoStatus.text="Status:-  ${product.status}"

    }
}