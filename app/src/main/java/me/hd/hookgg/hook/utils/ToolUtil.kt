package me.hd.hookgg.hook.utils

import androidx.annotation.StringRes
import com.highcapable.yukihookapi.hook.log.YLog
import com.highcapable.yukihookapi.hook.param.PackageParam

fun PackageParam.getString(@StringRes id: Int): String {
    return moduleAppResources.getString(id)
}

fun printStackTrace() {
    val stackTrace = Throwable().stackTrace
    val stackTraceStr = stackTrace.joinToString("\n") { element ->
        "at ${element.className}.${element.methodName}(${element.fileName}:${element.lineNumber})"
    }
    YLog.error("StackTrace\n$stackTraceStr")
}