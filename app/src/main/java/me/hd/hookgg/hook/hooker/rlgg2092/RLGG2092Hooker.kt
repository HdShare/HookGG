package me.hd.hookgg.hook.hooker.rlgg2092

import com.highcapable.yukihookapi.hook.factory.method
import com.highcapable.yukihookapi.hook.log.YLog
import me.hd.hookgg.data.SetPagePrefsData
import me.hd.hookgg.hook.base.BaseGGHooker
import me.hd.hookgg.hook.hooker.rlgg2092.RLGG2092VarArgs.arg
import me.hd.hookgg.hook.hooker.rlgg2092.RLGG2092VarArgs.checkint
import me.hd.hookgg.hook.hooker.rlgg2092.RLGG2092VarArgs.checkjstring
import me.hd.hookgg.hook.hooker.rlgg2092.RLGG2092VarArgs.checktable
import me.hd.hookgg.hook.hooker.rlgg2092.RLGG2092VarArgs.optboolean
import me.hd.hookgg.hook.hooker.rlgg2092.RLGG2092VarArgs.optint
import me.hd.hookgg.hook.hooker.rlgg2092.RLGG2092VarArgs.optjstring
import me.hd.hookgg.hook.hooker.rlgg2092.RLGG2092VarArgs.optlong
import me.hd.hookgg.hook.hooker.rlgg2092.RLGG2092VarArgs.optstring
import me.hd.hookgg.hook.hooker.rlgg2092.RLGG2092VarArgs.opttable
import me.hd.hookgg.hook.utils.GGUtil

object RLGG2092Hooker : BaseGGHooker() {
    override fun toast() {

    }

    override fun alert() {
        "android.ext.̳".toClassOrNull()?.apply {
            method {
                name = "̢"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val text = varArgs.checkjstring(1)
                    val positive = varArgs.optjstring(2, "ok")
                    val negative = varArgs.optjstring(3, "nil")
                    val neutral = varArgs.optjstring(4, "nil")
                    val func = "gg.alert($text, $positive, $negative, $neutral)"
                    sendLog(func, result)
                }
            }.ignoredAllFailure()
        }
    }

    override fun choice() {
        "android.ext.̷".toClassOrNull()?.apply {
            method {
                name = "̢"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val items = varArgs.checktable(1)
                    val selected = varArgs.arg(2)
                    val message = varArgs.optjstring(3, "nil")
                    val func = "gg.choice($items, $selected, $message)"
                    sendLog(func, result)
                }
            }.ignoredAllFailure()
        }
    }

    override fun multiChoice() {
        "android.ext.Ϳ".toClassOrNull()?.apply {
            method {
                name = "̢"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val items = varArgs.checktable(1)
                    val selection = varArgs.opttable(2, null)
                    val message = varArgs.optjstring(3, "nil")
                    val func = "gg.multiChoice($items, $selection, $message)"
                    sendLog(func, result)
                }
            }.ignoredAllFailure()
        }
    }

    override fun prompt() {
        "android.ext.Ԭ".toClassOrNull()?.apply {
            method {
                name = "̢"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val items = varArgs.checktable(1)
                    val defaults = varArgs.opttable(2, null)
                    val types = varArgs.opttable(3, null)
                    val func = "gg.prompt($items, $defaults, $types)"
                    sendLog(func, result)
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
                after {
                    val func = "gg.clearResults()"
                    sendLog(func, result)
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
                after {
                    val varArgs = args(0).any()
                    val ranges = varArgs.checkint(1)
                    val func = "gg.setRanges($ranges)"
                    sendLog(func, result)
                }
            }.ignoredAllFailure()
        }
    }

    override fun getRangesList() {
        "android.ext.͒".toClassOrNull()?.apply {
            method {
                name = "̢"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val filter = varArgs.optjstring(1, "")
                    val func = "gg.getRangesList($filter)"
                    sendLog(func, result)
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
                after {
                    val varArgs = args(0).any()
                    val text = varArgs.checkjstring(1)
                    val type = varArgs.optint(2, 127)
                    val encrypted = varArgs.optboolean(3, false)
                    val sign = varArgs.optint(4, 0x20000000)
                    val memoryFrom = varArgs.optlong(5, 0L)
                    val memoryTo = varArgs.optlong(6, -1L)
                    val limit = varArgs.optlong(7, 0)
                    val func =
                        "gg.searchNumber($text, $type, $encrypted, $sign, $memoryFrom, $memoryTo, $limit)"
                    val filterParams = prefs.get(SetPagePrefsData.FILTER_PARAMS)
                    if (filterParams && !GGUtil.isValidParams("$text")) return@after
                    sendLog(func, result)
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
                after {
                    val func = "gg.getResultsCount()"
                    sendLog(func, result)
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
                after {
                    YLog.error("getResults")
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
                    val func =
                        "gg.getResults($maxCount, $skip, $addressMin, $addressMax, $valueMin, $valueMax, $type, $fractional, $pointer)"
                    sendLog(func, result)
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
                after {
                    YLog.error("editAll")
                    val varArgs = args(0).any()
                    val value = varArgs.checkjstring(1)
                    val type = varArgs.checkint(2)
                    val func = "gg.editAll($value, $type)"
                    sendLog(func, result)
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
                after {
                    YLog.error("getValues")
//                    val varArgs = args(0).any()
//                    val values = varArgs.checktable(1)
//                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
//                        "log",
//                        "gg.getValues($values)"
//                    )
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
                after {
                    YLog.error("setValues")
//                    val varArgs = args(0).any()
//                    val values = varArgs.checktable(1)
//                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
//                        "log",
//                        "gg.setValues($values)"
//                    )
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
                after {
                    YLog.error("addListItems")
//                    val varArgs = args(0).any()
//                    val items = varArgs.checktable(1)
//                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
//                        "log",
//                        "gg.addListItems($items)"
//                    )
                }
            }.ignoredAllFailure()
        }
    }

    override fun makeRequest() {
        "android.ext.\u0378".toClassOrNull()?.apply {
            method {
                name = "̢"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val url = varArgs.checkjstring(1)
                    val headers = varArgs.opttable(2, null)
                    val data = varArgs.optstring(3, null)
                    val func = "gg.makeRequest($url, $headers, $data)"
                    sendLog(func, result)
                }
            }.ignoredAllFailure()
        }
    }
}