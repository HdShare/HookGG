package me.hd.hookgg.hook.module

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.method
import luaj.Globals
import me.hd.hookgg.hook.module.lib.MethodLib
import me.hd.hookgg.hook.module.lib.TestLib

object DemoModule : YukiBaseHooker() {
    override fun onHook() {
        "android.ext.Script".toClassOrNull()?.apply {
            method {
                name = "init"
                emptyParam()
            }.ignored().hook {
                after {
                    val field = instance::class.java
                        .getDeclaredField("globals")
                        .apply { isAccessible = true }
                    val globals = field.get(instance) as Globals
                    globals.load(TestLib())
                    globals.load(MethodLib())
                }
            }
        }
    }
}