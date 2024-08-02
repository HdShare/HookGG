package me.hd.hookgg.hook.base

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.dataChannel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.data.SetPrefsData

abstract class BaseGGHooker : YukiBaseHooker() {
    protected val scope = CoroutineScope(Dispatchers.Default)

    protected fun sendLog(func: String, result: Any?) {
        val printReturn = prefs.get(SetPrefsData.PRINT_RETURN)
        val log = "$func\n${if (printReturn) "--[[$result]]\n" else ""}"
        appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put("log", log)
    }

    abstract val functionMap: Map<String, () -> Unit>

    override fun onHook() {
        val setFuncList = prefs.get(SetPrefsData.FUNCTION_LIST)
        setFuncList.forEach { function ->
            functionMap[function]?.invoke()
        }
    }
}