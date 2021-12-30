package com.opeqe.userList.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.opeqe.userList.R
import com.opeqe.userList.presentation.adapter.viewholder.NetworkStateItemViewHolder
import com.opeqe.userList.presentation.interfaces.RetryAction
import io.opeqe.businessmessenger.designSystem.databinding.NetworkStateItemBinding

class UserLoadStateAdapter(
    private val onclick: RetryAction
) : LoadStateAdapter<NetworkStateItemViewHolder>() {
    override fun onBindViewHolder(holder: NetworkStateItemViewHolder, loadState: LoadState) {
        holder.bindTo(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): NetworkStateItemViewHolder {
        return NetworkStateItemViewHolder(
            NetworkStateItemBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.network_state_item, parent, false
                )
            ), onclick
        )
    }
}