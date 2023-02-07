package com.postappps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.postappps.databinding.ActivityMainBinding
import com.postappps.databinding.EachRowBinding
import com.postappps.models.Post

class PostAdapter(private var postList : List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    lateinit var binding: EachRowBinding
    class PostViewHolder(view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        binding = EachRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return  PostViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
       return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        binding.tasks.text = postList.get(position).body.toString()
    }

    fun setPost(post : List<Post>){
        postList = post
        notifyDataSetChanged()
    }
}


