package me.hd.hookgg.data.bean

data class FuncObj(
    val funcName: String,
    val funcDetail: FuncDetail
)

data class FuncDetail(
    val isWarning: Boolean = false,
    val funcListener: (() -> Unit)? = null
)