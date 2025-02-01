package me.hd.hookgg.ui.fragment.nav

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.hook.factory.prefs
import kotlinx.coroutines.launch
import me.hd.hookgg.MyApp
import me.hd.hookgg.R
import me.hd.hookgg.config.bean.FuncObj
import me.hd.hookgg.config.data.HookerData
import me.hd.hookgg.config.data.SetPrefsData
import me.hd.hookgg.config.lib.LibType
import me.hd.hookgg.databinding.FragmentFuncPageBinding
import me.hd.hookgg.ui.adapter.FuncAdapter
import me.hd.hookgg.ui.fragment.base.FragmentBase

@SuppressLint("NotifyDataSetChanged")
class FuncPageFragment : FragmentBase<FragmentFuncPageBinding, ViewModel>(
    FragmentFuncPageBinding::inflate
) {
    private lateinit var funcAdapter: FuncAdapter
    private var funcLibType = LibType.GGLib
    private var funcObjList = mutableListOf<FuncObj>()
    private val prefs = MyApp.context.prefs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        if (YukiHookAPI.Status.isModuleActive) {
            binding.funcPageToolbar.subtitle = getString(R.string.module_active)
        }
        initMenu()
        initAdapter()
        initFabMenu()
    }

    // TODO Menu
    private fun initMenu() {

    }

    private fun initAdapter() {
        binding.funcPageTabLayout.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    when (tab.text) {
                        getString(R.string.func_gg) -> refreshFuncList(LibType.GGLib)
                        getString(R.string.func_math) -> refreshFuncList(LibType.MathLib)
                        getString(R.string.func_string) -> refreshFuncList(LibType.StringLib)
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {
                }

                override fun onTabReselected(tab: TabLayout.Tab) {
                }
            }
        )
        funcAdapter = FuncAdapter(funcObjList)
        binding.funcPageRvFunc.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = funcAdapter
        }
    }

    private fun initFabMenu() {
        binding.funcPageFabSelectAll.setOnClickListener {
            prefs.edit {
                put(SetPrefsData.FUNC_LIST, HookerData.getFuncNameSet(prefs.get(SetPrefsData.VERSION_NAME)))
            }
            funcAdapter.notifyDataSetChanged()
        }
        binding.funcPageFabClearAll.setOnClickListener {
            prefs.edit {
                put(SetPrefsData.FUNC_LIST, setOf())
            }
            funcAdapter.notifyDataSetChanged()
        }
    }

    private fun refreshFuncList(libType: LibType) {
        funcLibType = libType
        lifecycleScope.launch {
            val versionName = prefs.get(SetPrefsData.VERSION_NAME)
            if (versionName.isNotEmpty()) {
                binding.funcPageRvFunc.visibility = View.VISIBLE
                binding.funcPageTvHelp.visibility = View.GONE
                val newFuncObjList = HookerData.getFuncObjList(versionName)
                funcObjList.apply {
                    clear()
                    addAll(newFuncObjList.filter { it.funcDetail.libType == libType })
                }
                funcAdapter.notifyDataSetChanged()
            } else {
                binding.funcPageRvFunc.visibility = View.GONE
                binding.funcPageTvHelp.visibility = View.VISIBLE
            }
        }
    }

    override fun onResume() {
        super.onResume()
        refreshFuncList(funcLibType)
    }
}