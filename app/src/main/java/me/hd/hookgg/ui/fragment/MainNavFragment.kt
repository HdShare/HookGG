package me.hd.hookgg.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import me.hd.hookgg.R
import me.hd.hookgg.databinding.FragmentMainNavBinding
import me.hd.hookgg.ui.fragment.base.BaseFragment

class MainNavFragment : BaseFragment<FragmentMainNavBinding, ViewModel>(
    FragmentMainNavBinding::inflate,
    null
) {
    override fun initFragment(binding: FragmentMainNavBinding, viewModel: ViewModel?) {
        (childFragmentManager.findFragmentById(R.id.mainNavView) as NavHostFragment).apply {
            binding.mainNavBottomNav.setupWithNavController(navController)
        }
    }
}