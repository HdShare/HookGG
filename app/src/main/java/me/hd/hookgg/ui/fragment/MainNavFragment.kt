package me.hd.hookgg.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import me.hd.hookgg.R
import me.hd.hookgg.databinding.FragmentMainNavBinding
import me.hd.hookgg.ui.adapter.MainViewPager2Adapter
import me.hd.hookgg.ui.fragment.base.FragmentBase
import me.hd.hookgg.ui.fragment.nav.LogPageFragment
import me.hd.hookgg.ui.fragment.nav.ModulePageFragment
import me.hd.hookgg.ui.fragment.nav.SetPageFragment

class MainNavFragment : FragmentBase<FragmentMainNavBinding, ViewModel>(
    FragmentMainNavBinding::inflate
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainNavViewPager2.apply {
            isUserInputEnabled = false
            adapter = MainViewPager2Adapter(
                requireActivity(),
                arrayOf(
                    LogPageFragment(),
                    ModulePageFragment(),
                    SetPageFragment(),
                )
            )
            binding.mainNavBottomNav.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.navLogPageFragment -> setCurrentItem(0, false)
                    R.id.navModulePageFragment -> setCurrentItem(1, false)
                    R.id.navSetPageFragment -> setCurrentItem(2, false)
                }
                true
            }
        }
    }
}