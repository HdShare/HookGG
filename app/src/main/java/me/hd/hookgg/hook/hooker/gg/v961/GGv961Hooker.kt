package me.hd.hookgg.hook.hooker.gg.v961

import com.highcapable.yukihookapi.hook.factory.method
import me.hd.hookgg.data.SetPrefsData
import me.hd.hookgg.data.func.GGLib
import me.hd.hookgg.hook.base.BaseGGHooker
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.arg
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.checkboolean
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.checkdouble
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.checkint
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.checkjstring
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.checklong
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.checkstring
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.checktable
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.optboolean
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.optdouble
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.optint
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.optjstring
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.optlong
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.optstring
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.opttable
import me.hd.hookgg.hook.hooker.gg.v961.GGv961VarArgs.tojstring
import me.hd.hookgg.hook.utils.GGUtil

object GGv961Hooker : BaseGGHooker() {
    override val functionMap = mapOf(
        GGLib.addListItems to { this.addListItems() },
        GGLib.alert to { this.alert() },
        GGLib.allocatePage to { this.allocatePage() },
        GGLib.bytes to { this.bytes() },
        GGLib.choice to { this.choice() },
        GGLib.clearList to { this.clearList() },
        GGLib.clearResults to { this.clearResults() },
        GGLib.copyMemory to { this.copyMemory() },
        GGLib.copyText to { this.copyText() },
        GGLib.disasm to { this.disasm() },
        GGLib.dumpMemory to { this.dumpMemory() },
        GGLib.editAll to { this.editAll() },
        GGLib.getActiveTab to { this.getActiveTab() },
        GGLib.getFile to { this.getFile() },
        GGLib.getLine to { this.getLine() },
        GGLib.getListItems to { this.getListItems() },
        GGLib.getLocale to { this.getLocale() },
        GGLib.getRanges to { this.getRanges() },
        GGLib.getRangesList to { this.getRangesList() },
        GGLib.getResults to { this.getResults() },
        GGLib.getResultsCount to { this.getResultsCount() },
        GGLib.getSelectedElements to { this.getSelectedElements() },
        GGLib.getSelectedListItems to { this.getSelectedListItems() },
        GGLib.getSelectedResults to { this.getSelectedResults() },
        GGLib.getSpeed to { this.getSpeed() },
        GGLib.getTargetInfo to { this.getTargetInfo() },
        GGLib.getTargetPackage to { this.getTargetPackage() },
        GGLib.getValues to { this.getValues() },
        GGLib.getValuesRange to { this.getValuesRange() },
        GGLib.gotoAddress to { this.gotoAddress() },
        GGLib.hideUiButton to { this.hideUiButton() },
        GGLib.internal1 to { this.internal1() },
        GGLib.internal2 to { this.internal2() },
        GGLib.internal3 to { this.internal3() },
        GGLib.isClickedUiButton to { this.isClickedUiButton() },
        GGLib.isPackageInstalled to { this.isPackageInstalled() },
        GGLib.isProcessPaused to { this.isProcessPaused() },
        GGLib.isVisible to { this.isVisible() },
        GGLib.loadList to { this.loadList() },
        GGLib.loadResults to { this.loadResults() },
        GGLib.makeRequest to { this.makeRequest() },
        GGLib.multiChoice to { this.multiChoice() },
        GGLib.numberFromLocale to { this.numberFromLocale() },
        GGLib.numberToLocale to { this.numberToLocale() },
        GGLib.processKill to { this.processKill() },
        GGLib.processPause to { this.processPause() },
        GGLib.processResume to { this.processResume() },
        GGLib.processToggle to { this.processToggle() },
        GGLib.prompt to { this.prompt() },
        GGLib.removeListItems to { this.removeListItems() },
        GGLib.removeResults to { this.removeResults() },
        GGLib.require to { this.require() },
        GGLib.saveList to { this.saveList() },
        GGLib.saveVariable to { this.saveVariable() },
        GGLib.searchAddress to { this.searchAddress() },
        GGLib.searchFuzzy to { this.searchFuzzy() },
        GGLib.searchNumber to { this.searchNumber() },
        GGLib.setRanges to { this.setRanges() },
        GGLib.setSpeed to { this.setSpeed() },
        GGLib.setValues to { this.setValues() },
        GGLib.setVisible to { this.setVisible() },
        GGLib.showUiButton to { this.showUiButton() },
        GGLib.skipRestoreState to { this.skipRestoreState() },
        GGLib.sleep to { this.sleep() },
        GGLib.startFuzzy to { this.startFuzzy() },
        GGLib.timeJump to { this.timeJump() },
        GGLib.toast to { this.toast() },
        GGLib.unrandomizer to { this.unrandomizer() },
    )

    private fun addListItems() {
        "android.ext.Script\$addListItems"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val items = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (filterParams && !GGUtil.isValidItems("$items")) {
                            sendLog("gg.addListItems(过滤参数)")
                        } else {
                            val func = "gg.addListItems($items)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun alert() {
        "android.ext.Script\$alert"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val text = varArgs.checkjstring(1)
                        val textTmp = GGUtil.getStringValue(text)
                        val positive = varArgs.optjstring(2, "ok")
                        val positiveTmp = GGUtil.getStringValue(positive)
                        val negative = varArgs.optjstring(3, "nil")
                        val negativeTmp = GGUtil.getStringValue(negative)
                        val neutral = varArgs.optjstring(4, "nil")
                        val neutralTmp = GGUtil.getStringValue(neutral)
                        val func = "gg.alert($textTmp, $positiveTmp, $negativeTmp, $neutralTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun allocatePage() {
        "android.ext.Script\$allocatePage"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val mode = varArgs.optint(1, 6)
                        val modeTmp = GGUtil.getConstValue(GGLib.CONST.PROT, mode as Int)
                        val address = varArgs.optlong(2, 0L)
                        val addressTmp = GGUtil.getHexValue(address as Long)
                        val func = "gg.allocatePage($modeTmp, $addressTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun bytes() {
        "android.ext.Script\$bytes"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val text = varArgs.checkjstring(1)
                        val textTmp = GGUtil.getStringValue(text)
                        val encoding = varArgs.optjstring(2, "UTF-8")
                        val encodingTmp = GGUtil.getStringValue(encoding)
                        val func = "gg.bytes($textTmp, $encodingTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun choice() {
        "android.ext.Script\$choice"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val items = varArgs.checktable(1)
                        val selected = varArgs.arg(2)
                        val message = varArgs.optjstring(3, "nil")
                        val messageTmp = GGUtil.getStringValue(message)
                        val func = "gg.choice($items, $selected, $messageTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun clearList() {
        "android.ext.Script\$clearList"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.clearList()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun clearResults() {
        "android.ext.Script\$clearResults"
            .toClassOrNull()?.apply {
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

    private fun copyMemory() {
        "android.ext.Script\$copyMemory"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val from = varArgs.checklong(1)
                        val fromTmp = GGUtil.getHexValue(from as Long)
                        val to = varArgs.checklong(2)
                        val toTmp = GGUtil.getHexValue(to as Long)
                        val bytes = varArgs.checkint(3)
                        val func = "gg.copyMemory($fromTmp, $toTmp, $bytes)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun copyText() {
        "android.ext.Script\$copyText"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val text = varArgs.checkjstring(1)
                        val textTmp = GGUtil.getStringValue(text)
                        val fixLocale = varArgs.optboolean(2, true)
                        val func = "gg.copyText($textTmp, $fixLocale)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun disasm() {
        "android.ext.Script\$disasm"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val type = varArgs.checkint(1)
                        val typeTmp = GGUtil.getConstValue(GGLib.CONST.ASM, type as Int)
                        val address = varArgs.checklong(2)
                        val addressTmp = GGUtil.getHexValue(address as Long)
                        val opcode = varArgs.checkint(3)
                        val func = "gg.disasm($typeTmp, $addressTmp, $opcode)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun dumpMemory() {
        "android.ext.Script\$dumpMemory"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val from = varArgs.checklong(1)
                        val fromTmp = GGUtil.getHexValue(from as Long)
                        val to = varArgs.checklong(2)
                        val toTmp = GGUtil.getHexValue(to as Long)
                        val dir = varArgs.checkjstring(3)
                        val dirTmp = GGUtil.getStringValue(dir)
                        val flags = varArgs.optint(4, 0)
                        val flagsTmp = GGUtil.getConstValue(GGLib.CONST.DUMP, flags as Int)
                        val func = "gg.dumpMemory($fromTmp, $toTmp, $dirTmp, $flagsTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun editAll() {
        "android.ext.Script\$editAll"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val value = varArgs.checkjstring(1)
                        val valueTmp = GGUtil.getStringValue(value)
                        val type = varArgs.checkint(2)
                        val typeTmp = GGUtil.getConstValue(GGLib.CONST.TYPE, type as Int)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (filterParams && !GGUtil.isValidParams("$value")) {
                            sendLog("gg.editAll(过滤参数)")
                        } else {
                            val func = "gg.editAll($valueTmp, $typeTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getActiveTab() {
        "android.ext.Script\$getActiveTab"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.getActiveTab()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getFile() {
        "android.ext.Script\$getFile"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.getFile()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getLine() {
        "android.ext.Script\$getLine"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.getLine()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getListItems() {
        "android.ext.Script\$getListItems"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.getListItems()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getLocale() {
        "android.ext.Script\$getLocale"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.getLocale()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getRanges() {
        "android.ext.Script\$getRanges"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.getRanges()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getRangesList() {
        "android.ext.Script\$getRangesList"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val filter = varArgs.optjstring(1, "")
                        val filterTmp = GGUtil.getStringValue(filter)
                        val func = "gg.getRangesList($filterTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getResults() {
        "android.ext.Script\$getResults"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val maxCount = varArgs.checkint(1)
                        val skip = varArgs.optint(2, 0)
                        val addressMin = varArgs.optlong(3, 0L)
                        val addressMinTmp = GGUtil.getHexValue(addressMin as Long)
                        val addressMax = varArgs.optlong(4, -1L)
                        val addressMaxTmp = GGUtil.getHexValue(addressMax as Long)
                        val valueMin = varArgs.optjstring(5, "nil")
                        val valueMinTmp = GGUtil.getStringValue(valueMin)
                        val valueMax = varArgs.optjstring(6, "nil")
                        val valueMaxTmp = GGUtil.getStringValue(valueMax)
                        val type = varArgs.optint(7, 0)
                        val typeTmp = GGUtil.getConstValue(GGLib.CONST.TYPE, type as Int)
                        val fractional = varArgs.optjstring(8, "nil")
                        val fractionalTmp = GGUtil.getStringValue(fractional)
                        val pointer = varArgs.optint(9, 0)
                        val pointerTmp = GGUtil.getConstValue(GGLib.CONST.POINTER, pointer as Int)
                        val func =
                            "gg.getResults($maxCount, $skip, $addressMinTmp, $addressMaxTmp, $valueMinTmp, $valueMaxTmp, $typeTmp, $fractionalTmp, $pointerTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getResultsCount() {
        "android.ext.Script\$getResultsCount"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.getResultsCount()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getSelectedElements() {
        "android.ext.Script\$getSelectedElements"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.getSelectedElements()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getSelectedListItems() {
        "android.ext.Script\$getSelectedListItems"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.getSelectedListItems()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getSelectedResults() {
        "android.ext.Script\$getSelectedResults"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.getSelectedResults()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getSpeed() {
        "android.ext.Script\$getSpeed"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.getSpeed()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getTargetInfo() {
        "android.ext.Script\$getTargetInfo"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.getTargetInfo()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getTargetPackage() {
        "android.ext.Script\$getTargetPackage"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.getTargetPackage()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getValues() {
        "android.ext.Script\$getValues"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val values = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (filterParams && !GGUtil.isValidItems("$values")) {
                            sendLog("gg.getValues(过滤参数)")
                        } else {
                            val func = "gg.getValues($values)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getValuesRange() {
        "android.ext.Script\$getValuesRange"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val values = varArgs.checktable(1)
                        val func = "gg.getValuesRange($values)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun gotoAddress() {
        "android.ext.Script\$gotoAddress"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val address = varArgs.checklong(1)
                        val addressTmp = GGUtil.getHexValue(address as Long)
                        val func = "gg.gotoAddress($addressTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun hideUiButton() {
        "android.ext.Script\$hideUiButton"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.hideUiButton()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun internal1() {
        "android.ext.Script\$internal1"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val text = varArgs.checkstring(1)
                        val textTmp = GGUtil.getStringValue(text)
                        val memoryFrom = varArgs.optlong(2, 0L)
                        val memoryFromTmp = GGUtil.getHexValue(memoryFrom as Long)
                        val memoryTo = varArgs.optlong(3, -1L)
                        val memoryToTmp = GGUtil.getHexValue(memoryTo as Long)
                        val flags = if (varArgs.optlong(4, 1L) == 2L) 2 else 1
                        val func = "gg.internal1($textTmp, $memoryFromTmp, $memoryToTmp, $flags)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun internal2() {
        "android.ext.Script\$internal2"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val filename = varArgs.checkjstring(2)
                        val func = "gg.internal2(#func, $filename)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun internal3() {
        "android.ext.Script\$internal3"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val maxOffset = varArgs.checkint(1)
                        val memoryFrom = varArgs.optlong(2, 0L)
                        val memoryFromTmp = GGUtil.getHexValue(memoryFrom as Long)
                        val memoryTo = varArgs.optlong(3, -1L)
                        val memoryToTmp = GGUtil.getHexValue(memoryTo as Long)
                        val func = "gg.internal3($maxOffset, $memoryFromTmp, $memoryToTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun isClickedUiButton() {
        "android.ext.Script\$isClickedUiButton"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.isClickedUiButton()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun isPackageInstalled() {
        "android.ext.Script\$isPackageInstalled"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val pkg = varArgs.checkjstring(1)
                        val pkgTmp = GGUtil.getStringValue(pkg)
                        val func = "gg.isPackageInstalled($pkgTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun isProcessPaused() {
        "android.ext.Script\$isProcessPaused"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.isProcessPaused()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun isVisible() {
        "android.ext.Script\$isVisible"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.isVisible()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun loadList() {
        "android.ext.Script\$loadList"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val file = varArgs.checkjstring(1)
                        val fileTmp = GGUtil.getStringValue(file)
                        val flags = varArgs.optint(2, 0)
                        val flagsTmp = GGUtil.getConstValue(GGLib.CONST.LOAD, flags as Int)
                        val func = "gg.loadList($fileTmp, $flagsTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun loadResults() {
        "android.ext.Script\$loadResults"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val results = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (filterParams && !GGUtil.isValidItems("$results")) {
                            sendLog("gg.loadResults(过滤参数)")
                        } else {
                            val func = "gg.loadResults($results)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun makeRequest() {
        "android.ext.Script\$makeRequest"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val url = varArgs.checkjstring(1)
                        val urlTmp = GGUtil.getStringValue(url)
                        val headers = varArgs.opttable(2, null)
                        val data = varArgs.optstring(3, null)
                        val dataTmp = GGUtil.getStringValue(data)
                        val func = "gg.makeRequest($urlTmp, $headers, $dataTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun multiChoice() {
        "android.ext.Script\$multiChoice"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val items = varArgs.checktable(1)
                        val selection = varArgs.opttable(2, null)
                        val message = varArgs.optjstring(3, "nil")
                        val messageTmp = GGUtil.getStringValue(message)
                        val func = "gg.multiChoice($items, $selection, $messageTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun numberFromLocale() {
        "android.ext.Script\$numberFromLocale"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val num = varArgs.tojstring(1)
                        val numTmp = GGUtil.getStringValue(num)
                        val func = "gg.numberFromLocale($numTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun numberToLocale() {
        "android.ext.Script\$numberToLocale"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val num = varArgs.tojstring(1)
                        val numTmp = GGUtil.getStringValue(num)
                        val func = "gg.numberToLocale($numTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun processKill() {
        "android.ext.Script\$processKill"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.processKill()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun processPause() {
        "android.ext.Script\$processPause"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.processPause()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun processResume() {
        "android.ext.Script\$processResume"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.processResume()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun processToggle() {
        "android.ext.Script\$processToggle"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.processToggle()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun prompt() {
        "android.ext.Script\$prompt"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
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

    private fun removeListItems() {
        "android.ext.Script\$removeListItems"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val items = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (filterParams && !GGUtil.isValidItems("$items")) {
                            sendLog("gg.removeListItems(过滤参数)")
                        } else {
                            val func = "gg.removeListItems($items)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun removeResults() {
        "android.ext.Script\$removeResults"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val results = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (filterParams && !GGUtil.isValidItems("$results")) {
                            sendLog("gg.removeResults(过滤参数)")
                        } else {
                            val func = "gg.removeResults($results)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun require() {
        "android.ext.Script\$require"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val version = varArgs.optjstring(1, "0")
                        val versionTmp = GGUtil.getStringValue(version)
                        val build = varArgs.optint(2, 0)
                        val func = "gg.require($versionTmp, $build)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun saveList() {
        "android.ext.Script\$saveList"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val file = varArgs.checkjstring(1)
                        val fileTmp = GGUtil.getStringValue(file)
                        val flags = varArgs.optint(2, 0)
                        val flagsTmp = GGUtil.getConstValue(GGLib.CONST.SAVE, flags as Int)
                        val func = "gg.saveList($fileTmp, $flagsTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun saveVariable() {
        "android.ext.Script\$saveVariable"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val variable = varArgs.arg(1)
                        val filename = varArgs.checkjstring(2)
                        val filenameTmp = GGUtil.getStringValue(filename)
                        val func = "gg.saveVariable($variable, $filenameTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchAddress() {
        "android.ext.Script\$searchAddress"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val funcName = GGUtil.getFuncName(
                            instanceClass,
                            "android.ext.Script\$refineAddress".toClassOrNull(),
                            "gg.refineAddress",
                            "gg.searchAddress"
                        )
                        val varArgs = args(0).any()
                        val text = varArgs.checkjstring(1)
                        val textTmp = GGUtil.getStringValue(text)
                        val mask = varArgs.optlong(2, -1L)
                        val maskTmp = GGUtil.getHexValue(mask as Long)
                        val type = varArgs.optint(3, 127)
                        val typeTmp = GGUtil.getConstValue(GGLib.CONST.TYPE, type as Int)
                        val sign = varArgs.optint(4, 0x20000000)
                        val signTmp = GGUtil.getConstValue(GGLib.CONST.SIGN, sign as Int)
                        val memoryFrom = varArgs.optlong(5, 0L)
                        val memoryFromTmp = GGUtil.getHexValue(memoryFrom as Long)
                        val memoryTo = varArgs.optlong(6, -1L)
                        val memoryToTmp = GGUtil.getHexValue(memoryTo as Long)
                        val func =
                            "$funcName($textTmp, $maskTmp, $typeTmp, $signTmp, $memoryFromTmp, $memoryToTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchFuzzy() {
        "android.ext.Script\$searchFuzzy"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val difference = varArgs.optjstring(1, "0")
                        val differenceTmp = GGUtil.getStringValue(difference)
                        val sign = varArgs.optint(2, 0x20000000)
                        val signTmp = GGUtil.getConstValue(GGLib.CONST.SIGN_FUZZY, sign as Int)
                        val type = varArgs.optint(3, 127)
                        val typeTmp = GGUtil.getConstValue(GGLib.CONST.TYPE, type as Int)
                        val memoryFrom = varArgs.optlong(4, 0L)
                        val memoryFromTmp = GGUtil.getHexValue(memoryFrom as Long)
                        val memoryTo = varArgs.optlong(5, -1L)
                        val memoryToTmp = GGUtil.getHexValue(memoryTo as Long)
                        val func =
                            "gg.searchFuzzy($differenceTmp, $signTmp, $typeTmp, $memoryFromTmp, $memoryToTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchNumber() {
        "android.ext.Script\$searchNumber"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val funcName = GGUtil.getFuncName(
                            instanceClass,
                            "android.ext.Script\$refineNumber".toClassOrNull(),
                            "gg.refineNumber",
                            "gg.searchNumber"
                        )
                        val varArgs = args(0).any()
                        val text = varArgs.checkjstring(1)
                        val textTmp = GGUtil.getStringValue(text)
                        val type = varArgs.optint(2, 127)
                        val typeTmp = GGUtil.getConstValue(GGLib.CONST.TYPE, type as Int)
                        val encrypted = varArgs.optboolean(3, false)
                        val sign = varArgs.optint(4, 0x20000000)
                        val signTmp = GGUtil.getConstValue(GGLib.CONST.SIGN, sign as Int)
                        val memoryFrom = varArgs.optlong(5, 0L)
                        val memoryFromTmp = GGUtil.getHexValue(memoryFrom as Long)
                        val memoryTo = varArgs.optlong(6, -1L)
                        val memoryToTmp = GGUtil.getHexValue(memoryTo as Long)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (filterParams && !GGUtil.isValidParams("$text")) {
                            sendLog("$funcName(过滤参数)")
                        } else {
                            val func =
                                "$funcName($textTmp, $typeTmp, $encrypted, $signTmp, $memoryFromTmp, $memoryToTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun setRanges() {
        "android.ext.Script\$setRanges"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val ranges = varArgs.checkint(1)
                        val rangesTmp = GGUtil.getConstValue(GGLib.CONST.REGION, ranges as Int)
                        val func = "gg.setRanges($rangesTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun setSpeed() {
        "android.ext.Script\$setSpeed"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val speed = varArgs.checkdouble(1)
                        val func = "gg.setSpeed($speed)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun setValues() {
        "android.ext.Script\$setValues"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val values = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (filterParams && !GGUtil.isValidItems("$values")) {
                            sendLog("gg.setValues(过滤参数)")
                        } else {
                            val func = "gg.setValues($values)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun setVisible() {
        "android.ext.Script\$setVisible"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val visible = varArgs.checkboolean(1)
                        val func = "gg.setVisible($visible)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun showUiButton() {
        "android.ext.Script\$showUiButton"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.showUiButton()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun skipRestoreState() {
        "android.ext.Script\$skipRestoreState"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val func = "gg.skipRestoreState()"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun sleep() {
        "android.ext.Script\$sleep"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val milliseconds = varArgs.checkint(1)
                        val func = "gg.sleep($milliseconds)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun startFuzzy() {
        "android.ext.Script\$startFuzzy"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val type = varArgs.optint(1, 127)
                        val typeTmp = GGUtil.getConstValue(GGLib.CONST.TYPE, type as Int)
                        val memoryFrom = varArgs.optlong(2, 0L)
                        val memoryFromTmp = GGUtil.getHexValue(memoryFrom as Long)
                        val memoryTo = varArgs.optlong(3, -1L)
                        val memoryToTmp = GGUtil.getHexValue(memoryTo as Long)
                        val func = "gg.startFuzzy($typeTmp, $memoryFromTmp, $memoryToTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun timeJump() {
        "android.ext.Script\$timeJump"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val time = varArgs.checkjstring(1)
                        val timeTmp = GGUtil.getStringValue(time)
                        val func = "gg.timeJump($timeTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun toast() {
        "android.ext.Script\$toast"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val text = varArgs.checkjstring(1)
                        val textTmp = GGUtil.getStringValue(text)
                        val fast = varArgs.optboolean(2, false)
                        val func = "gg.toast($textTmp, $fast)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun unrandomizer() {
        "android.ext.Script\$unrandomizer"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val qword = varArgs.optlong(1, 0L)
                        val qincr = varArgs.optlong(2, 0L)
                        val double_ = varArgs.optdouble(3, 0.0)
                        val dincr = varArgs.optdouble(4, 0.0)
                        val func = "gg.unrandomizer($qword, $qincr, $double_, $dincr)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }
}