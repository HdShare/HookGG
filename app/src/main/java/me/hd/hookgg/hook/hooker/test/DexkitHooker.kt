package me.hd.hookgg.hook.hooker.test

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.log.YLog
import me.hd.hookgg.hook.utils.DexKitUtil
import java.lang.reflect.Modifier

object DexkitHooker : YukiBaseHooker() {
    private fun logFunc() {
        DexKitUtil.create(this) {
            val classData = findClass {
                searchPackages("android.ext")
                matcher {
                    methods {
                        add {
                            modifiers = Modifier.PROTECTED
                            returnType = "int"
                            //name = "getMaxArgs","m_"
                            paramCount = 0
                        }
                        add {
                            //name = "usage","a"
                            returnType = "java.lang.String"
                            paramCount = 0
                            //usingStrings("gg.")
                        }
                    }
                }
            }
            YLog.error("func size -> ${classData.size}")
        }
    }

    override fun onHook() {
    }
}