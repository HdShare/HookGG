package me.hd.hookgg.hook.hooker.elgg.v117

import com.highcapable.yukihookapi.hook.type.java.StringClass
import de.robv.android.xposed.XposedHelpers.callStaticMethod
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117Hooker.toClass

object ELGGv117Util {
    fun decryptText(text: String): Any {
        val clazz = "android.ext.۟ۧ۠۠۠".toClass()
        val parameterTypes = arrayOf(StringClass)
        return callStaticMethod(clazz, "a", parameterTypes, text)
    }
}