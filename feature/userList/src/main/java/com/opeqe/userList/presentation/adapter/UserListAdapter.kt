package com.opeqe.userList.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.opeqe.userList.presentation.entity.UserView
import com.opeqe.userList.presentation.interfaces.UserListAction
import io.opeqe.businessmessenger.designSystem.databinding.ItemUserBinding
import io.phoenix.businessmessenger.designSystem.ColorGenerator
import io.phoenix.businessmessenger.designSystem.TextDrawable

internal class UserListAdapter constructor(private val userListAction: UserListAction) :
    PagingDataAdapter<UserView, CryptoCurrencyViewHolder>(
        PLACE_COMPARATOR
    ) {


    override fun onBindViewHolder(holder: CryptoCurrencyViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, userListAction) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoCurrencyViewHolder {
        return CryptoCurrencyViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    companion object {
        private val PLACE_COMPARATOR = object : DiffUtil.ItemCallback<UserView>() {
            override fun areItemsTheSame(
                oldItem: UserView,
                newItem: UserView
            ): Boolean =
                oldItem == newItem


            override fun areContentsTheSame(
                oldItem: UserView,
                newItem: UserView
            ): Boolean =
                oldItem == newItem
        }
    }
}

internal class CryptoCurrencyViewHolder(
    private val binding: ItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        user: UserView,
        userListAction: UserListAction
    ) = user.let {
        binding.name.text = it.name
        binding.age.text = it.age.toString()
        binding.userName.text = it.userName
        it.name?.let {name->
            val text = if (name.count() >= 2)
                name.substring(0, 2) else name.substring(0, 1)
            val color = ColorGenerator.MATERIAL
            val builder = TextDrawable.Builder(text = text, color = color.getColor(text))
            val dr = TextDrawable(builder)
            binding.logo.setImageDrawable(dr)
        }
        binding.userItem.setOnClickListener {
            userListAction.onItemClick(user)
        }
    }
}



