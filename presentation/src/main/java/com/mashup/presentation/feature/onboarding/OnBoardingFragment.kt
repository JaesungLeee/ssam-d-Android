package com.mashup.presentation.feature.onboarding

import android.content.Intent
import com.mashup.presentation.R
import com.mashup.presentation.common.base.BaseFragment
import com.mashup.presentation.common.extension.navigate
import com.mashup.presentation.common.extension.setThemeContent
import com.mashup.presentation.databinding.FragmentOnBoardingBinding
import com.mashup.presentation.feature.login.LoginActivity
import com.mashup.presentation.navigation.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment : BaseFragment<FragmentOnBoardingBinding>(R.layout.fragment_on_boarding) {
    override fun initViews() {
        binding.composeView.setThemeContent {
            OnBoardingScreen(
                navigateToNotificationPermission = ::navigateToNotification,
                navigateToLogin = ::navigateToLogin,
                navigateToHome = ::navigateToHome
            )
        }
    }

    private fun navigateToNotification() {
        navigate(R.id.action_onBoardingFragment_to_notificationPermissionGuideFragment)
    }

    private fun navigateToLogin() {
        startActivity(Intent(context, LoginActivity::class.java))
        activity?.finish()
    }

    private fun navigateToHome() {
        startActivity(Intent(context, MainActivity::class.java))
        activity?.finish()
    }
}