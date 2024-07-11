package me.hd.hookgg.ui.fragment.nav

import android.graphics.Typeface
import androidx.lifecycle.ViewModel
import com.highcapable.yukihookapi.YukiHookAPI
import me.hd.hookgg.R
import me.hd.hookgg.databinding.FragmentEditPageBinding
import me.hd.hookgg.ui.fragment.base.BaseFragment

class EditPageFragment : BaseFragment<FragmentEditPageBinding, ViewModel>(
    FragmentEditPageBinding::inflate,
    null
) {
    override fun initFragment(binding: FragmentEditPageBinding, viewModel: ViewModel?) {
        initView(binding)
    }

    private fun initView(binding: FragmentEditPageBinding) {
        if (YukiHookAPI.Status.isModuleActive) {
            binding.editPageToolbar.subtitle = getString(R.string.module_active)
        }
        initCodeEditor(binding)
    }

    private fun initCodeEditor(binding: FragmentEditPageBinding) {
        val typeface = Typeface.createFromAsset(requireContext().assets, "font-mono.ttf")
        binding.editPageEditor.typefaceText = typeface
    }
}