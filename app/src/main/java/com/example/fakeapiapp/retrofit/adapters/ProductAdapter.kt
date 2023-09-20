package com.example.fakeapiapp.retrofit.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapiapp.databinding.ActivityPostsListBinding
import com.example.fakeapiapp.retrofit.response.PostList

class ProductAdapter(val context: Context,val list: PostList):
    RecyclerView.Adapter<ProductAdapter.MyviewHolder>() {

    inner class MyviewHolder(var binding:ActivityPostsListBinding):RecyclerView.ViewHolder(binding.root){

    }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
     var view=ActivityPostsListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyviewHolder(view)
    }

    override fun getItemCount(): Int {
      return list.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
       var product=list[position]
        holder.binding.productId.text ="Id:- ${product.id.toString()}"
        holder.binding.productTitle.text="Title:- ${product.titile}"
        holder.binding.productBody.text="Body:- ${product.body}"
    }
}