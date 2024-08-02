package me.hd.hookgg.hook.module

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.method
import luaj.Globals
import luaj.LuaTable
import luaj.LuaValue
import luaj.lib.OneArgFunction
import luaj.lib.TwoArgFunction
import java.util.Locale

class TestLib : TwoArgFunction() {
    override fun call(modname: LuaValue, env: LuaValue): LuaValue {
        return LuaTable().also { testTable ->
            testTable.set("toLower", toLower())
            testTable.set("toUpper", toUpper())
            env["test"] = testTable
            if (env["package"].isnil().not()) {
                env["package"]["loaded"].set("test", testTable)
            }
        }
    }

    internal class toLower : OneArgFunction() {
        override fun call(arg: LuaValue): LuaValue {
            return LuaValue.valueOf(arg.checkjstring().lowercase(Locale.getDefault()))
        }
    }

    internal class toUpper : OneArgFunction() {
        override fun call(arg: LuaValue): LuaValue {
            return LuaValue.valueOf(arg.checkjstring().uppercase(Locale.getDefault()))
        }
    }
}

object DemoModule : YukiBaseHooker() {
    override fun onHook() {
        "android.ext.Script".toClassOrNull()?.apply {
            method {
                name = "init"
                emptyParam()
            }.ignored().hook {
                after {
                    val field = instance::class.java
                        .declaredFields
                        .first { it.name == "globals" }
                        .apply { isAccessible = true }
                    val globals = field.get(instance) as Globals
                    globals.load(TestLib())
                }
            }
        }
    }
}