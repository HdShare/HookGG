package me.hd.hookgg.hook.base

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.dataChannel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.data.SetPagePrefsData

abstract class BaseGGHooker : YukiBaseHooker() {
    protected val scope = CoroutineScope(Dispatchers.Default)

    protected fun sendLog(func: String, result: Any?) {
        val logReturn = prefs.get(SetPagePrefsData.LOG_RETURN)
        val log = "$func\n${if (logReturn) "--[[$result]]\n" else ""}"
        appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put("log", log)
    }
}