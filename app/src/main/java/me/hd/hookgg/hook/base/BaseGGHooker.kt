package me.hd.hookgg.hook.base

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.dataChannel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.data.SetPrefsData

abstract class BaseGGHooker : YukiBaseHooker() {
    protected val scope = CoroutineScope(Dispatchers.Default)

    protected fun sendLog(func: String, result: Any? = null) {
        runBlocking {
            scope.async {
                val printReturn = prefs.get(SetPrefsData.PRINT_RETURN)
                val log = "$func\n${if (result != null && printReturn) "--[[$result]]\n" else ""}"
                appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put("log", log)
            }.await()
        }
    }

    abstract val functionMap: Map<String, () -> Unit>

    override fun onHook() {
        val setFuncList = prefs.get(SetPrefsData.FUNC_LIST)
        setFuncList.forEach { function ->
            functionMap[function]?.invoke()
        }
    }
}