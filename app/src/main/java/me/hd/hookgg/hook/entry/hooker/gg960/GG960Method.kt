package me.hd.hookgg.hook.entry.hooker.gg960

import de.robv.android.xposed.XposedHelpers.callMethod
import me.hd.hookgg.hook.entry.base.BaseMethod

object GG960Method : BaseMethod {
    override fun Any?.optboolean(i: Int, defVal: Boolean): Any {
        return callMethod(this, "optboolean", i, defVal)
    }

    override fun Any?.checkboolean(i: Int): Any {
        return callMethod(this, "checkboolean", i)
    }

    override fun Any?.optdouble(i: Int, defVal: Double): Any {
        return callMethod(this, "optdouble", i, defVal)
    }

    override fun Any?.checkdouble(i: Int): Any {
        return callMethod(this, "checkdouble", i)
    }

    override fun Any?.optfunction(i: Int, defVal: Any?): Any {
        return callMethod(this, "optfunction", i, defVal)
    }

    override fun Any?.checkfunction(i: Int): Any {
        return callMethod(this, "checkfunction", i)
    }

    override fun Any?.optint(i: Int, defVal: Int): Any {
        return callMethod(this, "optint", i, defVal)
    }

    override fun Any?.checkint(i: Int): Any {
        return callMethod(this, "checkint", i)
    }

    override fun Any?.optlong(i: Int, defVal: Long): Any {
        return callMethod(this, "optlong", i, defVal)
    }

    override fun Any?.checklong(i: Int): Any {
        return callMethod(this, "checklong", i)
    }

    override fun Any?.optjstring(i: Int, defVal: String): Any {
        return callMethod(this, "optjstring", i, defVal)
    }

    override fun Any?.checkjstring(i: Int): Any {
        return callMethod(this, "checkjstring", i)
    }

    override fun Any?.optstring(i: Int, defVal: Any?): Any {
        return callMethod(this, "optstring", i, defVal)
    }

    override fun Any?.checkstring(i: Int): Any {
        return callMethod(this, "checkstring", i)
    }

    override fun Any?.opttable(i: Int, defVal: Any?): Any {
        return callMethod(this, "opttable", i, defVal)
    }

    override fun Any?.checktable(i: Int): Any {
        return callMethod(this, "checktable", i)
    }
}