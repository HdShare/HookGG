package me.hd.hookgg.hook.utils


@OptIn(ExperimentalStdlibApi::class)
object GGUtil {
    fun isValidItems(items: String): Boolean {
        return items.length in 1..102400
    }

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

    fun getConstValue(constMap: Map<String, Int>, value: Int): String {
        val constValue = mutableListOf<String>()
        var empty = true
        var tmpValue = value
        for (const in constMap) {
            if ((tmpValue and const.value) == const.value) {
                empty = false
                constValue.add(const.key)
                tmpValue = tmpValue and const.value.xor(-1)
            }
        }
        if (empty || tmpValue != 0) constValue.add(tmpValue.toString())
        return constValue.joinToString(" | ")
    }

    fun getHexValue(value: Long): String {
        return if (value == 0L || value == -1L) {
            value.toString()
        } else {
            "0x${value.toHexString()}"
        }
    }

    fun getStringValue(value: String): String {
        return "\"$value\""
    }
}