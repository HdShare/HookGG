package me.hd.hookgg.ui.fragment

import android.view.LayoutInflater
import androidx.lifecycle.ViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.hook.factory.prefs
import me.hd.hookgg.MyApp
import me.hd.hookgg.R
import me.hd.hookgg.data.ConfigData
import me.hd.hookgg.databinding.DialogEditPackageNameBinding
import me.hd.hookgg.databinding.FragmentSetPageBinding
import me.hd.hookgg.ui.fragment.base.BaseFragment

class SetPageFragment : BaseFragment<FragmentSetPageBinding, ViewModel>(
    FragmentSetPageBinding::inflate,
    null
) {
    override fun initFragment(
        binding: FragmentSetPageBinding,
        viewModel: ViewModel?
    ) {
        initView(binding)
    }

    private fun initView(binding: FragmentSetPageBinding) {
        if (YukiHookAPI.Status.isModuleActive) {
            binding.setPageToolbar.subtitle = getString(R.string.module_active)
        }
        binding.setTvDefPackageName.text = MyApp.context.prefs().get(ConfigData.SET_PACKAGE_NAME)
        binding.setTvDefFunctionStatus.text = ConfigData.SET_FUNCTION_LIST
            .filter { MyApp.context.prefs().get(ConfigData.SET_FUNCTION_LIST_PREFS[it]!!) }
            .toString()
        binding.setLLPackageName.setOnClickListener {
            val dialogBinding =
                DialogEditPackageNameBinding.inflate(LayoutInflater.from(requireContext()))
            dialogBinding.textInputEditText.setText(
                MyApp.context.prefs().get(ConfigData.SET_PACKAGE_NAME)
            )
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.set_key_package_name)
                .setView(dialogBinding.root)
                .setPositiveButton(R.string.dialog_accept) { _, _ ->
                    val packageName = dialogBinding.textInputEditText.text.toString()
                    if (packageName.isNotEmpty()) {
                        MyApp.context.prefs().edit {
                            put(ConfigData.SET_PACKAGE_NAME, packageName)
                        }
                    }
                    binding.setTvDefPackageName.text = packageName
                }
                .setNegativeButton(R.string.dialog_decline) { _, _ -> }
                .show()
        }
        binding.setLLFunctionList.setOnClickListener {
            val functionList = ConfigData.SET_FUNCTION_LIST
            val functionStatus = ConfigData.SET_FUNCTION_LIST_PREFS
                .map { MyApp.context.prefs().get(it.value) }
                .toBooleanArray()
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.set_key_function_list)
                .setMultiChoiceItems(functionList, functionStatus) { _, which, isChecked ->
                    functionStatus[which] = isChecked
                }
                .setPositiveButton(R.string.dialog_accept) { _, _ ->
                    for (i in functionStatus.indices) {
                        MyApp.context.prefs().edit {
                            put(
                                ConfigData.SET_FUNCTION_LIST_PREFS[functionList[i]]!!,
                                functionStatus[i]
                            )
                        }
                    }
                    binding.setTvDefFunctionStatus.text = functionList
                        .filter {
                            MyApp.context.prefs().get(ConfigData.SET_FUNCTION_LIST_PREFS[it]!!)
                        }
                        .toString()
                }
                .setNegativeButton(R.string.dialog_decline) { _, _ -> }
                .show()
        }
    }
}