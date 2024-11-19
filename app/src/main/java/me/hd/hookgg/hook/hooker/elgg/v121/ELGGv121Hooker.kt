package me.hd.hookgg.hook.hooker.elgg.v121

import com.highcapable.yukihookapi.hook.factory.method
import me.hd.hookgg.R
import me.hd.hookgg.data.SetPrefsData
import me.hd.hookgg.data.bean.FuncDetail
import me.hd.hookgg.data.lib.GGLib
import me.hd.hookgg.hook.base.BaseGGHooker
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121VarArgs.arg
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121VarArgs.checkboolean
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121VarArgs.checkdouble
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121VarArgs.checkint
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121VarArgs.checkjstring
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121VarArgs.checklong
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121VarArgs.checktable
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121VarArgs.optboolean
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121VarArgs.optdouble
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121VarArgs.optint
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121VarArgs.optjstring
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121VarArgs.optlong
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121VarArgs.optstring
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121VarArgs.opttable
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121VarArgs.tojstring
import me.hd.hookgg.hook.utils.GGUtil
import me.hd.hookgg.hook.utils.getString

object ELGGv121Hooker : BaseGGHooker() {
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
        GGLib.searchPointer to FuncDetail { this.searchPointer() },
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
        "android.ext.ۣۧۧ۟"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val items = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (filterParams && !GGUtil.isValidItemsLength("$items")) {
                            sendLog("gg.addListItems(${getString(R.string.filter_invalid_length)})")
                        } else {
                            val func = "gg.addListItems($items)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun alert() {
        "android.ext.۟ۧ۠ۡ۟"
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
        "android.ext.۟ۧ۠ۡۢ"
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
        "android.ext.ۣ۟ۧ۠ۡ"
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
        "android.ext.۟ۧ۠ۡۨ"
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
        "android.ext.۟ۧ۠۠ۨ"
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
        "android.ext.ۦۤ۟ۦ"
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
        "android.ext.ۧۧۢۧ"
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
        "android.ext.ۧۧۢۤ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val text = varArgs.checkjstring(1)
                        val textStr = ELGGv121Util.decryptText(text as String)
                        val textTmp = GGUtil.getStringValue(textStr)
                        val fixLocale = varArgs.optboolean(2, true)
                        val func = "gg.copyText($textTmp, $fixLocale)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun disasm() {
        "android.ext.ۦۤ۟ۢ"
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
        "android.ext.ۧۧۢ۠"
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
        "android.ext.ۦۤ۟۠"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val value = varArgs.checkjstring(1)
                        val valueStr = ELGGv121Util.decryptText(value as String)
                        val valueTmp = GGUtil.getStringValue(valueStr)
                        val type = varArgs.checkint(2)
                        val typeTmp = GGUtil.getConstValue(GGLib.CONST.TYPE, type as Int)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (filterParams) {
                            if (!GGUtil.isValidParamsLength("$value")) {
                                sendLog("gg.editAll(${getString(R.string.filter_invalid_length)})")
                            } else if (!GGUtil.isValidParams("$value")) {
                                sendLog("gg.editAll(${getString(R.string.filter_invalid_params)})")
                            }
                        } else {
                            val func = "gg.editAll($valueTmp, $typeTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getActiveTab() {
        "android.ext.۟ۧ۠ۢ۠"
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
        "android.ext.۟ۧ۠ۢۦ"
            .toClassOrNull()?.apply {
                method {
                    name = "a_"
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
        "android.ext.۟ۧ۠ۢۨ"
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
        "android.ext.ۧۧۡۧ"
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
        "android.ext.ۧۧۡۦ"
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
        "android.ext.ۣۧۧۡ"
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
        "android.ext.ۧۧۡۢ"
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
        "android.ext.ۦۤۢۡ"
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
        "android.ext.ۥۡ۟۠"
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
        "android.ext.ۥۡ۟۟"
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
        "android.ext.ۧۧۥۤ"
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
        "android.ext.ۥۡ۟ۢ"
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
        "android.ext.ۦۤۢۢ"
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
        "android.ext.ۧۧۥۢ"
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
        "android.ext.ۣ۟ۧ۠۠"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val values = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (filterParams && !GGUtil.isValidItemsLength("$values")) {
                            sendLog("gg.getValues(${getString(R.string.filter_invalid_length)})")
                        } else {
                            val func = "gg.getValues($values)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getValuesRange() {
        "android.ext.ۣ۟ۧ۠۟"
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
        "android.ext.ۣ۟ۧ۠ۡ"
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
        "android.ext.ۣ۟ۧ۠ۥ"
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

    private fun isClickedUiButton() {
        "android.ext.ۦۤۡۤ"
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
        "android.ext.ۧۧۤۧ"
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
        "android.ext.ۦۤۡۦ"
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
        "android.ext.ۧۧۤۥ"
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
        "android.ext.ۧۧۤۢ"
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
        "android.ext.ۣۧۧۤ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val results = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (filterParams && !GGUtil.isValidItemsLength("$results")) {
                            sendLog("gg.loadResults(${getString(R.string.filter_invalid_length)})")
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
        "android.ext.ۦۤۡۢ"
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
        "android.ext.۟ۧ۠ۤ۟"
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
        "android.ext.ۧۧۤۡ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val num = varArgs.tojstring(1)
                        val numStr = ELGGv121Util.decryptText(num as String)
                        val numTmp = GGUtil.getStringValue(numStr)
                        val func = "gg.numberToLocale($numTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun processKill() {
        "android.ext.۟ۧ۠ۤۦ"
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
        "android.ext.۟ۧ۠ۤۨ"
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
        "android.ext.ۦۤ۠ۧ"
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
        "android.ext.ۦۤ۠ۦ"
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
        "android.ext.ۦۣۤ۠"
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
        "android.ext.ۥۡۡۡ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val items = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (filterParams && !GGUtil.isValidItemsLength("$items")) {
                            sendLog("gg.removeListItems(${getString(R.string.filter_invalid_length)})")
                        } else {
                            val func = "gg.removeListItems($items)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun removeResults() {
        "android.ext.ۣۧۧۧ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val results = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (filterParams && !GGUtil.isValidItemsLength("$results")) {
                            sendLog("gg.removeResults(${getString(R.string.filter_invalid_length)})")
                        } else {
                            val func = "gg.removeResults($results)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun require() {
        "android.ext.۟ۧ۠ۥ۠"
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
        "android.ext.ۥۡۡۤ"
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
        "android.ext.ۦۤۤۥ"
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
        "android.ext.ۣۧۧۦ"
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
                        val textStr = ELGGv121Util.decryptText(text as String)
                        val textTmp = GGUtil.getStringValue(textStr)
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
                        val func =
                            "$funcName($textTmp, $maskTmp, $typeTmp, $signTmp, $memoryFromTmp, $memoryToTmp, $limit)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchFuzzy() {
        "android.ext.ۧۧۧۡ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val difference = varArgs.optjstring(1, "0")
                        val differenceStr = ELGGv121Util.decryptText(difference as String)
                        val differenceTmp = GGUtil.getStringValue(differenceStr)
                        val sign = varArgs.optint(2, 0x20000000)
                        val signTmp = GGUtil.getConstValue(GGLib.CONST.SIGN_FUZZY, sign as Int)
                        val type = varArgs.optint(3, 127)
                        val typeTmp = GGUtil.getConstValue(GGLib.CONST.TYPE, type as Int)
                        val memoryFrom = varArgs.optlong(4, 0L)
                        val memoryFromTmp = GGUtil.getHexValue(memoryFrom as Long)
                        val memoryTo = varArgs.optlong(5, -1L)
                        val memoryToTmp = GGUtil.getHexValue(memoryTo as Long)
                        val limit = varArgs.optlong(6, 0L)
                        val func =
                            "gg.searchFuzzy($differenceTmp, $signTmp, $typeTmp, $memoryFromTmp, $memoryToTmp, $limit)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchNumber() {
        "android.ext.ۦۤ۠ۥ"
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
                        val textStr = ELGGv121Util.decryptText(text as String)
                        val textTmp = GGUtil.getStringValue(textStr)
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
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (filterParams) {
                            if (!GGUtil.isValidParamsLength("$text")) {
                                sendLog("$funcName(${getString(R.string.filter_invalid_length)})")
                            } else if (!GGUtil.isValidParams("$text")) {
                                sendLog("$funcName(${getString(R.string.filter_invalid_params)})")
                            }
                        } else {
                            val func =
                                "$funcName($textTmp, $typeTmp, $encrypted, $signTmp, $memoryFromTmp, $memoryToTmp, $limit)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchPointer() {
        "android.ext.ۦۤۤ۟"
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
                        val limit = varArgs.optlong(4, 0L)
                        val func =
                            "gg.searchPointer($maxOffset, $memoryFromTmp, $memoryToTmp, $limit)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun setRanges() {
        "android.ext.ۥۡۡ۟"
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
        "android.ext.۟ۧ۠ۥۥ"
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
                        if (filterParams && !GGUtil.isValidItemsLength("$values")) {
                            sendLog("gg.setValues(${getString(R.string.filter_invalid_length)})")
                        } else {
                            val func = "gg.setValues($values)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun setVisible() {
        "android.ext.۟ۧ۠ۥۧ"
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
        "android.ext.ۥۡ۠ۨ"
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
        "android.ext.ۥۡ۠ۥ"
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
        "android.ext.ۧۧۦۨ"
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
        "android.ext.ۦۣۤۦ"
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
        "android.ext.ۥۡ۠ۧ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val time = varArgs.checkjstring(1)
                        val timeStr = ELGGv121Util.decryptText(time as String)
                        val timeTmp = GGUtil.getStringValue(timeStr)
                        val func = "gg.timeJump($timeTmp)"
                        sendLog(func, result)
                    }
                }.ignoredAllFailure()
            }
    }

    private fun toast() {
        "android.ext.ۥۡ۠ۡ"
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
        "android.ext.ۦۣۤۢ"
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