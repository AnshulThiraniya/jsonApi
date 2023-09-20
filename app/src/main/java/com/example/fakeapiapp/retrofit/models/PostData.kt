package com.example.fakeapiapp.retrofit.models

import com.google.gson.annotations.SerializedName

data class PostData(
    @SerializedName("id")
    var id:Int,

    @SerializedName("title")
    var titile:String,

    @SerializedName("body")
    var body:String
)
