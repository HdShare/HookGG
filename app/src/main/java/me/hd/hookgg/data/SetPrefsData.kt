package me.hd.hookgg.data

import com.highcapable.yukihookapi.hook.xposed.prefs.data.PrefsData

object SetPrefsData {
    val PACKAGE_NAME = PrefsData("package_name", "")
    val VERSION_NAME = PrefsData("version_name", "")
    val FUNCTION_LIST = PrefsData("function_list", setOf<String>())
    val LOG_RETURN = PrefsData("log_return", false)
    val FILTER_PARAMS = PrefsData("filter_Params", false)
    val MODULE_FUNC = PrefsData("module_func", false)
    val TEST_FUNC = PrefsData("test_func", false)
}