package me.hd.hookgg.hook.module.lib

import luaj.LuaString
import luaj.LuaTable
import luaj.LuaValue
import luaj.Varargs
import luaj.lib.TwoArgFunction
import luaj.lib.VarArgFunction

class MethodLib : TwoArgFunction() {
    override fun call(modname: LuaValue, env: LuaValue): LuaValue {
        return LuaTable().also { testTable ->
            testTable.setmetatable(LuaTable().apply {
                set(LuaValue.INDEX, object : VarArgFunction() {
                    override fun call(table: LuaValue, value: LuaValue): LuaValue {
                        val methodName = value.checkjstring()
                        return HandleMethod(methodName)
                    }
                })
            })
            env["method"] = testTable
            if (env["package"].isnil().not()) {
                env["package"]["loaded"].set("method", testTable)
            }
        }
    }

    internal class HandleMethod(private val methodName: String) : VarArgFunction() {
        override fun invoke(args: Varargs): Varargs {
            return LuaString.valueOf("call method: $methodName $args")
        }
    }
}