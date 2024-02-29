package me.hd.hookgg.hook.hooker

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.dataChannel
import com.highcapable.yukihookapi.hook.factory.method
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.data.ConfigData

object GG960Hooker : YukiBaseHooker() {
    override fun onHook() {
        if (prefs.get(ConfigData.SET_FUNCTION_LIST_PREFS["searchNumber"]!!, false)) {
            hookSearchNumber()
        }
    }

    private fun hookSearchNumber() {
        "android.ext.Script\$searchNumber".toClassOrNull()?.apply {
            method {
                name = "invokeUi"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varargs = args[0]!!
                    "luaj.Varargs".toClassOrNull()?.apply {
                        val input = method { name = "checkjstring" }.get(varargs)
                            .string(1)
                        val flags = method { name = "optint" }.get(varargs)
                            .int(2, 127)
                        val valueEncrypted = method { name = "optboolean" }.get(varargs)
                            .boolean(3, false)
                        val sign = method { name = "optint" }.get(varargs)
                            .int(4, 0x20000000)
                        val memoryFrom = method { name = "optlong" }.get(varargs)
                            .long(5, 0L)
                        val memoryTo = method { name = "optlong" }.get(varargs)
                            .long(6, -1L)
                        val log =
                            "gg.searchNumber(\"$input\",$flags,$valueEncrypted,$sign,$memoryFrom,$memoryTo)"
                        appContext
                            ?.dataChannel(BuildConfig.APPLICATION_ID)
                            ?.put(key = "log", value = log)
                    }
                }
            }
        }
    }
}