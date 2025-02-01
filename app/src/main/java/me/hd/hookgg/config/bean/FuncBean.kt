package me.hd.hookgg.config.bean

import me.hd.hookgg.config.lib.LibType

data class FuncObj(
    val funcName: String,
    val funcDetail: FuncDetail
) {
    data class FuncDetail(
        val libType: LibType = LibType.GGLib,
        val isWarning: Boolean = false,
        val funcListener: (() -> Unit)? = null
    )
}