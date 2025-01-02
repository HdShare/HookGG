package me.hd.hookgg.ui.fragment.nav

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.hook.factory.prefs
import kotlinx.coroutines.launch
import me.hd.hookgg.MyApp
import me.hd.hookgg.R
import me.hd.hookgg.config.data.HookerData
import me.hd.hookgg.config.data.SetPrefsData
import me.hd.hookgg.config.bean.FuncObj
import me.hd.hookgg.databinding.FragmentFuncPageBinding
import me.hd.hookgg.ui.adapter.FuncAdapter
import me.hd.hookgg.ui.fragment.base.FragmentBase

@SuppressLint("NotifyDataSetChanged")
class FuncPageFragment : FragmentBase<FragmentFuncPageBinding, ViewModel>(
    FragmentFuncPageBinding::inflate
) {
    private lateinit var funcAdapter: FuncAdapter
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

    // TODO String and Math
    private fun initAdapter() {
        binding.funcPageTabLayout.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    when (tab.text) {
                        getString(R.string.func_gg) -> {
                        }

                        getString(R.string.func_string) -> {
                            Snackbar.make(
                                binding.root,
                                "No Developing",
                                Snackbar.LENGTH_SHORT
                            ).setAnchorView(binding.funcPageTabLayout).show()
                        }

                        getString(R.string.func_math) -> {
                            Snackbar.make(
                                binding.root,
                                "No Developing",
                                Snackbar.LENGTH_SHORT
                            ).setAnchorView(binding.funcPageTabLayout).show()
                        }
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

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            val funcObjNewList = HookerData.getFuncObjList(prefs.get(SetPrefsData.VERSION_NAME))
            funcObjList.apply {
                clear()
                addAll(funcObjNewList)
            }
            funcAdapter.notifyDataSetChanged()
        }
    }
}