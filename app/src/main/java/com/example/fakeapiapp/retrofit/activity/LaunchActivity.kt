package com.example.fakeapiapp.retrofit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.fakeapiapp.R
import com.example.fakeapiapp.databinding.ActivityLaunchBinding

class LaunchActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding:ActivityLaunchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_launch)

        binding.btnPosts.setOnClickListener(this)
        binding.btnComment.setOnClickListener(this)
        binding.btnTodos.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_posts->{
                val intent=Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_comment->{
                 val intent=Intent(this,CommentsActivity::class.java)
                 startActivity(intent)

            }
            R.id.btn_todos->{
                val intent=Intent(this,TodosActivity::class.java)
                startActivity(intent)
            }
        }

    }

}