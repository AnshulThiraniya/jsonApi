package com.example.fakeapiapp.retrofit.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapiapp.databinding.ActivityCommentListBinding
import com.example.fakeapiapp.retrofit.response.CommentList

class CommentAdapter (val context: Context, val list: CommentList):
    RecyclerView.Adapter<CommentAdapter.MyviewHolder>() {

    inner class MyviewHolder(var binding: ActivityCommentListBinding): RecyclerView.ViewHolder(binding.root){

    }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        var view= ActivityCommentListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyviewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        var product=list[position]
        holder.binding.cmtName.text="Name:-   ${product.name}"
        holder.binding.cmtEmail.text="Email:-  ${product.email}"
        holder.binding.cmtBody.text="Body:-   ${product.body}"


    }
}