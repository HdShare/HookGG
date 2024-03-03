package me.hd.hookgg.hook.entry.base

interface BaseMethod {
    fun Any?.optboolean(i: Int, defVal: Boolean): Any
    fun Any?.checkboolean(i: Int): Any
    fun Any?.optdouble(i: Int, defVal: Double): Any
    fun Any?.checkdouble(i: Int): Any
    fun Any?.optfunction(i: Int, defVal: Any): Any
    fun Any?.checkfunction(i: Int): Any
    fun Any?.optint(i: Int, defVal: Int): Any
    fun Any?.checkint(i: Int): Any
    fun Any?.optlong(i: Int, defVal: Long): Any
    fun Any?.checklong(i: Int): Any
    fun Any?.optjstring(i: Int, defVal: String): Any
    fun Any?.checkjstring(i: Int): Any
    fun Any?.optstring(i: Int, defVal: String): Any
    fun Any?.checkstring(i: Int): Any
    fun Any?.opttable(i: Int, defVal: Any): Any
    fun Any?.checktable(i: Int): Any
}