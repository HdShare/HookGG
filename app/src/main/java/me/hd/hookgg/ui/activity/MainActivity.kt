package me.hd.hookgg.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.highcapable.yukihookapi.hook.xposed.parasitic.activity.base.ModuleAppCompatActivity
import me.hd.hookgg.R
import me.hd.hookgg.databinding.ActivityMainBinding
import me.hd.hookgg.ui.adapter.MVP2Adapter
import me.hd.hookgg.ui.fragment.LogPageFragment
import me.hd.hookgg.ui.fragment.SetPageFragment

class MainActivity : ModuleAppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun getFragmentList(): MutableList<Fragment> {
        val fragmentList: MutableList<Fragment> = ArrayList()
        fragmentList.add(LogPageFragment())
        fragmentList.add(SetPageFragment())
        return fragmentList
    }

    private fun initView() {
        binding.mainViewPager2.adapter = MVP2Adapter(this, getFragmentList())
        binding.mainViewPager2.isUserInputEnabled = false
        binding.mainNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_log -> binding.mainViewPager2.setCurrentItem(0, false)
                R.id.nav_set -> binding.mainViewPager2.setCurrentItem(1, false)
            }
            true
        }
    }
}