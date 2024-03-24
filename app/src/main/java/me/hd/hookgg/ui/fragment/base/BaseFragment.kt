package me.hd.hookgg.ui.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(
    private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB,
    private val viewModelClass: Class<VM>?
) : Fragment() {
    private var bufferRootView: View? = null
    private var binding: VB? = null
    private val viewModel by lazy {
        viewModelClass?.let {
            ViewModelProvider(this)[viewModelClass]
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bufferRootView?.let { return bufferRootView }
        binding = inflate.invoke(inflater, container, false)
        initFragment(binding!!, viewModel)
        bufferRootView = binding!!.root
        return bufferRootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    abstract fun initFragment(binding: VB, viewModel: VM?)
}