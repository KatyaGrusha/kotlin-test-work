package com.dev.giftshop.ui.userDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dev.giftshop.R
import com.dev.giftshop.data.dataclass.PostModel
import com.dev.giftshop.databinding.CardUserDetailBinding

class PostsAdapter (
    private var postList: List<PostModel>
) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.card_user_detail,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        if (postList.size > position) {
            holder.bind(postList[position])
        }
    }

    override fun getItemCount(): Int = postList.size

    class PostViewHolder(private val binding: CardUserDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: PostModel) {
            binding.postModel = model
        }
    }
}