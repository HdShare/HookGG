package me.hd.hookgg.ui.fragment.nav

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.PopupMenu
import androidx.lifecycle.ViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.hook.factory.prefs
import me.hd.hookgg.MyApp
import me.hd.hookgg.R
import me.hd.hookgg.config.data.BuildData
import me.hd.hookgg.config.data.HookerData
import me.hd.hookgg.config.data.SetPrefsData
import me.hd.hookgg.databinding.DialogEditPackageNameBinding
import me.hd.hookgg.databinding.FragmentSetPageBinding
import me.hd.hookgg.ui.fragment.base.FragmentBase
import java.util.Locale

class SetPageFragment : FragmentBase<FragmentSetPageBinding, ViewModel>(
    FragmentSetPageBinding::inflate
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        if (YukiHookAPI.Status.isModuleActive) {
            binding.setPageToolbar.subtitle = getString(R.string.module_active)
        }
        initPrefsDefVal()
        initPrefsOnClick()
    }

    private fun initPrefsDefVal() {
        val prefs = MyApp.context.prefs()
        binding.setTvDescAppVersion.text = getString(
            R.string.prefs_desc_app_version_fmt,
            BuildData.VERSION_NAME,
            BuildData.VERSION_CODE,
        )
        binding.setTvDescAppLanguage.text = when (prefs.get(SetPrefsData.APP_LANGUAGE)) {
            Locale.ENGLISH.language -> getString(R.string.language_en)
            Locale.CHINESE.language -> getString(R.string.language_zh)
            else -> getString(R.string.language_system)
        }
        binding.setTvDefPackageName.text = prefs.get(SetPrefsData.PACKAGE_NAME)
        binding.setTvDefVersionName.text = prefs.get(SetPrefsData.VERSION_NAME)
        binding.setSwitchPrintReturn.isChecked = prefs.get(SetPrefsData.PRINT_RETURN)
        binding.setSwitchFilterParams.isChecked = prefs.get(SetPrefsData.FILTER_PARAMS)
        binding.setSwitchTestFunc.isChecked = prefs.get(SetPrefsData.TEST_FUNC)
        binding.setSwitchTestFunc.isEnabled = BuildData.DEBUG
    }

    private fun initPrefsOnClick() {
        val prefs = MyApp.context.prefs()
        binding.setLLAppVersion.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/HdShare/HookGG/releases")
                )
            )
        }
        binding.setLLAppLanguage.setOnClickListener {
            fun changeLanguage(language: String) {
                prefs.edit {
                    put(SetPrefsData.APP_LANGUAGE, language)
                }
                requireActivity().recreate()
            }

            val popupMenu = PopupMenu(requireContext(), binding.setLLAppLanguageRight)
            popupMenu.menuInflater.inflate(R.menu.language_popup_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.language_system -> changeLanguage(Locale.ROOT.language)
                    R.id.language_en -> changeLanguage(Locale.ENGLISH.language)
                    R.id.language_zh -> changeLanguage(Locale.CHINESE.language)
                }
                true
            }
            popupMenu.show()
        }
        binding.setLLPackageName.setOnClickListener {
            val oldPackageName = prefs.get(SetPrefsData.PACKAGE_NAME)
            val dialogBinding = DialogEditPackageNameBinding.inflate(LayoutInflater.from(requireContext()))
            dialogBinding.textInputEditText.setText(oldPackageName)
            val dialog = MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.prefs_key_package_name)
                .setView(dialogBinding.root)
                .setPositiveButton(R.string.dialog_accept) { _, _ ->
                    val newPackageName = dialogBinding.textInputEditText.text.toString()
                    if (newPackageName.isNotEmpty()) {
                        prefs.edit {
                            put(SetPrefsData.PACKAGE_NAME, newPackageName)
                        }
                    }
                    binding.setTvDefPackageName.text = newPackageName
                }
                .setNegativeButton(R.string.dialog_decline) { _, _ -> }
                .create()
            dialogBinding.linearlayoutDefaultPackageName.apply {
                HookerData.defaultPackageNameMap.forEach { entry ->
                    addView(TextView(context).apply {
                        setPadding(20, 5, 0, 5)
                        movementMethod = LinkMovementMethod.getInstance()
                        text = SpannableStringBuilder("${entry.key} [${entry.value}]").apply {
                            setSpan(
                                object : ClickableSpan() {
                                    override fun onClick(widget: View) {
                                        val newPackageName = entry.value
                                        if (newPackageName.isNotEmpty()) {
                                            prefs.edit {
                                                put(SetPrefsData.PACKAGE_NAME, newPackageName)
                                            }
                                        }
                                        binding.setTvDefPackageName.text = newPackageName
                                        dialog.dismiss()
                                    }
                                },
                                0,
                                length,
                                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                        }
                    })
                }
            }
            dialog.show()
        }
        binding.setLLVersionName.setOnClickListener {
            val versionList = HookerData.getVersionList()
            val oldVersionName = prefs.get(SetPrefsData.VERSION_NAME)
            val oldVersionIndex = versionList.indexOf(oldVersionName)
            var newVersionIndex = oldVersionIndex
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.prefs_key_version_name)
                .setSingleChoiceItems(versionList, oldVersionIndex) { _, which ->
                    newVersionIndex = which
                }
                .setPositiveButton(R.string.dialog_accept) { _, _ ->
                    val newVersionName = versionList[newVersionIndex]
                    val newFunctionListSet = setOf<String>()
                    prefs.edit {
                        put(SetPrefsData.VERSION_NAME, newVersionName)
                        put(SetPrefsData.FUNC_LIST, newFunctionListSet)
                    }
                    binding.setTvDefVersionName.text = newVersionName
                }
                .setNegativeButton(R.string.dialog_decline) { _, _ -> }
                .show()
        }
        binding.setLLPrintReturn.setOnClickListener {
            binding.setSwitchPrintReturn.performClick()
        }
        binding.setSwitchPrintReturn.setOnClickListener {
            val oldPrintReturn = prefs.get(SetPrefsData.PRINT_RETURN)
            val newPrintReturn = !oldPrintReturn
            prefs.edit {
                put(SetPrefsData.PRINT_RETURN, newPrintReturn)
            }
            binding.setSwitchPrintReturn.isChecked = newPrintReturn
        }
        binding.setLLFilterParam.setOnClickListener {
            binding.setSwitchFilterParams.performClick()
        }
        binding.setSwitchFilterParams.setOnClickListener {
            val oldFilterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
            val newFilterParams = !oldFilterParams
            prefs.edit {
                put(SetPrefsData.FILTER_PARAMS, newFilterParams)
            }
            binding.setSwitchFilterParams.isChecked = newFilterParams
        }
        binding.setLLTestFunc.setOnClickListener {
            binding.setSwitchTestFunc.performClick()
        }
        binding.setSwitchTestFunc.setOnClickListener {
            val oldTestFunc = prefs.get(SetPrefsData.TEST_FUNC)
            val newTestFunc = !oldTestFunc
            prefs.edit {
                put(SetPrefsData.TEST_FUNC, newTestFunc)
            }
            binding.setSwitchTestFunc.isChecked = newTestFunc
        }
    }
}