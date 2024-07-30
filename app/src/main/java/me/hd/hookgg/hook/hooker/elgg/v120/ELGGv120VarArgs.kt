package me.hd.hookgg.hook.hooker.elgg.v120

import com.highcapable.yukihookapi.hook.type.java.IntType
import de.robv.android.xposed.XposedHelpers.callMethod
import me.hd.hookgg.hook.base.BaseGGVarArgs
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120Hooker.toClass

object ELGGv120VarArgs : BaseGGVarArgs {
    override fun Any?.arg(i: Int): Any {
        return callMethod(this, "c", i)
    }

    override fun Any?.optboolean(i: Int, defVal: Boolean): Any {
        return callMethod(this, "a", i, defVal) ?: defVal
    }

    override fun Any?.checkboolean(i: Int): Any {
        return callMethod(this, "k", i)
    }

    override fun Any?.optdouble(i: Int, defVal: Double): Any {
        return callMethod(this, "a", i, defVal) ?: defVal
    }

    override fun Any?.checkdouble(i: Int): Any {
        return callMethod(this, "m", i)
    }

    override fun Any?.optint(i: Int, defVal: Int): Any {
        return callMethod(this, "d", i, defVal) ?: defVal
    }

    override fun Any?.checkint(i: Int): Any {
        return callMethod(this, "o", i)
    }

    override fun Any?.optlong(i: Int, defVal: Long): Any {
        return callMethod(this, "a", i, defVal) ?: defVal
    }

    override fun Any?.checklong(i: Int): Any {
        return callMethod(this, "p", i)
    }

    override fun Any?.optjstring(i: Int, defVal: String): Any {
        return callMethod(this, "c", i, defVal) ?: defVal
    }

    override fun Any?.tojstring(i: Int): Any {
        return callMethod(this, "y", i)
    }

    override fun Any?.checkjstring(i: Int): Any {
        return callMethod(this, "r", i)
    }

    override fun Any?.optstring(i: Int, defVal: Any?): Any {
        val clazz = "luaj.LuaString".toClass()
        val parameterTypes = arrayOf(IntType, clazz)
        return callMethod(this, "a", parameterTypes, i, defVal) ?: "nil"
    }

    override fun Any?.checkstring(i: Int): Any {
        return callMethod(this, "s", i)
    }

    override fun Any?.opttable(i: Int, defVal: Any?): Any {
        val clazz = "luaj.LuaTable".toClass()
        val parameterTypes = arrayOf(IntType, clazz)
        return callMethod(this, "a", parameterTypes, i, defVal) ?: "{}"
    }

    override fun Any?.checktable(i: Int): Any {
        return callMethod(this, "t", i)
    }
}