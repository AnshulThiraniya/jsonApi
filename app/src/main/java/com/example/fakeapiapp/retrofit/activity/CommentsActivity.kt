package com.example.fakeapiapp.retrofit.activity

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakeapiapp.R
import com.example.fakeapiapp.databinding.ActivityCommentBinding
import com.example.fakeapiapp.retrofit.adapters.CommentAdapter
import com.example.fakeapiapp.retrofit.viewmodels.ApiViewModel

class CommentsActivity : AppCompatActivity() {

    lateinit var binding: ActivityCommentBinding
    lateinit var viewModel: ApiViewModel
    lateinit var myAdapter: CommentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle("Comments")
        binding= DataBindingUtil.setContentView(this, R.layout.activity_comment)

        viewModel= ViewModelProvider(this)[ApiViewModel::class.java]

        var progressDialog= ProgressDialog(this)
        progressDialog.setMessage("loading please wait...")
        progressDialog.setCancelable(false)

        viewModel.cmtLoding.observe(this, Observer {
            if(it){
                progressDialog.show()
            }
            else{
                progressDialog.dismiss()
            }
        })

        viewModel.getComment().observe(this, Observer {
            myAdapter= CommentAdapter(this,it)
            binding.rvCommentItem.layoutManager=LinearLayoutManager(this)
            binding.rvCommentItem.adapter=myAdapter
            myAdapter.notifyDataSetChanged()
        })



    }
}