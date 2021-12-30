package com.opeqe.userList.presentation

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.opeqe.userList.R
import com.opeqe.userList.databinding.FragmentCryptoCurrencyBinding
import com.opeqe.userList.domail.entity.SortType
import com.opeqe.userList.presentation.adapter.UserListAdapter
import com.opeqe.userList.presentation.adapter.UserLoadStateAdapter
import com.opeqe.userList.presentation.entity.UserView
import com.opeqe.userList.presentation.interfaces.UserListAction
import com.opeqe.userList.presentation.interfaces.RetryAction
import dagger.android.support.DaggerFragment
import io.phoenix.businessmessenger.common.di.ViewModelFactory
import io.phoenix.businessmessenger.common.sdkextentions.navigation.DefaultNavOptions
import io.phoenix.businessmessenger.common.sdkextentions.properties.autoCleared
import io.phoenix.businessmessenger.common.sdkextentions.properties.viewBinding
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


class UserFragment : DaggerFragment(R.layout.fragment_crypto_currency),
    SwipeRefreshLayout.OnRefreshListener, CompoundButton.OnCheckedChangeListener,
    RetryAction, UserListAction {
    @Inject
    lateinit var abstractFactory: ViewModelFactory

    private var adapter by autoCleared<UserListAdapter>()

    private val binding by viewBinding(FragmentCryptoCurrencyBinding::bind)
    private val viewModel by viewModels<UserListViewModel> {
        abstractFactory.create(
            this,
            arguments
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = UserListAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            swipeRefresh.setOnRefreshListener(this@UserFragment)
            list.adapter = adapter.withLoadStateHeaderAndFooter(
                header = UserLoadStateAdapter(
                    this@UserFragment
                ),
                footer = UserLoadStateAdapter(
                    this@UserFragment
                )
            )
            nameSort.setOnCheckedChangeListener(this@UserFragment)
            defaultSort.setOnCheckedChangeListener(this@UserFragment)
            userNameSort.setOnCheckedChangeListener(this@UserFragment)
            ageSort.setOnCheckedChangeListener(this@UserFragment)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.cryptoCurrencyList.collectLatest {
                    binding?.swipeRefresh?.isRefreshing = false
                    adapter.submitData(it)
                }
                adapter.loadStateFlow
                    .distinctUntilChangedBy { it.refresh }
                    .filter { it.refresh is LoadState.NotLoading }
                    .collect { binding?.list?.scrollToPosition(0) }
            }

        }
    }

    override fun onRefresh() {
        viewModel.rGetLastCryptoCurrency()
    }

    override fun retryClick() {
        adapter.retry()
    }

    override fun onItemClick(user: UserView) {
        findNavController().navigate(
            Uri.parse("Opeqe://UserDetail/?id=" + user.id + "?userName=" + user.userName + "?name=" + user.name + "?age=" + user.age),
            DefaultNavOptions
        )
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        when (p0?.id) {
            R.id.age_sort -> {
                viewModel.rGetUser(SortType.age)
            }
            R.id.default_sort -> {
                viewModel.rGetUser(SortType.none)
            }
            R.id.name_sort -> {
                viewModel.rGetUser(SortType.name)
            }
            R.id.userName_sort -> {
                viewModel.rGetUser(SortType.userName)
            }
        }
    }
}

