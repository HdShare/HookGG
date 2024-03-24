package me.hd.hookgg.hook.utils

import com.highcapable.yukihookapi.hook.log.YLog

object ToolUtil {
    fun printStackTrace() {
        val sb = StringBuffer()
        val stackElements = Throwable().stackTrace
        for (i in 1 until stackElements.size) {
            val element = stackElements[i]
            sb.append("at ${element.className}.${element.methodName}(${element.fileName}:${element.lineNumber})\n")
        }
        YLog.error("StackTrace -> $sb")
    }
}