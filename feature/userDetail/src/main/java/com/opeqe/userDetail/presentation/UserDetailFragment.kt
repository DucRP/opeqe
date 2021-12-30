package com.opeqe.userDetail.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.opeqe.userDetail.R
import com.opeqe.userDetail.databinding.FragmentUserDetailDetailBinding
import dagger.android.support.DaggerFragment
import io.phoenix.businessmessenger.common.di.ViewModelFactory
import io.phoenix.businessmessenger.common.sdkextentions.properties.viewBinding
import io.phoenix.businessmessenger.data.entity.onSuccess
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserDetailFragment :
    DaggerFragment(R.layout.fragment_user_detail_detail) {

    @Inject
    lateinit var abstractFactory: ViewModelFactory

    private val binding by viewBinding(FragmentUserDetailDetailBinding::bind)
    private val viewModel by viewModels<UserDetailViewModel> {
        abstractFactory.create(
            this,
            arguments
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.userDetail.collect {
                    it.onSuccess {
                        binding?.apply {
                            nameText.text = it.name
                            userName.text = it.userName
                            age.text = it.age.toString()
                        }
                    }
                }
            }
        }
    }
}
