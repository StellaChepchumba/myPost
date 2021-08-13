package com.example.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvPost:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
fetchPosts()
    }
    fun fetchPosts(){
  val retrofit=ApiClient.buildServices(ApiInterface::class.java)
        val request=retrofit.getPosts()
        request.enqueue(object :Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
              if(response.isSuccessful){
                  var postList=response.body()!!
                  if (postList!=null) {
                      rvPost = findViewById(R.id.rvPost)
                      rvPost.layoutManager = LinearLayoutManager(baseContext)
                      var postAdapter = PostRvAdapter(postList)
                      rvPost.adapter = postAdapter

                  }
              }

            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }
        })



    }

}
