package me.hd.hookgg.config.data

import com.highcapable.yukihookapi.hook.xposed.prefs.data.PrefsData

object SetPrefsData {
    val APP_LANGUAGE = PrefsData("app_language", "")
    val PACKAGE_NAME = PrefsData("package_name", "")
    val VERSION_NAME = PrefsData("version_name", "")
    val PRINT_RETURN = PrefsData("print_return", false)
    val FILTER_PARAMS = PrefsData("filter_Params", false)
    val TEST_FUNC = PrefsData("test_func", false)
    val FUNC_LIST = PrefsData("func_list", setOf<String>())
}