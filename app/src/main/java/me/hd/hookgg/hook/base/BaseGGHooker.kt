package me.hd.hookgg.hook.base

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.dataChannel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import me.hd.hookgg.config.data.BuildData
import me.hd.hookgg.config.data.SetPrefsData
import me.hd.hookgg.config.bean.FuncDetail

abstract class BaseGGHooker : YukiBaseHooker() {
    protected var filterParams = false
    protected var printReturn = false

    protected fun sendLog(func: String, result: String) {
        runBlocking {
            CoroutineScope(Dispatchers.Default).async {
                appContext?.dataChannel(BuildData.APPLICATION_ID)?.apply {
                    put("log", func)
                    put("log", "$result\n")
                }
            }.await()
        }
    }

    abstract val functionMap: Map<String, FuncDetail>

    override fun onHook() {
        filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
        printReturn = prefs.get(SetPrefsData.PRINT_RETURN)
        prefs.get(SetPrefsData.FUNC_LIST).forEach { function ->
            functionMap[function]?.funcListener?.invoke()
        }
    }
}