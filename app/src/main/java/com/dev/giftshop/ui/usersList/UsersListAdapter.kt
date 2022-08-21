package com.dev.giftshop.ui.usersList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dev.giftshop.R
import com.dev.giftshop.databinding.CardUsersBinding
import com.dev.giftshop.domain.entity.UserInfoEntity
import com.squareup.picasso.Picasso

class UsersListAdapter(
    private var userList: List<UserInfoEntity>,
    private val itemClickListener: (Int) -> Unit
) :
    RecyclerView.Adapter<UsersListAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.card_users,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        if (userList.size > position) {
            holder.bind(userList[position])
            holder.itemView.setOnClickListener {
                itemClickListener(userList[position].userId)
            }
        }
    }

    override fun getItemCount(): Int = userList.size

    class UserViewHolder(private val binding: CardUsersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: UserInfoEntity) {
            Picasso.get()
                .load(model.image)
                .error(R.drawable.ic_user)
                .fit()
                .into(binding.imageViewUser)
            binding.userModel = model
        }
    }
}