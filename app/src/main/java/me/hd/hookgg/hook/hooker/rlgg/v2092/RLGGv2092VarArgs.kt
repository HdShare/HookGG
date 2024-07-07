package me.hd.hookgg.hook.hooker.rlgg.v2092

import de.robv.android.xposed.XposedHelpers.callStaticMethod
import me.hd.hookgg.hook.base.BaseGGVarArgs
import me.hd.hookgg.hook.hooker.rlgg.v2092.RLGGv2092Hooker.toClass

object RLGGv2092VarArgs : BaseGGVarArgs {
    override fun Any?.arg(i: Int): Any {
        val clazz = "۟.lib.jse.ۤۦۢ".toClass()
        return callStaticMethod(clazz, "۠ۧۤۨ", this, i)
    }

    override fun Any?.optboolean(i: Int, defVal: Boolean): Any {
        val clazz = "rlgg.draw.ۣۢۧۢ".toClass()
        return callStaticMethod(clazz, "۟ۧۢۡۦ", this, i, defVal) ?: defVal
    }

    override fun Any?.checkboolean(i: Int): Any {
        val clazz = "۟.a.ۣۡ۟ۤ".toClass()
        return callStaticMethod(clazz, "ۨۥۨۤ", this, i)
    }

    override fun Any?.optdouble(i: Int, defVal: Double): Any {
        val clazz = "rlyun.modules.base.ۨۥۧ۠".toClass()
        return callStaticMethod(clazz, "ۤۤۡ۠", this, i, defVal) ?: defVal
    }

    override fun Any?.checkdouble(i: Int): Any {
        val clazz = "android.ext.۟ۡۥۤ".toClass()
        return callStaticMethod(clazz, "ۡ۟ۦۤ", this, i)
    }

    override fun Any?.optint(i: Int, defVal: Int): Any {
        val clazz = "np.dcc.ۣ۟ۢۤۢ".toClass()
        return callStaticMethod(clazz, "۟۟ۧ۟ۦ", this, i, defVal) ?: defVal
    }

    override fun Any?.checkint(i: Int): Any {
        val clazz = "۟.ۣۡۨ۠".toClass()
        return callStaticMethod(clazz, "۟ۧۡۥ۟", this, i)
    }

    override fun Any?.optlong(i: Int, defVal: Long): Any {
        val clazz = "۟.lib.jse.ۤۦۢ".toClass()
        return callStaticMethod(clazz, "۟ۧۧۢ", this, i, defVal) ?: defVal
    }

    override fun Any?.checklong(i: Int): Any {
        val clazz = "android.app.ۦۣۨۨ".toClass()
        return callStaticMethod(clazz, "ۡۧ۟ۥ", this, i)
    }

    override fun Any?.optjstring(i: Int, defVal: String): Any {
        val clazz = "۟.a.۟ۧ۟ۡۤ".toClass()
        return callStaticMethod(clazz, "۟۠ۦۣۢ", this, i, defVal) ?: defVal
    }

    override fun Any?.checkjstring(i: Int): Any {
        val clazz = "android.fix.ۣۣۤۧ".toClass()
        return callStaticMethod(clazz, "ۥ۟۠۟", this, i)
    }

    override fun Any?.optstring(i: Int, defVal: Any?): Any {
        val clazz = "android.ext.۟ۡۥۤ".toClass()
        return callStaticMethod(clazz, "ۣۦۦۥ", this, i, defVal) ?: "nil"
    }

    override fun Any?.checkstring(i: Int): Any {
        val clazz = "".toClass()
        return callStaticMethod(clazz, "", this, i)
    }

    override fun Any?.opttable(i: Int, defVal: Any?): Any {
        val clazz = "np.dcc.ۣ۟ۢۤۢ".toClass()
        return callStaticMethod(clazz, "۟ۧۥ۟ۢ", this, i, defVal) ?: "{}"
    }

    override fun Any?.checktable(i: Int): Any {
        val clazz = "np.۟ۧۦۡۤ".toClass()
        return callStaticMethod(clazz, "۟ۥ۟ۥۢ", this, i)
    }
}