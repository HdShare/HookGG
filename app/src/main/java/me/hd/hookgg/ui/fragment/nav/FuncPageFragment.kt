package me.hd.hookgg.ui.fragment.nav

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import com.google.android.flexbox.FlexboxLayoutManager
import com.highcapable.yukihookapi.YukiHookAPI
import me.hd.hookgg.R
import me.hd.hookgg.databinding.FragmentFuncPageBinding
import me.hd.hookgg.ui.adapter.FuncAdapter
import me.hd.hookgg.ui.fragment.base.FragmentBase

class FuncPageFragment : FragmentBase<FragmentFuncPageBinding, ViewModel>(
    FragmentFuncPageBinding::inflate
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        if (YukiHookAPI.Status.isModuleActive) {
            binding.funcPageToolbar.subtitle = getString(R.string.module_active)
        }
        initModuleAdapter()
    }

    private fun initModuleAdapter() {
        binding.funcPageRvFunc.apply {
            layoutManager = FlexboxLayoutManager(context)
            adapter = FuncAdapter()
        }
    }
}