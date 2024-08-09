package me.hd.hookgg.hook.hooker.elgg.v114

import com.highcapable.yukihookapi.hook.type.java.StringClass
import de.robv.android.xposed.XposedHelpers.callStaticMethod
import me.hd.hookgg.hook.hooker.elgg.v114.ELGGv114Hooker.toClass

object ELGGv114Util {
    fun decryptText(text: String): Any {
        val clazz = "android.ext.۟ۧ۠۟ۦ".toClass()
        val parameterTypes = arrayOf(StringClass)
        return callStaticMethod(clazz, "a", parameterTypes, text)
    }
}