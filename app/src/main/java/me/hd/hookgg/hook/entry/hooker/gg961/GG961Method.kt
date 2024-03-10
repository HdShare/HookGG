package me.hd.hookgg.hook.entry.hooker.gg961

import de.robv.android.xposed.XposedHelpers
import me.hd.hookgg.hook.entry.base.BaseMethod

object GG961Method : BaseMethod {
    override fun Any?.optboolean(i: Int, defVal: Boolean): Any {
        return XposedHelpers.callMethod(this, "a", i, defVal)
    }

    override fun Any?.checkboolean(i: Int): Any {
        return XposedHelpers.callMethod(this, "k", i)
    }

    override fun Any?.optdouble(i: Int, defVal: Double): Any {
        return XposedHelpers.callMethod(this, "a", i, defVal)
    }

    override fun Any?.checkdouble(i: Int): Any {
        return XposedHelpers.callMethod(this, "m", i)
    }

    override fun Any?.optfunction(i: Int, defVal: Any): Any {
        return XposedHelpers.callMethod(this, "a", i, defVal)
    }

    override fun Any?.checkfunction(i: Int): Any {
        return XposedHelpers.callMethod(this, "n", i)
    }

    override fun Any?.optint(i: Int, defVal: Int): Any {
        return XposedHelpers.callMethod(this, "d", i, defVal)
    }

    override fun Any?.checkint(i: Int): Any {
        return XposedHelpers.callMethod(this, "o", i)
    }

    override fun Any?.optlong(i: Int, defVal: Long): Any {
        return XposedHelpers.callMethod(this, "a", i, defVal)
    }

    override fun Any?.checklong(i: Int): Any {
        return XposedHelpers.callMethod(this, "p", i)
    }

    override fun Any?.optjstring(i: Int, defVal: String): Any {
        return XposedHelpers.callMethod(this, "c", i, defVal)
    }

    override fun Any?.checkjstring(i: Int): Any {
        return XposedHelpers.callMethod(this, "r", i)
    }

    override fun Any?.optstring(i: Int, defVal: Any): Any {
        return XposedHelpers.callMethod(this, "a", i, defVal)
    }

    override fun Any?.checkstring(i: Int): Any {
        return XposedHelpers.callMethod(this, "s", i)
    }

    override fun Any?.opttable(i: Int, defVal: Any): Any {
        return XposedHelpers.callMethod(this, "a", i, defVal)
    }

    override fun Any?.checktable(i: Int): Any {
        return XposedHelpers.callMethod(this, "t", i)
    }
}