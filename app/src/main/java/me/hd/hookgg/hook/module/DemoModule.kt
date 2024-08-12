package me.hd.hookgg.hook.module

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.method
import luaj.Globals
import me.hd.hookgg.data.SetPrefsData
import me.hd.hookgg.hook.module.lib.Base64Lib

object DemoModule : YukiBaseHooker() {
    val moduleNameList = arrayOf(
        "base64",
    )

    override fun onHook() {
        "android.ext.Script".toClassOrNull()?.apply {
            method {
                name = "init"
                emptyParam()
            }.ignored().hook {
                after {
                    val moduleLibList = mapOf(
                        "base64" to Base64Lib(),
                    )
                    val globals = instance::class.java
                        .getDeclaredField("globals")
                        .apply { isAccessible = true }
                        .get(instance) as Globals
                    for (moduleLib in moduleLibList) {
                        prefs.get(SetPrefsData.MODULE_ENABLE_LIST).forEach { moduleEnableName ->
                            moduleLibList[moduleEnableName]?.let {
                                globals.load(it)
                            }
                        }
                    }
                }
            }
        }
    }
}