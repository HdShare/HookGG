package me.hd.hookgg.hook.utils

import com.highcapable.yukihookapi.hook.log.YLog

fun printStackTrace() {
    val stackTrace = Throwable().stackTrace
    val stackTraceStr = stackTrace.joinToString("\n") { element ->
        "at ${element.className}.${element.methodName}(${element.fileName}:${element.lineNumber})"
    }
    YLog.error("StackTrace\n$stackTraceStr")
}