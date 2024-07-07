package me.hd.hookgg.hook.hooker.elgg.v120

import com.highcapable.yukihookapi.hook.factory.method
import kotlinx.coroutines.launch
import me.hd.hookgg.data.GGData
import me.hd.hookgg.data.SetPagePrefsData
import me.hd.hookgg.hook.base.BaseGGHooker
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.arg
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.checkint
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.checkjstring
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.checktable
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.optboolean
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.optint
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.optjstring
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.optlong
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.optstring
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.opttable
import me.hd.hookgg.hook.utils.GGUtil

object ELGGv120Hooker : BaseGGHooker() {
    override fun onHook() {
        val setFuncList = prefs.get(SetPagePrefsData.FUNCTION_LIST)
        if (GGData.addListItems in setFuncList) addListItems()
        if (GGData.alert in setFuncList) alert()
        if (GGData.choice in setFuncList) choice()
        if (GGData.clearResults in setFuncList) clearResults()
        if (GGData.editAll in setFuncList) editAll()
        if (GGData.getRangesList in setFuncList) getRangesList()
        if (GGData.getResults in setFuncList) getResults()
        if (GGData.getResultsCount in setFuncList) getResultsCount()
        if (GGData.getValues in setFuncList) getValues()
        if (GGData.makeRequest in setFuncList) makeRequest()
        if (GGData.multiChoice in setFuncList) multiChoice()
        if (GGData.prompt in setFuncList) prompt()
        if (GGData.searchNumber in setFuncList) searchNumber()
        if (GGData.searchPointer in setFuncList) searchPointer()
        if (GGData.setRanges in setFuncList) setRanges()
        if (GGData.setValues in setFuncList) setValues()
        if (GGData.toast in setFuncList) toast()
    }

    private fun addListItems() {
        "android.ext.ۣۧۧۡ".toClassOrNull()?.apply {
            method {
                name = "b"
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
        "android.ext.ۦۤ۠۠".toClassOrNull()?.apply {
            method {
                name = "b"
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
        "android.ext.۟ۧ۠ۡۦ".toClassOrNull()?.apply {
            method {
                name = "b"
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
        "android.ext.۟ۧ۠ۡۨ".toClassOrNull()?.apply {
            method {
                name = "d"
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
        "android.ext.ۧۧۢ۠".toClassOrNull()?.apply {
            method {
                name = "b"
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
        "android.ext.ۧۧۡۥ".toClassOrNull()?.apply {
            method {
                name = "b"
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
        "android.ext.ۧۧۡۤ".toClassOrNull()?.apply {
            method {
                name = "d"
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
        "android.ext.ۧۧۡۡ".toClassOrNull()?.apply {
            method {
                name = "b"
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
        "android.ext.ۧۧۥۢ".toClassOrNull()?.apply {
            method {
                name = "b"
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
                name = "b"
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
        "android.ext.ۣۧۧۤ".toClassOrNull()?.apply {
            method {
                name = "b"
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
        "android.ext.ۦۤ۠ۨ".toClassOrNull()?.apply {
            method {
                name = "b"
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
        "android.ext.ۣۧۧۦ".toClassOrNull()?.apply {
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
                    val limit = varArgs.optlong(7, 0L)
                    scope.launch {
                        val func =
                            "gg.searchNumber($text, $type, $encrypted, $sign, $memoryFrom, $memoryTo, $limit)"
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
        "android.ext.۟ۧ۠ۥۢ".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val maxOffset = varArgs.checkint(1)
                    val memoryFrom = varArgs.optlong(2, 0L)
                    val memoryTo = varArgs.optlong(3, -1L)
                    val limit = varArgs.optlong(4, 0L)
                    scope.launch {
                        val func = "gg.searchPointer($maxOffset, $memoryFrom, $memoryTo, $limit)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun setRanges() {
        "android.ext.ۧۧۧ۠".toClassOrNull()?.apply {
            method {
                name = "d"
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
                name = "b"
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
        "android.ext.ۦۣۤۧ".toClassOrNull()?.apply {
            method {
                name = "b"
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