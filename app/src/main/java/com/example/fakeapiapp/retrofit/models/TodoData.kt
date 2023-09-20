package com.example.fakeapiapp.retrofit.models

import com.google.gson.annotations.SerializedName

data class TodoData(
    @SerializedName("id")
    var id:Int,

    @SerializedName("title")
    var titile:String,

    @SerializedName("completed")
    var status:String
)
