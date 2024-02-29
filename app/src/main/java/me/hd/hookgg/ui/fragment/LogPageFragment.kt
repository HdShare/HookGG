package me.hd.hookgg.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.highcapable.yukihookapi.YukiHookAPI
import me.hd.hookgg.R
import me.hd.hookgg.databinding.FragmentLogPageBinding
import me.hd.hookgg.hook.hooker.GG960Hooker.dataChannel
import me.hd.hookgg.ui.adapter.LogAdapter
import me.hd.hookgg.ui.fragment.base.BaseFragment

class LogPageFragment : BaseFragment<FragmentLogPageBinding, ViewModel>(
    FragmentLogPageBinding::inflate,
    null
) {
    private lateinit var logAdapter: LogAdapter

    override fun initFragment(
        binding: FragmentLogPageBinding,
        viewModel: ViewModel?
    ) {
        initView(binding)
    }

    private fun initView(binding: FragmentLogPageBinding) {
        if (YukiHookAPI.Status.isModuleActive) {
            binding.logPageToolbar.subtitle = getString(R.string.module_active)
        }
        binding.logPageRvLog.layoutManager = LinearLayoutManager(requireContext())
        logAdapter = LogAdapter()
        binding.logPageRvLog.adapter = logAdapter
        dataChannel.wait<CharSequence>(key = "log") { value ->
            logAdapter.addLog(value)
        }
    }
}