package me.hd.hookgg.hook.hooker.gg.v980

import com.highcapable.yukihookapi.hook.factory.method
import me.hd.hookgg.config.bean.FuncObj
import me.hd.hookgg.config.data.ResStrData.FILTER_INVALID_LENGTH
import me.hd.hookgg.config.data.ResStrData.FILTER_INVALID_PARAMS
import me.hd.hookgg.config.data.ResStrData.getResStr
import me.hd.hookgg.config.lib.GGLib
import me.hd.hookgg.config.lib.LibType
import me.hd.hookgg.hook.base.BaseGGHooker
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.arg
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.checkboolean
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.checkdouble
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.checkint
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.checkjstring
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.checklong
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.checkstring
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.checktable
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.optboolean
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.optdouble
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.optint
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.optjstring
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.optlong
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.optstring
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.opttable
import me.hd.hookgg.hook.hooker.gg.v980.GGv980VarArgs.tojstring
import me.hd.hookgg.hook.utils.GGUtil

object GGv980Hooker : BaseGGHooker() {
    override val functionMap = mapOf(
        GGLib.addListItems to FuncObj.FuncDetail(libType = LibType.GGLib) { addListItems() },
        GGLib.alert to FuncObj.FuncDetail(libType = LibType.GGLib) { alert() },
        GGLib.allocatePage to FuncObj.FuncDetail(libType = LibType.GGLib) { allocatePage() },
        GGLib.bytes to FuncObj.FuncDetail(libType = LibType.GGLib) { bytes() },
        GGLib.choice to FuncObj.FuncDetail(libType = LibType.GGLib) { choice() },
        GGLib.clearList to FuncObj.FuncDetail(libType = LibType.GGLib) { clearList() },
        GGLib.clearResults to FuncObj.FuncDetail(libType = LibType.GGLib) { clearResults() },
        GGLib.copyMemory to FuncObj.FuncDetail(libType = LibType.GGLib) { copyMemory() },
        GGLib.copyText to FuncObj.FuncDetail(libType = LibType.GGLib) { copyText() },
        GGLib.disasm to FuncObj.FuncDetail(libType = LibType.GGLib) { disasm() },
        GGLib.dumpMemory to FuncObj.FuncDetail(libType = LibType.GGLib) { dumpMemory() },
        GGLib.editAll to FuncObj.FuncDetail(libType = LibType.GGLib) { editAll() },
        GGLib.getActiveTab to FuncObj.FuncDetail(libType = LibType.GGLib) { getActiveTab() },
        GGLib.getFile to FuncObj.FuncDetail(libType = LibType.GGLib) { getFile() },
        GGLib.getLine to FuncObj.FuncDetail(libType = LibType.GGLib) { getLine() },
        GGLib.getListItems to FuncObj.FuncDetail(libType = LibType.GGLib) { getListItems() },
        GGLib.getLocale to FuncObj.FuncDetail(libType = LibType.GGLib) { getLocale() },
        GGLib.getRanges to FuncObj.FuncDetail(libType = LibType.GGLib) { getRanges() },
        GGLib.getRangesList to FuncObj.FuncDetail(libType = LibType.GGLib) { getRangesList() },
        GGLib.getResults to FuncObj.FuncDetail(libType = LibType.GGLib) { getResults() },
        GGLib.getResultsCount to FuncObj.FuncDetail(libType = LibType.GGLib) { getResultsCount() },
        GGLib.getSelectedElements to FuncObj.FuncDetail(libType = LibType.GGLib) { getSelectedElements() },
        GGLib.getSelectedListItems to FuncObj.FuncDetail(libType = LibType.GGLib) { getSelectedListItems() },
        GGLib.getSelectedResults to FuncObj.FuncDetail(libType = LibType.GGLib) { getSelectedResults() },
        GGLib.getSpeed to FuncObj.FuncDetail(libType = LibType.GGLib) { getSpeed() },
        GGLib.getTargetInfo to FuncObj.FuncDetail(libType = LibType.GGLib) { getTargetInfo() },
        GGLib.getTargetPackage to FuncObj.FuncDetail(libType = LibType.GGLib) { getTargetPackage() },
        GGLib.getValues to FuncObj.FuncDetail(libType = LibType.GGLib) { getValues() },
        GGLib.getValuesRange to FuncObj.FuncDetail(libType = LibType.GGLib) { getValuesRange() },
        GGLib.gotoAddress to FuncObj.FuncDetail(libType = LibType.GGLib) { gotoAddress() },
        GGLib.hideUiButton to FuncObj.FuncDetail(libType = LibType.GGLib) { hideUiButton() },
        GGLib.internal1 to FuncObj.FuncDetail(libType = LibType.GGLib) { internal1() },
        GGLib.internal2 to FuncObj.FuncDetail(libType = LibType.GGLib) { internal2() },
        GGLib.isClickedUiButton to FuncObj.FuncDetail(libType = LibType.GGLib) { isClickedUiButton() },
        GGLib.isPackageInstalled to FuncObj.FuncDetail(libType = LibType.GGLib) { isPackageInstalled() },
        GGLib.isProcessPaused to FuncObj.FuncDetail(libType = LibType.GGLib) { isProcessPaused() },
        GGLib.isVisible to FuncObj.FuncDetail(libType = LibType.GGLib) { isVisible() },
        GGLib.loadList to FuncObj.FuncDetail(libType = LibType.GGLib) { loadList() },
        GGLib.loadResults to FuncObj.FuncDetail(libType = LibType.GGLib) { loadResults() },
        GGLib.makeRequest to FuncObj.FuncDetail(libType = LibType.GGLib) { makeRequest() },
        GGLib.multiChoice to FuncObj.FuncDetail(libType = LibType.GGLib) { multiChoice() },
        GGLib.numberFromLocale to FuncObj.FuncDetail(libType = LibType.GGLib) { numberFromLocale() },
        GGLib.numberToLocale to FuncObj.FuncDetail(libType = LibType.GGLib) { numberToLocale() },
        GGLib.processKill to FuncObj.FuncDetail(libType = LibType.GGLib) { processKill() },
        GGLib.processPause to FuncObj.FuncDetail(libType = LibType.GGLib) { processPause() },
        GGLib.processResume to FuncObj.FuncDetail(libType = LibType.GGLib) { processResume() },
        GGLib.processToggle to FuncObj.FuncDetail(libType = LibType.GGLib) { processToggle() },
        GGLib.prompt to FuncObj.FuncDetail(libType = LibType.GGLib) { prompt() },
        GGLib.removeListItems to FuncObj.FuncDetail(libType = LibType.GGLib) { removeListItems() },
        GGLib.removeResults to FuncObj.FuncDetail(libType = LibType.GGLib) { removeResults() },
        GGLib.require to FuncObj.FuncDetail(libType = LibType.GGLib) { require() },
        GGLib.saveList to FuncObj.FuncDetail(libType = LibType.GGLib) { saveList() },
        GGLib.saveVariable to FuncObj.FuncDetail(libType = LibType.GGLib) { saveVariable() },
        GGLib.searchAddress to FuncObj.FuncDetail(libType = LibType.GGLib) { searchAddress() },
        GGLib.searchFuzzy to FuncObj.FuncDetail(libType = LibType.GGLib) { searchFuzzy() },
        GGLib.searchNumber to FuncObj.FuncDetail(libType = LibType.GGLib) { searchNumber() },
        GGLib.setRanges to FuncObj.FuncDetail(libType = LibType.GGLib) { setRanges() },
        GGLib.setSpeed to FuncObj.FuncDetail(libType = LibType.GGLib) { setSpeed() },
        GGLib.setValues to FuncObj.FuncDetail(libType = LibType.GGLib) { setValues() },
        GGLib.setVisible to FuncObj.FuncDetail(libType = LibType.GGLib) { setVisible() },
        GGLib.showUiButton to FuncObj.FuncDetail(libType = LibType.GGLib) { showUiButton() },
        GGLib.skipRestoreState to FuncObj.FuncDetail(libType = LibType.GGLib) { skipRestoreState() },
        GGLib.sleep to FuncObj.FuncDetail(libType = LibType.GGLib) { sleep() },
        GGLib.startFuzzy to FuncObj.FuncDetail(libType = LibType.GGLib) { startFuzzy() },
        GGLib.timeJump to FuncObj.FuncDetail(libType = LibType.GGLib) { timeJump() },
        GGLib.toast to FuncObj.FuncDetail(libType = LibType.GGLib) { toast() },
        GGLib.unrandomizer to FuncObj.FuncDetail(libType = LibType.GGLib) { unrandomizer() },
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
                        sendLog(
                            if (filterParams) {
                                if (!GGUtil.isValidItemsLength("$items")) {
                                    "gg.addListItems(${getResStr(FILTER_INVALID_LENGTH)})"
                                } else {
                                    "gg.addListItems($items)"
                                }
                            } else {
                                "gg.addListItems($items)"
                            },
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.alert($textTmp, $positiveTmp, $negativeTmp, $neutralTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.allocatePage($modeTmp, $addressTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.bytes($textTmp, $encodingTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.choice($items, $selected, $messageTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.clearList()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.clearResults()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.copyMemory($fromTmp, $toTmp, $bytes)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.copyText($textTmp, $fixLocale)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.disasm($typeTmp, $addressTmp, $opcode)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.dumpMemory($fromTmp, $toTmp, $dirTmp, $flagsTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            if (filterParams) {
                                if (!GGUtil.isValidParamsLength("$value")) {
                                    "gg.editAll(${getResStr(FILTER_INVALID_LENGTH)})"
                                } else if (!GGUtil.isValidParams("$value")) {
                                    "gg.editAll(${getResStr(FILTER_INVALID_PARAMS)})"
                                } else {
                                    "gg.editAll($valueTmp, $typeTmp)"
                                }
                            } else {
                                "gg.editAll($valueTmp, $typeTmp)"
                            },
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getActiveTab()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getFile()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getLine()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getListItems()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getLocale()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getRanges()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getRangesList($filterTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getResults($maxCount, $skip, $addressMinTmp, $addressMaxTmp, $valueMinTmp, $valueMaxTmp, $typeTmp, $fractionalTmp, $pointerTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getResultsCount()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getSelectedElements()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getSelectedListItems()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getSelectedResults()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getSpeed()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getTargetInfo()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getTargetPackage()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            if (filterParams) {
                                if (!GGUtil.isValidItemsLength("$values")) {
                                    "gg.getValues(${getResStr(FILTER_INVALID_LENGTH)})"
                                } else {
                                    "gg.getValues($values)"
                                }
                            } else {
                                "gg.getValues($values)"
                            },
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.getValuesRange($values)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.gotoAddress($addressTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.hideUiButton()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.internal1($textTmp, $memoryFromTmp, $memoryToTmp, $flags)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.internal2(#func, $filename)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.isClickedUiButton()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.isPackageInstalled($pkgTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.isProcessPaused()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.isVisible()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.loadList($fileTmp, $flagsTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            if (filterParams) {
                                if (!GGUtil.isValidItemsLength("$results")) {
                                    "gg.loadResults(${getResStr(FILTER_INVALID_LENGTH)})"
                                } else {
                                    "gg.loadResults($results)"
                                }
                            } else {
                                "gg.loadResults($results)"
                            },
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.makeRequest($urlTmp, $headers, $dataTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.multiChoice($items, $selection, $messageTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.numberFromLocale($numTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.numberToLocale($numTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.processKill()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.processPause()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.processResume()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.processToggle()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.prompt($items, $defaults, $types)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            if (filterParams) {
                                if (!GGUtil.isValidItemsLength("$items")) {
                                    "gg.removeListItems(${getResStr(FILTER_INVALID_LENGTH)})"
                                } else {
                                    "gg.removeListItems($items)"
                                }
                            } else {
                                "gg.removeListItems($items)"
                            },
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            if (filterParams) {
                                if (!GGUtil.isValidItemsLength("$results")) {
                                    "gg.removeResults(${getResStr(FILTER_INVALID_LENGTH)})"
                                } else {
                                    "gg.removeResults($results)"
                                }
                            } else {
                                "gg.removeResults($results)"
                            },
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.require($versionTmp, $build)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.saveList($fileTmp, $flagsTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.saveVariable($variable, $filenameTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        val limit = varArgs.optlong(7, 0L)
                        sendLog(
                            "$funcName($textTmp, $maskTmp, $typeTmp, $signTmp, $memoryFromTmp, $memoryToTmp, $limit)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        val limit = varArgs.optlong(6, 0L)
                        sendLog(
                            "gg.searchFuzzy($differenceTmp, $signTmp, $typeTmp, $memoryFromTmp, $memoryToTmp, $limit)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        val limit = varArgs.optlong(7, 0L)
                        sendLog(
                            if (filterParams) {
                                if (!GGUtil.isValidParamsLength("$text")) {
                                    "$funcName(${getResStr(FILTER_INVALID_LENGTH)})"
                                } else if (!GGUtil.isValidParams("$text")) {
                                    "$funcName(${getResStr(FILTER_INVALID_PARAMS)})"
                                } else {
                                    "$funcName($textTmp, $typeTmp, $encrypted, $signTmp, $memoryFromTmp, $memoryToTmp, $limit)"
                                }
                            } else {
                                "$funcName($textTmp, $typeTmp, $encrypted, $signTmp, $memoryFromTmp, $memoryToTmp, $limit)"
                            },
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.setRanges($rangesTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.setSpeed($speed)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            if (filterParams) {
                                if (!GGUtil.isValidItemsLength("$values")) {
                                    "gg.setValues(${getResStr(FILTER_INVALID_LENGTH)})"
                                } else {
                                    "gg.setValues($values)"
                                }
                            } else {
                                "gg.setValues($values)"
                            },
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.setVisible($visible)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.showUiButton()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.skipRestoreState()",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.sleep($milliseconds)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.startFuzzy($typeTmp, $memoryFromTmp, $memoryToTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.timeJump($timeTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        sendLog(
                            "gg.toast($textTmp, $fast)",
                            if (printReturn) "--[[$result]]" else ""
                        )
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
                        val double = varArgs.optdouble(3, 0.0)
                        val dincr = varArgs.optdouble(4, 0.0)
                        sendLog(
                            "gg.unrandomizer($qword, $qincr, $double, $dincr)",
                            if (printReturn) "--[[$result]]" else ""
                        )
                    }
                }.ignoredAllFailure()
            }
    }
}