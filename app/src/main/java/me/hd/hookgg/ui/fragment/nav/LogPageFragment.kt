package me.hd.hookgg.ui.fragment.nav

import android.net.Uri
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
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
import java.time.LocalDateTime
import java.util.concurrent.CompletableFuture

class LogPageFragment : BaseFragment<FragmentLogPageBinding, ViewModel>(
    FragmentLogPageBinding::inflate,
    null
) {
    private lateinit var logAdapter: LogAdapter
    private val saveLogsLauncher = registerForActivityResult(
        ActivityResultContracts.CreateDocument("text/plain")
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
        initMenu()
        initAdapter(binding)
    }

    private fun initMenu() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.log_tab_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.tab_save -> {
                        saveLogsLauncher.launch("${BuildConfig.TAG}_${LocalDateTime.now()}.lua")
                        true
                    }

                    R.id.tab_clear -> {
                        logAdapter.clearLog()
                        true
                    }

                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
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