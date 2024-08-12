package me.hd.hookgg.hook.module.lib

import luaj.LuaTable
import luaj.LuaValue
import luaj.lib.OneArgFunction
import luaj.lib.TwoArgFunction
import me.hd.hookgg.hook.module.utils.Base64Util

class Base64Lib : TwoArgFunction() {
    override fun call(modname: LuaValue, env: LuaValue): LuaValue {
        return LuaTable().also { base64Table ->
            base64Table.set("help", help())
            base64Table.set("encode", encode())
            base64Table.set("decode", decode())
            env["base64"] = base64Table
            env["package"]["loaded"]["base64"] = base64Table
        }
    }

    internal class help : OneArgFunction() {
        override fun call(arg: LuaValue): LuaValue {
            val help = """
            Document:
                base64.encode(string) -> string
                base64.decode(string) -> string
            Example:
                base64.encode("hello") -> "aGVsbG8="
                base64.decode("aGVsbG8=") -> "hello"
            """.trimIndent()
            return LuaValue.valueOf(help)
        }
    }

    internal class encode : OneArgFunction() {
        override fun call(arg: LuaValue): LuaValue {
            val bytes = arg.checkjstring().toByteArray()
            val encodeStr = Base64Util.encode(bytes)
            return LuaValue.valueOf(encodeStr)
        }
    }

    internal class decode : OneArgFunction() {
        override fun call(arg: LuaValue): LuaValue {
            val bytes = Base64Util.decode(arg.checkjstring())
            val decodeStr = String(bytes)
            return LuaValue.valueOf(decodeStr)
        }
    }
}