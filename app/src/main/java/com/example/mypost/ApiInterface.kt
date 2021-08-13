package com.example.mypost

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.sql.RowId

interface ApiInterface {
    @GET("post")
    fun getPosts():Call<List<Post>>

    @GET("post/{id}")
    fun getPostById(@Path("id")postId:Int):Call<Post>
}