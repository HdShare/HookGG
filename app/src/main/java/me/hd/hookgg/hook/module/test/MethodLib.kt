package me.hd.hookgg.hook.module.test

import luaj.LuaString
import luaj.LuaTable
import luaj.LuaValue
import luaj.Varargs
import luaj.lib.TwoArgFunction
import luaj.lib.VarArgFunction

class MethodLib : TwoArgFunction() {
    override fun call(modname: LuaValue, env: LuaValue): LuaValue {
        return LuaTable().also { methodTable ->
            methodTable.setmetatable(LuaTable().apply {
                set(LuaValue.INDEX, object : VarArgFunction() {
                    override fun call(table: LuaValue, value: LuaValue): LuaValue {
                        val methodName = value.checkjstring()
                        return HandleMethod(methodName)
                    }
                })
            })
            env["method"] = methodTable
            env["package"]["loaded"]["method"] = methodTable
        }
    }

    internal class HandleMethod(private val methodName: String) : VarArgFunction() {
        override fun invoke(args: Varargs): Varargs {
            return LuaString.valueOf("call method: $methodName $args")
        }
    }
}