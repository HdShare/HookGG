package me.hd.hookgg.ui.fragment.nav

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.highcapable.yukihookapi.YukiHookAPI
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.R
import me.hd.hookgg.databinding.FragmentLogPageBinding
import me.hd.hookgg.hook.hooker.gg.v960.GGv960Hooker
import me.hd.hookgg.ui.adapter.LogAdapter
import me.hd.hookgg.ui.fragment.base.FragmentBase
import java.io.FileOutputStream
import java.util.concurrent.CompletableFuture

class LogPageFragment : FragmentBase<FragmentLogPageBinding, ViewModel>(
    FragmentLogPageBinding::inflate
) {
    private lateinit var logAdapter: LogAdapter
    private val saveLogsLauncher = registerForActivityResult(
        ActivityResultContracts.CreateDocument("application/x-lua")
    ) { uri: Uri? ->
        if (uri == null) return@registerForActivityResult
        CompletableFuture.runAsync {
            requireContext().contentResolver.openFileDescriptor(uri, "wt").use { fd ->
                FileOutputStream(fd?.fileDescriptor).use { outputStream ->
                    logAdapter.outLog(outputStream)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        if (YukiHookAPI.Status.isModuleActive) {
            binding.logPageToolbar.subtitle = getString(R.string.module_active)
        }
        initMenu()
        initAdapter()
    }

    private fun initMenu() {
        binding.logPageToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.tab_copy -> {
                    logAdapter.copyLog(requireContext())
                    true
                }

                R.id.tab_save -> {
                    saveLogsLauncher.launch("${BuildConfig.TAG}_${System.currentTimeMillis()}.lua")
                    true
                }

                R.id.tab_clear -> {
                    logAdapter.clearLog()
                    true
                }

                else -> false
            }
        }
    }

    private fun initAdapter() {
        logAdapter = LogAdapter()
        binding.logPageRvLog.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = logAdapter
        }
        GGv960Hooker.dataChannel.wait<CharSequence>("log") { value ->
            logAdapter.addLog(value)
        }
    }
}