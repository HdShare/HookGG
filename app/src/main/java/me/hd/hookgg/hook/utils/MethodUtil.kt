package me.hd.hookgg.hook.utils

import de.robv.android.xposed.XposedHelpers.callMethod

object MethodUtil {

    fun Any?.optboolean(i: Int, defVal: Boolean): Any {
        return callMethod(this, "optboolean", i, defVal)
    }

    fun Any?.checkboolean(i: Int): Any {
        return callMethod(this, "checkboolean", i)
    }

    fun Any?.optdouble(i: Int, defVal: Double): Any {
        return callMethod(this, "optdouble", i, defVal)
    }

    fun Any?.checkdouble(i: Int): Any {
        return callMethod(this, "checkdouble", i)
    }

    fun Any?.optfunction(i: Int, defVal: Any): Any {
        return callMethod(this, "optfunction", i, defVal)
    }

    fun Any?.checkfunction(i: Int): Any {
        return callMethod(this, "checkfunction", i)
    }

    fun Any?.optint(i: Int, defVal: Int): Any {
        return callMethod(this, "optint", i, defVal)
    }

    fun Any?.checkint(i: Int): Any {
        return callMethod(this, "checkint", i)
    }

    fun Any?.optinteger(i: Int, defVal: Any): Any {
        return callMethod(this, "optinteger", i, defVal)
    }

    fun Any?.checkinteger(i: Int): Any {
        return callMethod(this, "checkinteger", i)
    }

    fun Any?.optlong(i: Int, defVal: Long): Any {
        return callMethod(this, "optlong", i, defVal)
    }

    fun Any?.checklong(i: Int): Any {
        return callMethod(this, "checklong", i)
    }

    fun Any?.optnumber(i: Int, defVal: Any): Any {
        return callMethod(this, "optnumber", i, defVal)
    }

    fun Any?.checknumber(i: Int): Any {
        return callMethod(this, "checknumber", i)
    }

    fun Any?.optjstring(i: Int, defVal: String?): Any {
        return callMethod(this, "optjstring", i, defVal)
    }

    fun Any?.checkjstring(i: Int): Any {
        return callMethod(this, "checkjstring", i)
    }

    fun Any?.optstring(i: Int, defVal: Any): Any {
        return callMethod(this, "optstring", i, defVal)
    }

    fun Any?.checkstring(i: Int): Any {
        return callMethod(this, "checkstring", i)
    }

    fun Any?.opttable(i: Int, defVal: Any): Any {
        return callMethod(this, "opttable", i, defVal)
    }

    fun Any?.checktable(i: Int): Any {
        return callMethod(this, "checktable", i)
    }

}