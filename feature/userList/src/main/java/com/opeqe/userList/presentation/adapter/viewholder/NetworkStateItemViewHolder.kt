package com.opeqe.userList.presentation.adapter.viewholder

import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.opeqe.userList.presentation.interfaces.RetryAction
import io.opeqe.businessmessenger.designSystem.databinding.NetworkStateItemBinding

class NetworkStateItemViewHolder(
    binding: NetworkStateItemBinding,
    private val onclick: RetryAction
) : RecyclerView.ViewHolder(binding.root) {
    private val progressBar = binding.progressBar
    private val errorMsg = binding.errorMsg

    private val retry = binding.retryButton
        .also {
            it.setOnClickListener { onclick.retryClick() }
        }


    fun bindTo(loadState: LoadState) {
        progressBar.isVisible = loadState is LoadState.Loading
        retry.isVisible = loadState is LoadState.Error
        errorMsg.isVisible = !(loadState as? LoadState.Error)?.error?.message.isNullOrBlank()
        errorMsg.text = (loadState as? LoadState.Error)?.error?.message
    }
}
