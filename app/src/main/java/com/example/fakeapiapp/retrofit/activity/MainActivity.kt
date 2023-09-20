package com.example.fakeapiapp.retrofit.activity

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakeapiapp.R
import com.example.fakeapiapp.databinding.ActivityMainBinding
import com.example.fakeapiapp.retrofit.viewmodels.ApiViewModel
import com.example.fakeapiapp.retrofit.adapters.ProductAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ApiViewModel
    lateinit var myAdapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Posts")

        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel= ViewModelProvider(this)[ApiViewModel::class.java]

        var progressDialog= ProgressDialog(this)
        progressDialog.setMessage("loading please wait...")
        progressDialog.setCancelable(false)

        viewModel.isLoding.observe(this, Observer {
            if(it){
                progressDialog.show()
            }
            else{
                progressDialog.dismiss()
            }
        })

        viewModel.getPosts().observe(this, Observer {
            myAdapter= ProductAdapter(this,it)
            binding.rvProductItem.layoutManager= LinearLayoutManager(this)
            binding.rvProductItem.adapter=myAdapter
            myAdapter.notifyDataSetChanged()
        })


    }
}