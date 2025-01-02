package me.hd.hookgg.hook.hooker.elgg.v125

import com.highcapable.yukihookapi.hook.type.java.StringClass
import de.robv.android.xposed.XposedHelpers.callStaticMethod
import me.hd.hookgg.hook.hooker.elgg.v125.ELGGv125Hooker.toClass

object ELGGv125Util {
    fun decryptText(text: String): Any {
        val clazz = "android.ext.۟ۧ۠۠ۧ".toClass()
        val parameterTypes = arrayOf(StringClass)
        return callStaticMethod(clazz, "a", parameterTypes, text)
    }
}