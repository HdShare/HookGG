package me.hd.hookgg.ui.fragment.nav

import android.view.LayoutInflater
import androidx.lifecycle.ViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.hook.factory.prefs
import me.hd.hookgg.MyApp
import me.hd.hookgg.R
import me.hd.hookgg.data.AppData
import me.hd.hookgg.data.SetPagePrefsData
import me.hd.hookgg.databinding.DialogEditPackageNameBinding
import me.hd.hookgg.databinding.FragmentSetPageBinding
import me.hd.hookgg.ui.fragment.base.BaseFragment

class SetPageFragment : BaseFragment<FragmentSetPageBinding, ViewModel>(
    FragmentSetPageBinding::inflate,
    null
) {
    override fun initFragment(binding: FragmentSetPageBinding, viewModel: ViewModel?) {
        initView(binding)
    }

    private fun initView(binding: FragmentSetPageBinding) {
        if (YukiHookAPI.Status.isModuleActive) {
            binding.setPageToolbar.subtitle = getString(R.string.module_active)
        }
        initPrefsDefVal(binding)
        initPrefsOnClick(binding)
    }

    private fun initPrefsDefVal(binding: FragmentSetPageBinding) {
        val prefs = MyApp.context.prefs()
        binding.setTvDefPackageName.text = prefs.get(SetPagePrefsData.PACKAGE_NAME)
        binding.setTvDefVersionName.text = prefs.get(SetPagePrefsData.VERSION_NAME)
        binding.setTvDefFunctionList.text = prefs.get(SetPagePrefsData.FUNCTION_LIST).toString()
    }

    private fun initPrefsOnClick(binding: FragmentSetPageBinding) {
        val prefs = MyApp.context.prefs()
        binding.setLLPackageName.setOnClickListener {
            val oldPackageName = prefs.get(SetPagePrefsData.PACKAGE_NAME)
            val dialogBinding =
                DialogEditPackageNameBinding.inflate(LayoutInflater.from(requireContext()))
            dialogBinding.textInputEditText.setText(oldPackageName)
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.prefs_key_package_name)
                .setView(dialogBinding.root)
                .setPositiveButton(R.string.dialog_accept) { _, _ ->
                    val newPackageName = dialogBinding.textInputEditText.text.toString()
                    if (newPackageName.isNotEmpty()) {
                        prefs.edit {
                            put(SetPagePrefsData.PACKAGE_NAME, newPackageName)
                        }
                    }
                    binding.setTvDefPackageName.text = newPackageName
                }
                .setNegativeButton(R.string.dialog_decline) { _, _ -> }
                .show()
        }
        binding.setLLVersionName.setOnClickListener {
            val versionList = AppData.VERSION_LIST
            val oldVersionName = prefs.get(SetPagePrefsData.VERSION_NAME)
            val oldVersionIndex = versionList.indexOf(oldVersionName)
            var newVersionIndex = oldVersionIndex
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.prefs_key_version_name)
                .setSingleChoiceItems(versionList, oldVersionIndex) { _, which ->
                    newVersionIndex = which
                }
                .setPositiveButton(R.string.dialog_accept) { _, _ ->
                    val newVersionName = versionList[newVersionIndex]
                    prefs.edit {
                        put(SetPagePrefsData.VERSION_NAME, newVersionName)
                    }
                    binding.setTvDefVersionName.text = newVersionName
                }
                .setNegativeButton(R.string.dialog_decline) { _, _ -> }
                .show()
        }
        binding.setLLFunctionList.setOnClickListener {
            val functionList = AppData.FUNCTION_LIST
            val oldFunctionList = prefs.get(SetPagePrefsData.FUNCTION_LIST)
            val oldFunctionStatus = BooleanArray(functionList.size) {
                functionList[it] in oldFunctionList
            }
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.prefs_key_function_list)
                .setMultiChoiceItems(functionList, oldFunctionStatus) { _, which, isChecked ->
                    oldFunctionStatus[which] = isChecked
                }
                .setPositiveButton(R.string.dialog_accept) { _, _ ->
                    val newFunctionListSet = functionList.filterIndexed { index, _ ->
                        oldFunctionStatus[index]
                    }.toSet()
                    prefs.edit {
                        put(SetPagePrefsData.FUNCTION_LIST, newFunctionListSet)
                    }
                    binding.setTvDefFunctionList.text = newFunctionListSet.toString()
                }
                .setNegativeButton(R.string.dialog_decline) { _, _ -> }
                .show()
        }
    }
}