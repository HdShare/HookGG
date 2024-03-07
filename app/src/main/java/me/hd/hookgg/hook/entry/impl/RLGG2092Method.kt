package me.hd.hookgg.hook.entry.impl

import de.robv.android.xposed.XposedHelpers
import me.hd.hookgg.hook.entry.base.BaseMethod
import me.hd.hookgg.hook.entry.hooker.RLGG2092Hooker.toClassOrNull

object RLGG2092Method : BaseMethod {
    override fun Any?.optboolean(i: Int, defVal: Boolean): Any {
        val clazz = "rlgg.draw.ۣۢۧۢ".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "۟ۧۢۡۦ", this, i, defVal)
    }

    override fun Any?.checkboolean(i: Int): Any {
        val clazz = "".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "", this, i)
    }

    override fun Any?.optdouble(i: Int, defVal: Double): Any {
        val clazz = "".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "", this, i, defVal)
    }

    override fun Any?.checkdouble(i: Int): Any {
        val clazz = "".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "", this, i)
    }

    override fun Any?.optfunction(i: Int, defVal: Any): Any {
        val clazz = "".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "", this, i, defVal)
    }

    override fun Any?.checkfunction(i: Int): Any {
        val clazz = "".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "", this, i)
    }

    override fun Any?.optint(i: Int, defVal: Int): Any {
        val clazz = "np.dcc.ۣ۟ۢۤۢ".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "۟۟ۧ۟ۦ", this, i, defVal)
    }

    override fun Any?.checkint(i: Int): Any {
        val clazz = "۟.ۣۡۨ۠".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "۟ۧۡۥ۟", this, i)
    }

    override fun Any?.optlong(i: Int, defVal: Long): Any {
        val clazz = "۟.lib.jse.ۤۦۢ".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "۟ۧۧۢ", this, i, defVal)
    }

    override fun Any?.checklong(i: Int): Any {
        val clazz = "".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "", this, i)
    }

    override fun Any?.optjstring(i: Int, defVal: String): Any {
        val clazz = "۟.a.۟ۧ۟ۡۤ".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "۟۠ۦۣۢ", this, i, defVal)
    }

    override fun Any?.checkjstring(i: Int): Any {
        val clazz = "android.fix.ۣۣۤۧ".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "ۥ۟۠۟", this, i)
    }

    override fun Any?.optstring(i: Int, defVal: String): Any {
        val clazz = "".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "", this, i, defVal)
    }

    override fun Any?.checkstring(i: Int): Any {
        val clazz = "".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "", this, i)
    }

    override fun Any?.opttable(i: Int, defVal: Any): Any {
        val clazz = "".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "", this, i, defVal)
    }

    override fun Any?.checktable(i: Int): Any {
        val clazz = "np.۟ۧۦۡۤ".toClassOrNull()
        return XposedHelpers.callStaticMethod(clazz, "۟ۥ۟ۥۢ", this, i)
    }
}