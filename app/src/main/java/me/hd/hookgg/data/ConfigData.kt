package me.hd.hookgg.data

import com.highcapable.yukihookapi.hook.xposed.prefs.data.PrefsData

object ConfigData {

    val SET_PACKAGE_NAME = PrefsData("set_package_name", "")

    val SET_FUNCTION_LIST = arrayOf("searchNumber")
    val SET_FUNCTION_LIST_PREFS = SET_FUNCTION_LIST.associateBy({ it }, { PrefsData(it, false) })

}