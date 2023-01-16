package com.natiqhaciyef.travelguideapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.natiqhaciyef.travelguideapp.R
import com.natiqhaciyef.travelguideapp.data.model.PostModel
import com.natiqhaciyef.travelguideapp.databinding.RecyclerHomePostsBinding

class HomePostAdapter(
    val list: MutableList<PostModel>,
    val mContext: Context
) : RecyclerView.Adapter<HomePostAdapter.HomePostHolder>() {

    class HomePostHolder(val binding: RecyclerHomePostsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePostHolder {
        val binding: RecyclerHomePostsBinding = DataBindingUtil
            .inflate(LayoutInflater.from(mContext), R.layout.recycler_home_posts, parent, false)
        return HomePostHolder(binding)
    }

    override fun onBindViewHolder(holder: HomePostHolder, position: Int) {
        val postModel = list[position]
        val view = holder.binding

        view.postModel = postModel
        view.postImage.setImageResource(mContext.resources
            .getIdentifier(postModel.image, "drawable",mContext.packageName))
    }

    override fun getItemCount(): Int = list.size

}