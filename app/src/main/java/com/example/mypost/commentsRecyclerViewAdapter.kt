package com.example.mypost

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class commentsRecyclerViewAdapter (var commentList:List<commentsRecyclerViewAdapter>):RecyclerView.Adapter<commentsViewHolder>() {
    private val name: CharSequence? = null
    private val email: CharSequence? = null
    val Body: CharSequence? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): commentsViewHolder {
        var itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.comments_list_items,parent,false)
        return commentsViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: commentsViewHolder, position: Int) {
        var currentComments=commentList.get(position)
        holder.name.text=currentComments.name
        holder.email.text=currentComments.email
        holder.body.text=currentComments.Body

    }

    override fun getItemCount(): Int {
        return commentList.size

    }
}

class commentsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var name=itemView.findViewById<TextView>(R.id.tvname)
    var email=itemView.findViewById<TextView>(R.id.tvemail)
    var body=itemView.findViewById<TextView>(R.id.tvBody)
}
