package io.phoenix.businessmessenger.common.sdkextentions.navigation

import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import io.opeqe.businessmessenger.common.sdkextentions.R

val DefaultNavOptions: NavOptions = navOptions {
    anim {
        enter = R.anim.fade_scale_enter
        exit = R.anim.fade_exit
        popEnter = 0
        popExit = R.anim.fade_scale_exit
    }
}
