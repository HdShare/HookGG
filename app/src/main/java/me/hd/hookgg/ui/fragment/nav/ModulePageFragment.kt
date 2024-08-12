package me.hd.hookgg.ui.fragment.nav

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.highcapable.yukihookapi.YukiHookAPI
import me.hd.hookgg.R
import me.hd.hookgg.databinding.FragmentModulePageBinding
import me.hd.hookgg.ui.adapter.ModuleAdapter
import me.hd.hookgg.ui.fragment.base.FragmentBase

class ModulePageFragment : FragmentBase<FragmentModulePageBinding, ViewModel>(
    FragmentModulePageBinding::inflate
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        if (YukiHookAPI.Status.isModuleActive) {
            binding.modulePageToolbar.subtitle = getString(R.string.module_active)
        }
        initModuleAdapter()
    }

    private fun initModuleAdapter() {
        binding.modulePageRvModule.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = ModuleAdapter()
        }
    }
}