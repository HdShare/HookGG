package me.hd.hookgg.hook.utils

import com.highcapable.yukihookapi.hook.factory.method
import com.highcapable.yukihookapi.hook.log.YLog
import com.highcapable.yukihookapi.hook.param.PackageParam
import me.hd.hookgg.hook.entry.hooker.ELGG110Hooker.hook
import me.hd.hookgg.hook.entry.hooker.ELGG110Hooker.toClassOrNull
import me.hd.hookgg.hook.helper.DexKitHelper
import java.lang.reflect.Modifier

object T {

    fun findMethod(param: PackageParam) {
        DexKitHelper.create(param) {
            val classData = findClass {
                searchPackages("android.ext")
                matcher {
                    methods {
                        add {
                            modifiers = Modifier.PROTECTED
                            paramCount = 0
                            returnType = "int"
                        }
                        add {
                            returnType = "java.lang.String"
                            paramCount = 0
                        }
                    }
                }
            }
            YLog.error("size -> ${classData.size}")
            for (i in 0 until classData.size) {
                val className = classData[i].name
                YLog.error("$i -> $className")
                className.toClassOrNull()?.apply {
                    method {
                        name = "a"
                        paramCount = 0
                    }.ignored().hook {
                        after {
                            YLog.error("$result class -> $className")
                        }
                    }
                }
            }
        }
    }

}