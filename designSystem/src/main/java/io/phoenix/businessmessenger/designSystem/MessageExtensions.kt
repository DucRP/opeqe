package io.phoenix.businessmessenger.designSystem

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import io.phoenix.businessmessenger.data.entity.LocalException

fun Fragment.showError(@StringRes message: Int) {// todo error handling
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showError(exception: LocalException) {
    if (exception.errorId != 0)
        Toast.makeText(requireContext(), getString(exception.errorId), Toast.LENGTH_SHORT).show()
    else
        Toast.makeText(requireContext(), exception.message, Toast.LENGTH_SHORT).show()

}
