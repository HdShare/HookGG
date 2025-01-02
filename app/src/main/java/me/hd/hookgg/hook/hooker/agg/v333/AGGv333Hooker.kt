package me.hd.hookgg.hook.hooker.agg.v333

import com.highcapable.yukihookapi.hook.factory.method
import me.hd.hookgg.config.data.ResStrData.FILTER_INVALID_LENGTH
import me.hd.hookgg.config.data.ResStrData.FILTER_INVALID_PARAMS
import me.hd.hookgg.config.data.ResStrData.getResStr
import me.hd.hookgg.config.bean.FuncDetail
import me.hd.hookgg.config.lib.GGLib
import me.hd.hookgg.hook.base.BaseGGHooker
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333VarArgs.arg
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333VarArgs.checkboolean
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333VarArgs.checkdouble
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333VarArgs.checkint
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333VarArgs.checkjstring
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333VarArgs.checklong
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333VarArgs.checktable
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333VarArgs.optboolean
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333VarArgs.optdouble
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333VarArgs.optint
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333VarArgs.optjstring
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333VarArgs.optlong
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333VarArgs.optstring
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333VarArgs.opttable
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333VarArgs.tojstring
import me.hd.hookgg.hook.utils.GGUtil

object AGGv333Hooker : BaseGGHooker() {
    override val functionMap = mapOf(
        GGLib.addListItems to FuncDetail { this.addListItems() },
        GGLib.alert to FuncDetail { this.alert() },
        GGLib.allocatePage to FuncDetail { this.allocatePage() },
        GGLib.bytes to FuncDetail { this.bytes() },
        GGLib.choice to FuncDetail { this.choice() },
        GGLib.clearList to FuncDetail { this.clearList() },
        GGLib.clearResults to FuncDetail { this.clearResults() },
        GGLib.copyMemory to FuncDetail { this.copyMemory() },
        GGLib.copyText to FuncDetail { this.copyText() },
        GGLib.disasm to FuncDetail { this.disasm() },
        GGLib.dumpMemory to FuncDetail { this.dumpMemory() },
        GGLib.editAll to FuncDetail { this.editAll() },
        GGLib.getActiveTab to FuncDetail { this.getActiveTab() },
        GGLib.getFile to FuncDetail { this.getFile() },
        GGLib.getLine to FuncDetail { this.getLine() },
        GGLib.getListItems to FuncDetail { this.getListItems() },
        GGLib.getLocale to FuncDetail { this.getLocale() },
        GGLib.getRanges to FuncDetail { this.getRanges() },
        GGLib.getRangesList to FuncDetail { this.getRangesList() },
        GGLib.getResults to FuncDetail { this.getResults() },
        GGLib.getResultsCount to FuncDetail { this.getResultsCount() },
        GGLib.getSelectedElements to FuncDetail { this.getSelectedElements() },
        GGLib.getSelectedListItems to FuncDetail { this.getSelectedListItems() },
        GGLib.getSelectedResults to FuncDetail { this.getSelectedResults() },
        GGLib.getSpeed to FuncDetail { this.getSpeed() },
        GGLib.getTargetInfo to FuncDetail { this.getTargetInfo() },
        GGLib.getTargetPackage to FuncDetail { this.getTargetPackage() },
        GGLib.getValues to FuncDetail { this.getValues() },
        GGLib.getValuesRange to FuncDetail { this.getValuesRange() },
        GGLib.gotoAddress to FuncDetail { this.gotoAddress() },
        GGLib.hideUiButton to FuncDetail { this.hideUiButton() },
        GGLib.isClickedUiButton to FuncDetail { this.isClickedUiButton() },
        GGLib.isPackageInstalled to FuncDetail { this.isPackageInstalled() },
        GGLib.isProcessPaused to FuncDetail { this.isProcessPaused() },
        GGLib.isVisible to FuncDetail { this.isVisible() },
        GGLib.loadList to FuncDetail { this.loadList() },
        GGLib.loadResults to FuncDetail { this.loadResults() },
        GGLib.makeRequest to FuncDetail { this.makeRequest() },
        GGLib.multiChoice to FuncDetail { this.multiChoice() },
        GGLib.numberFromLocale to FuncDetail { this.numberFromLocale() },
        GGLib.numberToLocale to FuncDetail { this.numberToLocale() },
        GGLib.processKill to FuncDetail { this.processKill() },
        GGLib.processPause to FuncDetail { this.processPause() },
        GGLib.processResume to FuncDetail { this.processResume() },
        GGLib.processToggle to FuncDetail { this.processToggle() },
        GGLib.prompt to FuncDetail { this.prompt() },
        GGLib.removeListItems to FuncDetail { this.removeListItems() },
        GGLib.removeResults to FuncDetail { this.removeResults() },
        GGLib.require to FuncDetail { this.require() },
        GGLib.saveList to FuncDetail { this.saveList() },
        GGLib.saveVariable to FuncDetail { this.saveVariable() },
        GGLib.searchAddress to FuncDetail { this.searchAddress() },
        GGLib.searchFuzzy to FuncDetail { this.searchFuzzy() },
        GGLib.searchNumber to FuncDetail { this.searchNumber() },
        GGLib.setRanges to FuncDetail { this.setRanges() },
        GGLib.setSpeed to FuncDetail { this.setSpeed() },
        GGLib.setValues to FuncDetail { this.setValues() },
        GGLib.setVisible to FuncDetail { this.setVisible() },
        GGLib.showUiButton to FuncDetail { this.showUiButton() },
        GGLib.skipRestoreState to FuncDetail { this.skipRestoreState() },
        GGLib.sleep to FuncDetail { this.sleep() },
        GGLib.startFuzzy to FuncDetail { this.startFuzzy() },
        GGLib.timeJump to FuncDetail { this.timeJump() },
        GGLib.toast to FuncDetail { this.toast() },
        GGLib.unrandomizer to FuncDetail { this.unrandomizer() },
    )

    private fun addListItems() {
        "android.ext.function.addListItems"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.alert"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.allocatePage"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.bytes"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.choice"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.clearList"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.clearResults"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.copyMemory"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.copyText"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.disasm"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.dumpMemory"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.editAll"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.getActiveTab"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.getFile"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.getLine"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.getListItems"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.getLocale"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.getRanges"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.getRangesList"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.getResults"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.getResultsCount"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.getSelectedElements"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.getSelectedListItems"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.getSelectedResults"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.getSpeed"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.getTargetInfo"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.getTargetPackage"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.getValues"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.getValuesRange"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.gotoAddress"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.hideUiButton"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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

    private fun isClickedUiButton() {
        "android.ext.function.isClickedUiButton"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.isPackageInstalled"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.isProcessPaused"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.isVisible"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.loadList"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.loadResults"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.makeRequest"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.multiChoice"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.numberFromLocale"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.numberToLocale"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.processKill"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.processPause"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.processResume"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.processToggle"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.prompt"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.removeListItems"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.removeResults"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.require"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.saveList"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.saveVariable"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.searchAddress"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
                        sendLog(
                            "$funcName($textTmp, $maskTmp, $typeTmp, $signTmp, $memoryFromTmp, $memoryToTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchFuzzy() {
        "android.ext.function.searchFuzzy"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
                        sendLog(
                            "gg.searchFuzzy($differenceTmp, $signTmp, $typeTmp, $memoryFromTmp, $memoryToTmp)",
                            if (printReturn) "--[[$result]]" else ""
                        )
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchNumber() {
        "android.ext.function.searchNumber"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
                        sendLog(
                            if (filterParams) {
                                if (!GGUtil.isValidParamsLength("$text")) {
                                    "$funcName(${getResStr(FILTER_INVALID_LENGTH)})"
                                } else if (!GGUtil.isValidParams("$text")) {
                                    "$funcName(${getResStr(FILTER_INVALID_PARAMS)})"
                                } else {
                                    "$funcName($textTmp, $typeTmp, $encrypted, $signTmp, $memoryFromTmp, $memoryToTmp)"
                                }
                            } else {
                                "$funcName($textTmp, $typeTmp, $encrypted, $signTmp, $memoryFromTmp, $memoryToTmp)"
                            },
                            if (printReturn) "--[[$result]]" else ""
                        )
                    }
                }.ignoredAllFailure()
            }
    }

    private fun setRanges() {
        "android.ext.function.setRanges"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.setSpeed"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.setValues"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.setVisible"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.showUiButton"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.skipRestoreState"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.sleep"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.startFuzzy"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.timeJump"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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
        "android.ext.function.toast"
            .toClassOrNull()?.apply {
                method {
                    name = "invoke2"
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
        "android.ext.function.unrandomizer"
            .toClassOrNull()?.apply {
                method {
                    name = "invokeUi"
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