package io.phoenix.businessmessenger.common.sdkextentions.bindings

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl", "imagePlaceholder", requireAll = false)
fun ImageView.imageUrl(url: String?, placeholderId: Drawable? = null) {
    Glide.with(context)
        .load(url)
        .apply {
            placeholderId?.let { placeholder(it) }
        }
        .into(this)
}
