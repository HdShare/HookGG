package me.hd.hookgg.hook.module.lib

import luaj.LuaTable
import luaj.LuaValue
import luaj.lib.OneArgFunction
import luaj.lib.TwoArgFunction

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
            return LuaValue.valueOf(arg.checkjstring().lowercase())
        }
    }

    internal class toUpper : OneArgFunction() {
        override fun call(arg: LuaValue): LuaValue {
            return LuaValue.valueOf(arg.checkjstring().uppercase())
        }
    }
}