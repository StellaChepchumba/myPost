package com.example.mypost

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostRvAdapter (var postlist:List<Post>):RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
      var itemView=LayoutInflater.from(parent.context).inflate(R.layout.post_list_item,parent,false)
        return PostViewHolder(itemView)
    }
    //read on onview bind


    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost=postlist.get(position)
        holder.tvUserId.text=currentPost.userId.toString()
        holder.tvId.text=currentPost.id.toString()
        holder.tvTitle.text=currentPost.title
        holder.tvBody.text=currentPost.body
    }

    override fun getItemCount(): Int {
      return postlist.size
    }
}
class PostViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvUserId=itemView.findViewById<TextView>(R.id.tvUserId)
    var tvId=itemView.findViewById<TextView>(R.id.tvId)
    var tvTitle=itemView.findViewById<TextView>(R.id.tvTitle)
    var tvBody=itemView.findViewById<TextView>(R.id.tvBody)



}
