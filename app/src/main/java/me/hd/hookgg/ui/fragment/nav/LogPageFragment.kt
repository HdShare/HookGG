package me.hd.hookgg.ui.fragment.nav

import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.highcapable.yukihookapi.YukiHookAPI
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.R
import me.hd.hookgg.databinding.FragmentLogPageBinding
import me.hd.hookgg.hook.hooker.gg960.GG960Hooker
import me.hd.hookgg.ui.adapter.LogAdapter
import me.hd.hookgg.ui.fragment.base.BaseFragment
import java.io.FileOutputStream
import java.util.concurrent.CompletableFuture

class LogPageFragment : BaseFragment<FragmentLogPageBinding, ViewModel>(
    FragmentLogPageBinding::inflate,
    null
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

    override fun initFragment(binding: FragmentLogPageBinding, viewModel: ViewModel?) {
        initView(binding)
    }

    private fun initView(binding: FragmentLogPageBinding) {
        if (YukiHookAPI.Status.isModuleActive) {
            binding.logPageToolbar.subtitle = getString(R.string.module_active)
        }
        initMenu(binding)
        initAdapter(binding)
    }

    private fun initMenu(binding: FragmentLogPageBinding) {
        binding.logPageToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
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

    private fun initAdapter(binding: FragmentLogPageBinding) {
        logAdapter = LogAdapter()
        binding.logPageRvLog.layoutManager = LinearLayoutManager(requireContext())
        binding.logPageRvLog.adapter = logAdapter
        GG960Hooker.dataChannel.wait<CharSequence>("log") { value ->
            logAdapter.addLog(value)
        }
    }
}