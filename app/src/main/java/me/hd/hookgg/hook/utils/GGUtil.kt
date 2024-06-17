package me.hd.hookgg.hook.utils

object GGUtil {
    fun isValidParams(text: String): Boolean {
        val isValidLength = text.length in 1..100
        val isSearchNumber = text.matches(Regex("^\\s*[0-9\\s]+\\s*$"))
        val isSearchTextUtf = setOf(":", ";").any { prefix -> text.startsWith(prefix) }
        val isSearchHex = setOf("h").any { prefix -> text.startsWith(prefix) }
        val isSearchEndian = setOf("h", "r").any { prefix -> text.endsWith(prefix) }
        val isSearchHexUtf = setOf("Q", "q").any { prefix -> text.startsWith(prefix) }
        val isSearchATA8 = setOf("~A ", "~T ", "~A8 ").any { prefix -> text.startsWith(prefix) }
        return isValidLength && (isSearchNumber || isSearchTextUtf || isSearchHex || isSearchEndian || isSearchHexUtf || isSearchATA8)
    }
}