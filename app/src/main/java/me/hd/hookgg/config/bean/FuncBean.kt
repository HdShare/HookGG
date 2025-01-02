package me.hd.hookgg.config.bean

data class FuncObj(
    val funcName: String,
    val funcDetail: FuncDetail
)

data class FuncDetail(
    val isWarning: Boolean = false,
    val funcListener: (() -> Unit)? = null
)