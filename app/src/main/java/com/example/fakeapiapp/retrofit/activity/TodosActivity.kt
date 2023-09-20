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
import com.example.fakeapiapp.databinding.ActivityTodosBinding
import com.example.fakeapiapp.retrofit.adapters.ProductAdapter
import com.example.fakeapiapp.retrofit.adapters.TodoAdapter
import com.example.fakeapiapp.retrofit.viewmodels.ApiViewModel

class TodosActivity : AppCompatActivity() {
    lateinit var binding: ActivityTodosBinding
    lateinit var viewModel: ApiViewModel
    lateinit var myAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Todos")
        binding= DataBindingUtil.setContentView(this, R.layout.activity_todos)

        viewModel= ViewModelProvider(this)[ApiViewModel::class.java]

        var progressDialog= ProgressDialog(this)
        progressDialog.setMessage("loading please wait...")
        progressDialog.setCancelable(false)

        viewModel.todoLoding.observe(this, Observer {
            if(it){
                progressDialog.show()
            }
            else{
                progressDialog.dismiss()
            }
        })

        viewModel.getTodo().observe(this, Observer {
            myAdapter= TodoAdapter(this,it)
            binding.rvTodosItem.layoutManager= LinearLayoutManager(this)
            binding.rvTodosItem.adapter=myAdapter
            myAdapter.notifyDataSetChanged()
        })



    }
}