package me.hd.hookgg.hook.entry.hooker.rlgg2092

import com.highcapable.yukihookapi.hook.factory.dataChannel
import com.highcapable.yukihookapi.hook.factory.method
import com.highcapable.yukihookapi.hook.log.YLog
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.hook.entry.base.BaseFunction
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Hooker.hook
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Hooker.toClassOrNull
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Method.checkint
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Method.checkjstring
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Method.optboolean
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Method.optint
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Method.optjstring
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Method.optlong

object RLGG2092Function : BaseFunction {
    override fun toast() {

    }

    override fun alert() {
        "android.ext.̳".toClassOrNull()?.apply {
            method {
                name = "̢"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val text = varArgs.checkjstring(1)
                    val positive = varArgs.optjstring(2, "ok")
                    val negative = varArgs.optjstring(3, "nil")
                    val neutral = varArgs.optjstring(4, "nil")
                    RLGG2092Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.alert($text, $positive, $negative, $neutral)"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun clearResults() {
        "android.ext.̻".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                before {
                    RLGG2092Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.clearResults()"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun setRanges() {
        "android.ext.\u05CA".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val ranges = varArgs.checkint(1)
                    RLGG2092Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.setRanges($ranges)"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun searchNumber() {
        "android.ext.ԯ".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val text = varArgs.checkjstring(1)
                    val type = varArgs.optint(2, 127)
                    val encrypted = varArgs.optboolean(3, false)
                    val sign = varArgs.optint(4, 0x20000000)
                    val memoryFrom = varArgs.optlong(5, 0L)
                    val memoryTo = varArgs.optlong(6, -1L)
                    val limit = varArgs.optlong(7, 0)
                    RLGG2092Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.searchNumber($text, $type, $encrypted, $sign, $memoryFrom, $memoryTo, $limit)"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun getResultsCount() {
        "android.ext.͕".toClassOrNull()?.apply {
            method {
                name = "̢"
                paramCount = 1
            }.ignored().hook {
                before {
                    RLGG2092Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.getResultsCount()"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun getResults() {
        "android.ext.͔".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val maxCount = varArgs.checkint(1)
                    val skip = varArgs.optint(2, 0)
                    val addressMin = varArgs.optlong(3, 0L)
                    val addressMax = varArgs.optlong(4, -1L)
                    val valueMin = varArgs.optjstring(5, "nil")
                    val valueMax = varArgs.optjstring(6, "nil")
                    val type = varArgs.optint(7, 0)
                    val fractional = varArgs.optjstring(8, "nil")
                    val pointer = varArgs.optint(9, 0)
                    RLGG2092Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.getResults($maxCount, $skip, $addressMin, $addressMax, $valueMin, $valueMax, $type, $fractional, $pointer)"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun editAll() {
        "android.ext.͆".toClassOrNull()?.apply {
            method {
                name = "̢"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val value = varArgs.checkjstring(1)
                    val type = varArgs.checkint(2)
                    RLGG2092Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.editAll($value, $type)"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun getValues() {
        "android.ext.ͣ".toClassOrNull()?.apply {
            method {
                name = "̢"
                paramCount = 1
            }.ignored().hook {
                before {
                    YLog.error("getValues")
//                    val varArgs = args(0).any()
//                    val values = varArgs.checktable(1)
//                    RLGG2092Hooker.appContext
//                        ?.dataChannel(BuildConfig.APPLICATION_ID)
//                        ?.put(
//                            "log",
//                            "gg.getValues($values)"
//                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun setValues() {
        "android.ext.\u05CD".toClassOrNull()?.apply {
            method {
                name = "̢"
                paramCount = 1
            }.ignored().hook {
                before {
                    YLog.error("setValues")
//                    val varArgs = args(0).any()
//                    val values = varArgs.checktable(1)
//                    RLGG2092Hooker.appContext
//                        ?.dataChannel(BuildConfig.APPLICATION_ID)
//                        ?.put(
//                            "log",
//                            "gg.setValues($values)"
//                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun addListItems() {
        "android.ext.̯".toClassOrNull()?.apply {
            method {
                name = "̢"
                paramCount = 1
            }.ignored().hook {
                before {
                    YLog.error("addListItems")
//                    val varArgs = args(0).any()
//                    val items = varArgs.checktable(1)
//                    RLGG2092Hooker.appContext
//                        ?.dataChannel(BuildConfig.APPLICATION_ID)
//                        ?.put(
//                            "log",
//                            "gg.addListItems($items)"
//                        )
                }
            }.ignoredAllFailure()
        }
    }
}