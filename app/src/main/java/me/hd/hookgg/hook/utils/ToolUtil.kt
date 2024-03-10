package me.hd.hookgg.hook.utils

object ToolUtil {
    fun printStackTrace(): String {
        val sb = StringBuffer()
        val stackElements = Throwable().stackTrace
        for (i in 1 until stackElements.size) {
            val element = stackElements[i]
            sb.append("at ${element.className}.${element.methodName}(${element.fileName}:${element.lineNumber})\n")
        }
        return sb.toString()
    }
}