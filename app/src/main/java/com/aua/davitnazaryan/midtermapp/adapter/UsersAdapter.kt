package com.aua.davitnazaryan.midtermapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aua.davitnazaryan.midtermapp.R
import com.aua.davitnazaryan.midtermapp.model.User

class UsersAdapter: RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {
    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_user,
                parent,
                false
            )
        )
    }

    private val differCallback = object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.email == newItem.email
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       val user: User = differ.currentList[position]
        holder.itemView.apply {
        }
    }
}