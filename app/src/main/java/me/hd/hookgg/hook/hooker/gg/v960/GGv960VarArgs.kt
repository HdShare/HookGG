package me.hd.hookgg.hook.hooker.gg.v960

import com.highcapable.yukihookapi.hook.type.java.IntType
import de.robv.android.xposed.XposedHelpers.callMethod
import me.hd.hookgg.hook.base.BaseGGVarArgs
import me.hd.hookgg.hook.hooker.gg.v960.GGv960Hooker.toClass

object GGv960VarArgs : BaseGGVarArgs {
    override fun Any?.arg(i: Int): Any {
        return callMethod(this, "arg", i)
    }

    fun Any?.narg(): Any {
        return callMethod(this, "narg")
    }

    override fun Any?.optboolean(i: Int, defVal: Boolean): Any {
        return callMethod(this, "optboolean", i, defVal) ?: defVal
    }

    override fun Any?.checkboolean(i: Int): Any {
        return callMethod(this, "checkboolean", i)
    }

    override fun Any?.optdouble(i: Int, defVal: Double): Any {
        return callMethod(this, "optdouble", i, defVal) ?: defVal
    }

    override fun Any?.checkdouble(i: Int): Any {
        return callMethod(this, "checkdouble", i)
    }

    override fun Any?.optint(i: Int, defVal: Int): Any {
        return callMethod(this, "optint", i, defVal) ?: defVal
    }

    override fun Any?.checkint(i: Int): Any {
        return callMethod(this, "checkint", i)
    }

    override fun Any?.optlong(i: Int, defVal: Long): Any {
        return callMethod(this, "optlong", i, defVal) ?: defVal
    }

    override fun Any?.checklong(i: Int): Any {
        return callMethod(this, "checklong", i)
    }

    override fun Any?.optjstring(i: Int, defVal: String): Any {
        return callMethod(this, "optjstring", i, defVal) ?: defVal
    }

    override fun Any?.tojstring(i: Int): Any {
        return callMethod(this, "tojstring", i)
    }

    override fun Any?.checkjstring(i: Int): Any {
        return callMethod(this, "checkjstring", i)
    }

    override fun Any?.optstring(i: Int, defVal: Any?): Any {
        val clazz = "luaj.LuaString".toClass()
        val parameterTypes = arrayOf(IntType, clazz)
        return callMethod(this, "optstring", parameterTypes, i, defVal) ?: "nil"
    }

    override fun Any?.checkstring(i: Int): Any {
        return callMethod(this, "checkstring", i)
    }

    override fun Any?.opttable(i: Int, defVal: Any?): Any {
        val clazz = "luaj.LuaTable".toClass()
        val parameterTypes = arrayOf(IntType, clazz)
        return callMethod(this, "opttable", parameterTypes, i, defVal) ?: "{}"
    }

    override fun Any?.checktable(i: Int): Any {
        return callMethod(this, "checktable", i)
    }
}