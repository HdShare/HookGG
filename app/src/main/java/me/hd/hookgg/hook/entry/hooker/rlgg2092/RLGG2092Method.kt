package me.hd.hookgg.hook.entry.hooker.rlgg2092

import de.robv.android.xposed.XposedHelpers
import me.hd.hookgg.hook.entry.base.BaseMethod
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Hooker.toClass

object RLGG2092Method : BaseMethod {
    override fun Any?.optboolean(i: Int, defVal: Boolean): Any {
        val clazz = "rlgg.draw.ۣۢۧۢ".toClass()
        return XposedHelpers.callStaticMethod(clazz, "۟ۧۢۡۦ", this, i, defVal)
    }

    override fun Any?.checkboolean(i: Int): Any {
        val clazz = "".toClass()
        return XposedHelpers.callStaticMethod(clazz, "", this, i)
    }

    override fun Any?.optdouble(i: Int, defVal: Double): Any {
        val clazz = "".toClass()
        return XposedHelpers.callStaticMethod(clazz, "", this, i, defVal)
    }

    override fun Any?.checkdouble(i: Int): Any {
        val clazz = "".toClass()
        return XposedHelpers.callStaticMethod(clazz, "", this, i)
    }

    override fun Any?.optfunction(i: Int, defVal: Any): Any {
        val clazz = "".toClass()
        return XposedHelpers.callStaticMethod(clazz, "", this, i, defVal)
    }

    override fun Any?.checkfunction(i: Int): Any {
        val clazz = "".toClass()
        return XposedHelpers.callStaticMethod(clazz, "", this, i)
    }

    override fun Any?.optint(i: Int, defVal: Int): Any {
        val clazz = "np.dcc.ۣ۟ۢۤۢ".toClass()
        return XposedHelpers.callStaticMethod(clazz, "۟۟ۧ۟ۦ", this, i, defVal)
    }

    override fun Any?.checkint(i: Int): Any {
        val clazz = "۟.ۣۡۨ۠".toClass()
        return XposedHelpers.callStaticMethod(clazz, "۟ۧۡۥ۟", this, i)
    }

    override fun Any?.optlong(i: Int, defVal: Long): Any {
        val clazz = "۟.lib.jse.ۤۦۢ".toClass()
        return XposedHelpers.callStaticMethod(clazz, "۟ۧۧۢ", this, i, defVal)
    }

    override fun Any?.checklong(i: Int): Any {
        val clazz = "".toClass()
        return XposedHelpers.callStaticMethod(clazz, "", this, i)
    }

    override fun Any?.optjstring(i: Int, defVal: String): Any {
        val clazz = "۟.a.۟ۧ۟ۡۤ".toClass()
        return XposedHelpers.callStaticMethod(clazz, "۟۠ۦۣۢ", this, i, defVal)
    }

    override fun Any?.checkjstring(i: Int): Any {
        val clazz = "android.fix.ۣۣۤۧ".toClass()
        return XposedHelpers.callStaticMethod(clazz, "ۥ۟۠۟", this, i)
    }

    override fun Any?.optstring(i: Int, defVal: Any): Any {
        val clazz = "android.ext.۟ۡۥۤ".toClass()
        return XposedHelpers.callStaticMethod(clazz, "ۣۦۦۥ", this, i, defVal)
    }

    override fun Any?.checkstring(i: Int): Any {
        val clazz = "".toClass()
        return XposedHelpers.callStaticMethod(clazz, "", this, i)
    }

    override fun Any?.opttable(i: Int, defVal: Any): Any {
        val clazz = "np.dcc.ۣ۟ۢۤۢ".toClass()
        return XposedHelpers.callStaticMethod(clazz, "۟ۧۥ۟ۢ", this, i, defVal)
    }

    override fun Any?.checktable(i: Int): Any {
        val clazz = "np.۟ۧۦۡۤ".toClass()
        return XposedHelpers.callStaticMethod(clazz, "۟ۥ۟ۥۢ", this, i)
    }
}