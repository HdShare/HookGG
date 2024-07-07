package me.hd.hookgg.hook.hooker.gg.v960

import com.highcapable.yukihookapi.hook.factory.method
import com.highcapable.yukihookapi.hook.log.YLog
import kotlinx.coroutines.launch
import me.hd.hookgg.data.GGData
import me.hd.hookgg.data.SetPagePrefsData
import me.hd.hookgg.data.StrData
import me.hd.hookgg.hook.base.BaseGGHooker
import me.hd.hookgg.hook.hooker.gg.v960.GGv960VarArgs.arg
import me.hd.hookgg.hook.hooker.gg.v960.GGv960VarArgs.checkint
import me.hd.hookgg.hook.hooker.gg.v960.GGv960VarArgs.checkjstring
import me.hd.hookgg.hook.hooker.gg.v960.GGv960VarArgs.checktable
import me.hd.hookgg.hook.hooker.gg.v960.GGv960VarArgs.optboolean
import me.hd.hookgg.hook.hooker.gg.v960.GGv960VarArgs.optint
import me.hd.hookgg.hook.hooker.gg.v960.GGv960VarArgs.optjstring
import me.hd.hookgg.hook.hooker.gg.v960.GGv960VarArgs.optlong
import me.hd.hookgg.hook.hooker.gg.v960.GGv960VarArgs.optstring
import me.hd.hookgg.hook.hooker.gg.v960.GGv960VarArgs.opttable
import me.hd.hookgg.hook.utils.GGUtil

object GGv960Hooker : BaseGGHooker() {
    override val functionMap = mapOf(
        GGData.addListItems to { addListItems() },
        GGData.alert to { alert() },
        GGData.choice to { choice() },
        GGData.clearResults to { clearResults() },
        GGData.editAll to { editAll() },
        GGData.getRangesList to { getRangesList() },
        GGData.getResults to { getResults() },
        GGData.getResultsCount to { getResultsCount() },
        GGData.getValues to { getValues() },
        GGData.makeRequest to { makeRequest() },
        GGData.multiChoice to { multiChoice() },
        GGData.prompt to { prompt() },
        GGData.searchNumber to { searchNumber() },
        GGData.searchPointer to { searchPointer() },
        GGData.setRanges to { setRanges() },
        GGData.setValues to { setValues() },
        GGData.toast to { toast() }
    )

    private fun addListItems() {
        "android.ext.Script\$addListItems".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val items = varArgs.checktable(1)
                    scope.launch {
                        val func = "gg.addListItems($items)"
                        val filterParams = prefs.get(SetPagePrefsData.FILTER_PARAMS)
                        if (!(filterParams && !GGUtil.isValidItems("$items"))) {
                            sendLog(func, result)
                        }
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun alert() {
        "android.ext.Script\$alert".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val text = varArgs.checkjstring(1)
                    val positive = varArgs.optjstring(2, "ok")
                    val negative = varArgs.optjstring(3, "nil")
                    val neutral = varArgs.optjstring(4, "nil")
                    scope.launch {
                        val func = "gg.alert($text, $positive, $negative, $neutral)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun choice() {
        "android.ext.Script\$choice".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val items = varArgs.checktable(1)
                    val selected = varArgs.arg(2)
                    val message = varArgs.optjstring(3, "nil")
                    scope.launch {
                        val func = "gg.choice($items, $selected, $message)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun clearResults() {
        "android.ext.Script\$clearResults".toClassOrNull()?.apply {
            method {
                name = "invokeUi"
                paramCount = 1
            }.ignored().hook {
                after {
                    scope.launch {
                        val func = "gg.clearResults()"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun editAll() {
        "android.ext.Script\$editAll".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val value = varArgs.checkjstring(1)
                    val type = varArgs.checkint(2)
                    scope.launch {
                        val func = "gg.editAll($value, $type)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun getRangesList() {
        "android.ext.Script\$getRangesList".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val filter = varArgs.optjstring(1, "")
                    scope.launch {
                        val func = "gg.getRangesList($filter)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun getResults() {
        "android.ext.Script\$getResults".toClassOrNull()?.apply {
            method {
                name = "invokeUi"
                paramCount = 1
            }.ignored().hook {
                after {
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
                    scope.launch {
                        val func =
                            "gg.getResults($maxCount, $skip, $addressMin, $addressMax, $valueMin, $valueMax, $type, $fractional, $pointer)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun getResultsCount() {
        "android.ext.Script\$getResultsCount".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                after {
                    scope.launch {
                        val func = "gg.getResultsCount()"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun getValues() {
        "android.ext.Script\$getValues".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val values = varArgs.checktable(1)
                    scope.launch {
                        val func = "gg.getValues($values)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun makeRequest() {
        "android.ext.Script\$makeRequest".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val url = varArgs.checkjstring(1)
                    val headers = varArgs.opttable(2, null)
                    val data = varArgs.optstring(3, null)
                    scope.launch {
                        val func = "gg.makeRequest($url, $headers, $data)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun multiChoice() {
        "android.ext.Script\$multiChoice".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val items = varArgs.checktable(1)
                    val selection = varArgs.opttable(2, null)
                    val message = varArgs.optjstring(3, "nil")
                    scope.launch {
                        val func = "gg.multiChoice($items, $selection, $message)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun prompt() {
        "android.ext.Script\$prompt".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val items = varArgs.checktable(1)
                    val defaults = varArgs.opttable(2, null)
                    val types = varArgs.opttable(3, null)
                    scope.launch {
                        val func = "gg.prompt($items, $defaults, $types)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun searchNumber() {
        "android.ext.Script\$searchNumber".toClassOrNull()?.apply {
            method {
                name = "invokeUi"
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
                    scope.launch {
                        val func =
                            "gg.searchNumber($text, $type, $encrypted, $sign, $memoryFrom, $memoryTo)"
                        val filterParams = prefs.get(SetPagePrefsData.FILTER_PARAMS)
                        if (!(filterParams && !GGUtil.isValidParams("$text"))) {
                            sendLog(func, result)
                        }
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun searchPointer() {
        val func = StrData.Unsupported.format("searchPointer")
        YLog.error(func)
    }

    private fun setRanges() {
        "android.ext.Script\$setRanges".toClassOrNull()?.apply {
            method {
                name = "invokeUi"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val ranges = varArgs.checkint(1)
                    scope.launch {
                        val func = "gg.setRanges($ranges)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun setValues() {
        "android.ext.Script\$setValues".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val values = varArgs.checktable(1)
                    scope.launch {
                        val func = "gg.setValues($values)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun toast() {
        "android.ext.Script\$toast".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val text = varArgs.checkjstring(1)
                    val fast = varArgs.optboolean(2, false)
                    scope.launch {
                        val func = "gg.toast($text, $fast)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }
}