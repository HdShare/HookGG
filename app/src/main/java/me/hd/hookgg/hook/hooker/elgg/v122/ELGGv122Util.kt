package me.hd.hookgg.hook.hooker.elgg.v122

import com.highcapable.yukihookapi.hook.type.java.StringClass
import de.robv.android.xposed.XposedHelpers.callStaticMethod
import me.hd.hookgg.hook.hooker.elgg.v122.ELGGv122Hooker.toClass

object ELGGv122Util {
    fun decryptText(text: String): Any {
        val clazz = "android.ext.۟ۧ۠۟ۦ".toClass()
        val parameterTypes = arrayOf(StringClass)
        return callStaticMethod(clazz, "a", parameterTypes, text)
    }
}