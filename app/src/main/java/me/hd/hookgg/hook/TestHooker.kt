package me.hd.hookgg.hook

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.log.YLog
import me.hd.hookgg.hook.utils.DexKitUtil
import java.lang.reflect.Modifier

object TestHooker : YukiBaseHooker() {
    override fun onHook() {
        DexKitUtil.create(this) {
            val classData = findClass {
                searchPackages("android.ext")
                matcher {
                    methods {
                        add {
                            modifiers = Modifier.PROTECTED
                            returnType = "int"
                            name = "getMaxArgs"
                            paramCount = 0
                        }
                        add {
                            name = "usage"
                            returnType = "java.lang.String"
                            paramCount = 0
                            usingStrings("gg.")
                        }
                    }
                }
            }
            YLog.error("size -> ${classData.size}")
            classData.forEachIndexed { index, className ->
                YLog.error("$index -> ${className.name}")
            }
        }
    }
}