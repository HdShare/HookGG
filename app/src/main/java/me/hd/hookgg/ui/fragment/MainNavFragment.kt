package me.hd.hookgg.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import me.hd.hookgg.R
import me.hd.hookgg.databinding.FragmentMainNavBinding
import me.hd.hookgg.ui.fragment.base.FragmentBase

class MainNavFragment : FragmentBase<FragmentMainNavBinding, ViewModel>(
    FragmentMainNavBinding::inflate
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (childFragmentManager.findFragmentById(R.id.mainNavView) as NavHostFragment).apply {
            binding.mainNavBottomNav.setupWithNavController(navController)
        }
    }
}