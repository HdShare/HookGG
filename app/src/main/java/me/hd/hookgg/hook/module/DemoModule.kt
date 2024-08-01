package me.hd.hookgg.hook.module

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.classOf
import com.highcapable.yukihookapi.hook.factory.method
import luaj.LuaValue
import luaj.lib.StringLib
import luaj.lib.ZeroArgFunction

class MyStringLib {
    class test : ZeroArgFunction() {
        override fun call(): LuaValue {
            return LuaValue.valueOf("测试")
        }
    }
}

object DemoModule : YukiBaseHooker() {
    override fun onHook() {
        StringLib::class.java.apply {
            method {
                name = "call"
                param(classOf<LuaValue>(), classOf<LuaValue>())
            }.ignored().hook {
                after {
                    val luaValue = result as LuaValue
                    luaValue.set("test", MyStringLib.test())
                }
            }
        }
    }
}