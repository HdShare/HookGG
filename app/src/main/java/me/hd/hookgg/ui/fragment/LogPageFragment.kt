package me.hd.hookgg.ui.fragment

import android.net.Uri
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.highcapable.yukihookapi.YukiHookAPI
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.R
import me.hd.hookgg.databinding.FragmentLogPageBinding
import me.hd.hookgg.hook.hooker.GG960Hooker.dataChannel
import me.hd.hookgg.ui.adapter.LogAdapter
import me.hd.hookgg.ui.fragment.base.BaseFragment
import java.io.FileOutputStream
import java.time.LocalDateTime
import java.util.concurrent.CompletableFuture.runAsync

class LogPageFragment : BaseFragment<FragmentLogPageBinding, ViewModel>(
    FragmentLogPageBinding::inflate,
    null
) {
    private lateinit var logAdapter: LogAdapter

    private val saveLogsLauncher = registerForActivityResult(
        ActivityResultContracts.CreateDocument("text/plain")
    ) { uri: Uri? ->
        if (uri == null) return@registerForActivityResult
        runAsync {
            requireContext().contentResolver.openFileDescriptor(uri, "wt").use { fd ->
                FileOutputStream(fd?.fileDescriptor).use { outputStream ->
                    logAdapter.outLog(outputStream)
                }
            }
        }
    }

    override fun initFragment(
        binding: FragmentLogPageBinding,
        viewModel: ViewModel?
    ) {
        initView(binding)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.log_tab_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.tab_save -> {
                saveLogsLauncher.launch("${BuildConfig.TAG}_${LocalDateTime.now()}.txt")
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initView(binding: FragmentLogPageBinding) {
        setHasOptionsMenu(true)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.logPageToolbar)
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