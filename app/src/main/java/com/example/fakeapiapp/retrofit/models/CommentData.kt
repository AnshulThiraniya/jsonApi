package com.example.fakeapiapp.retrofit.models

import com.google.gson.annotations.SerializedName

data class CommentData(
    @SerializedName("name")
    var name:String,

    @SerializedName("email")
    var email:String,

    @SerializedName("body")
    var body:String
)
