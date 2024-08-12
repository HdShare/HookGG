package me.hd.hookgg.hook.module

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.method
import luaj.Globals
import luaj.lib.LibFunction
import me.hd.hookgg.hook.module.lib.MethodLib
import me.hd.hookgg.hook.module.lib.TestLib

object DemoModule : YukiBaseHooker() {
    private val modules: Array<LibFunction> = arrayOf(
        TestLib(),
        MethodLib(),
    )

    override fun onHook() {
        "android.ext.Script".toClassOrNull()?.apply {
            method {
                name = "init"
                emptyParam()
            }.ignored().hook {
                after {
                    val globals = instance::class.java
                        .getDeclaredField("globals")
                        .apply { isAccessible = true }
                        .get(instance) as Globals
                    for (module in modules) {
                        globals.load(module)
                    }
                }
            }
        }
    }
}