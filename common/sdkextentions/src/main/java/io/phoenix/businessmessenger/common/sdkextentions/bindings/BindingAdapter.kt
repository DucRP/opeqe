package io.phoenix.businessmessenger.common.sdkextentions.bindings

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun View.isVisible(result: Boolean) {
    isVisible = result
}

