package me.hd.hookgg.hook.hooker.gg.v960

import de.robv.android.xposed.XposedHelpers.callMethod

object GGv960LuaValue {
    fun Any?.toboolean(): Any {
        return callMethod(this, "toboolean")
    }

    fun Any?.checkstring(): Any {
        return callMethod(this, "checkstring")
    }

    fun Any?.length(): Any {
        return callMethod(this, "length")
    }
}