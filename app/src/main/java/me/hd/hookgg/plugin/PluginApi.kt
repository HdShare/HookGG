package me.hd.hookgg.plugin

import com.highcapable.yukihookapi.hook.log.YLog

object PluginApi {
    @JvmStatic
    fun log1(str: String) {
        YLog.error("log1 -> $str")
    }

    @JvmStatic
    fun log2(str: String) {
        YLog.error("log2 -> $str")
    }
}