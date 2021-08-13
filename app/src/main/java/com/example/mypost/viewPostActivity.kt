package com.example.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mypost.databinding.ActivityViewPostBinding
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.Callback

class viewPostActivity : AppCompatActivity() {
    lateinit var rvComments:RecyclerView
    lateinit var binding:ActivityViewPostBinding
    var postId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var postId = intent.getIntExtra("POST-ID",0)
        setSupportActionBar(binding.toolbar2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    fun getPost() {
        var retrofit = ApiClient.buildServices(ApiInterface::class.java)
        var request = retrofit.getPostById(postId)
        request.enqueue(object :Callback<Posts> {
            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                if (response.isSuccessful) {
                    binding.tvComments.text = response.body()?.title
                    binding.tvBody.text = response.body()?.body

                }
            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

            }

            fun getComments() {
                var rvComments = findViewById<RecyclerView>(R.id.rvComments)
                var retrofit = ApiClient.buildServices(ApiInterface::class.java)
                var request = retrofit.getPosts(postId)
                request.enqueue(object : Callback<List<commentsRecyclerViewAdapter>> {
                    override fun onResponse(
                        call: Call<List<comments>?>,
                        response: Response<List<comments>?>
                    ) {
                        if (response.isSuccessful) {
                            var comments = response.body()!!

                            var commentsAdapter = comments(comments)
                            rvComments.adapter = commentsAdapter
                            rvComments.layoutManager = LinearLayoutManager(baseContext)

                        }
                    }

                    override fun onFailure(call: Call<List<comments>?>, t: Throwable) {
                        Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

                    }
                })
            }
        }