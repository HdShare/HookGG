package me.hd.hookgg.hook.hooker.elgg.v120

import com.highcapable.yukihookapi.hook.factory.method
import kotlinx.coroutines.launch
import me.hd.hookgg.data.SetPrefsData
import me.hd.hookgg.data.func.GG
import me.hd.hookgg.hook.base.BaseGGHooker
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.arg
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.checkboolean
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.checkdouble
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.checkint
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.checkjstring
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.checklong
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.checktable
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.optboolean
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.optdouble
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.optint
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.optjstring
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.optlong
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.optstring
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.opttable
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120VarArgs.tojstring
import me.hd.hookgg.hook.utils.GGUtil

object ELGGv120Hooker : BaseGGHooker() {
    override val functionMap = mapOf(
        GG.addListItems to { this.addListItems() },
        GG.alert to { this.alert() },
        GG.allocatePage to { this.allocatePage() },
        GG.bytes to { this.bytes() },
        GG.choice to { this.choice() },
        GG.clearList to { this.clearList() },
        GG.clearResults to { this.clearResults() },
        GG.copyMemory to { this.copyMemory() },
        GG.copyText to { this.copyText() },
        GG.disasm to { this.disasm() },
        GG.dumpMemory to { this.dumpMemory() },
        GG.editAll to { this.editAll() },
        GG.getActiveTab to { this.getActiveTab() },
        GG.getFile to { this.getFile() },
        GG.getLine to { this.getLine() },
        GG.getListItems to { this.getListItems() },
        GG.getLocale to { this.getLocale() },
        GG.getRanges to { this.getRanges() },
        GG.getRangesList to { this.getRangesList() },
        GG.getResults to { this.getResults() },
        GG.getResultsCount to { this.getResultsCount() },
        GG.getSelectedElements to { this.getSelectedElements() },
        GG.getSelectedListItems to { this.getSelectedListItems() },
        GG.getSelectedResults to { this.getSelectedResults() },
        GG.getSpeed to { this.getSpeed() },
        GG.getTargetInfo to { this.getTargetInfo() },
        GG.getTargetPackage to { this.getTargetPackage() },
        GG.getValues to { this.getValues() },
        GG.getValuesRange to { this.getValuesRange() },
        GG.gotoAddress to { this.gotoAddress() },
        GG.hideUiButton to { this.hideUiButton() },
        GG.isClickedUiButton to { this.isClickedUiButton() },
        GG.isPackageInstalled to { this.isPackageInstalled() },
        GG.isProcessPaused to { this.isProcessPaused() },
        GG.isVisible to { this.isVisible() },
        GG.loadList to { this.loadList() },
        GG.loadResults to { this.loadResults() },
        GG.makeRequest to { this.makeRequest() },
        GG.multiChoice to { this.multiChoice() },
        GG.numberFromLocale to { this.numberFromLocale() },
        GG.numberToLocale to { this.numberToLocale() },
        GG.processKill to { this.processKill() },
        GG.processPause to { this.processPause() },
        GG.processResume to { this.processResume() },
        GG.processToggle to { this.processToggle() },
        GG.prompt to { this.prompt() },
        GG.removeListItems to { this.removeListItems() },
        GG.removeResults to { this.removeResults() },
        GG.require to { this.require() },
        GG.saveList to { this.saveList() },
        GG.saveVariable to { this.saveVariable() },
        GG.searchAddress to { this.searchAddress() },
        GG.searchFuzzy to { this.searchFuzzy() },
        GG.searchNumber to { this.searchNumber() },
        GG.searchPointer to { this.searchPointer() },
        GG.setRanges to { this.setRanges() },
        GG.setSpeed to { this.setSpeed() },
        GG.setValues to { this.setValues() },
        GG.setVisible to { this.setVisible() },
        GG.showUiButton to { this.showUiButton() },
        GG.skipRestoreState to { this.skipRestoreState() },
        GG.sleep to { this.sleep() },
        GG.startFuzzy to { this.startFuzzy() },
        GG.timeJump to { this.timeJump() },
        GG.toast to { this.toast() },
        GG.unrandomizer to { this.unrandomizer() },
    )

    private fun addListItems() {
        "android.ext.ۣۧۧۡ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val items = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (!(filterParams && !GGUtil.isValidItems("$items"))) {
                            scope.launch {
                                val func = "gg.addListItems($items)"
                                sendLog(func, result)
                            }
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun alert() {
        "android.ext.ۦۤ۠۠"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val text = varArgs.checkjstring(1)
                        val textTmp = GGUtil.getStringValue(text as String)
                        val positive = varArgs.optjstring(2, "ok")
                        val positiveTmp = GGUtil.getStringValue(positive as String)
                        val negative = varArgs.optjstring(3, "nil")
                        val negativeTmp = GGUtil.getStringValue(negative as String)
                        val neutral = varArgs.optjstring(4, "nil")
                        val neutralTmp = GGUtil.getStringValue(neutral as String)
                        scope.launch {
                            val func = "gg.alert($textTmp, $positiveTmp, $negativeTmp, $neutralTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun allocatePage() {
        "android.ext.۟ۧ۠ۡ۠"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val mode = varArgs.optint(1, 6)
                        val modeTmp = GGUtil.getConstValue(GG.CONST.PROT, mode as Int)
                        val address = varArgs.optlong(2, 0L)
                        val addressTmp = GGUtil.getHexValue(address as Long)
                        scope.launch {
                            val func = "gg.allocatePage($modeTmp, $addressTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun bytes() {
        "android.ext.۟ۧ۠ۡۡ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val text = varArgs.checkjstring(1)
                        val textTmp = GGUtil.getStringValue(text as String)
                        val encoding = varArgs.optjstring(2, "UTF-8")
                        val encodingTmp = GGUtil.getStringValue(encoding as String)
                        scope.launch {
                            val func = "gg.bytes($textTmp, $encodingTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun choice() {
        "android.ext.۟ۧ۠ۡۦ"
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
                        val messageTmp = GGUtil.getStringValue(message as String)
                        scope.launch {
                            val func = "gg.choice($items, $selected, $messageTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun clearList() {
        "android.ext.۟ۧ۠ۡۥ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.clearList()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun clearResults() {
        "android.ext.۟ۧ۠ۡۨ"
            .toClassOrNull()?.apply {
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

    private fun copyMemory() {
        "android.ext.ۦۤ۟ۨ"
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
                        scope.launch {
                            val func = "gg.copyMemory($fromTmp, $toTmp, $bytes)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun copyText() {
        "android.ext.ۦۤ۟ۧ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val text = varArgs.checkjstring(1)
                        val textTmp = GGUtil.getStringValue(text as String)
                        val fixLocale = varArgs.optboolean(2, true)
                        scope.launch {
                            val func = "gg.copyText($textTmp, $fixLocale)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun disasm() {
        "android.ext.ۧۧۢۧ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val type = varArgs.checkint(1)
                        val typeTmp = GGUtil.getConstValue(GG.CONST.ASM, type as Int)
                        val address = varArgs.checklong(2)
                        val addressTmp = GGUtil.getHexValue(address as Long)
                        val opcode = varArgs.checkint(3)
                        scope.launch {
                            val func = "gg.disasm($typeTmp, $addressTmp, $opcode)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun dumpMemory() {
        "android.ext.ۦۤ۟ۤ"
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
                        val dirTmp = GGUtil.getStringValue(dir as String)
                        val flags = varArgs.optint(4, 0)
                        val flagsTmp = GGUtil.getConstValue(GG.CONST.DUMP, flags as Int)
                        scope.launch {
                            val func = "gg.dumpMemory($fromTmp, $toTmp, $dirTmp, $flagsTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun editAll() {
        "android.ext.ۧۧۢ۠"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val value = varArgs.checkjstring(1)
                        val valueTmp = GGUtil.getStringValue(value as String)
                        val type = varArgs.checkint(2)
                        val typeTmp = GGUtil.getConstValue(GG.CONST.TYPE, type as Int)
                        scope.launch {
                            val func = "gg.editAll($valueTmp, $typeTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getActiveTab() {
        "android.ext.ۧۧۢ۟"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.getActiveTab()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getFile() {
        "android.ext.۟ۧ۠ۢۤ"
            .toClassOrNull()?.apply {
                method {
                    name = "a_"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.getFile()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getLine() {
        "android.ext.۟ۧ۠ۢۧ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.getLine()"
                            sendLog(func, result)
                        }
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
                        scope.launch {
                            val func = "gg.getListItems()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getLocale() {
        "android.ext.۟ۧ۠ۢۦ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.getLocale()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getRanges() {
        "android.ext.ۧۧۡۨ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.getRanges()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getRangesList() {
        "android.ext.ۧۧۡۥ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val filter = varArgs.optjstring(1, "")
                        val filterTmp = GGUtil.getStringValue(filter as String)
                        scope.launch {
                            val func = "gg.getRangesList($filterTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getResults() {
        "android.ext.ۧۧۡۤ"
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
                        val valueMinTmp = GGUtil.getStringValue(valueMin as String)
                        val valueMax = varArgs.optjstring(6, "nil")
                        val valueMaxTmp = GGUtil.getStringValue(valueMax as String)
                        val type = varArgs.optint(7, 0)
                        val typeTmp = GGUtil.getConstValue(GG.CONST.TYPE, type as Int)
                        val fractional = varArgs.optjstring(8, "nil")
                        val fractionalTmp = GGUtil.getStringValue(fractional as String)
                        val pointer = varArgs.optint(9, 0)
                        val pointerTmp = GGUtil.getConstValue(GG.CONST.POINTER, pointer as Int)
                        scope.launch {
                            val func =
                                "gg.getResults($maxCount, $skip, $addressMinTmp, $addressMaxTmp, $valueMinTmp, $valueMaxTmp, $typeTmp, $fractionalTmp, $pointerTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getResultsCount() {
        "android.ext.ۧۧۡۡ"
            .toClassOrNull()?.apply {
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

    private fun getSelectedElements() {
        "android.ext.ۦۤۢۡ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.getSelectedElements()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getSelectedListItems() {
        "android.ext.ۧۧۥۣ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.getSelectedListItems()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getSelectedResults() {
        "android.ext.ۥۡ۟۠"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.getSelectedResults()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getSpeed() {
        "android.ext.ۦۣۤۢ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.getSpeed()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getTargetInfo() {
        "android.ext.ۧۧۥۡ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.getTargetInfo()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getTargetPackage() {
        "android.ext.ۥۡ۟ۢ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.getTargetPackage()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getValues() {
        "android.ext.ۧۧۥۢ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val values = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (!(filterParams && !GGUtil.isValidItems("$values"))) {
                            scope.launch {
                                val func = "gg.getValues($values)"
                                sendLog(func, result)
                            }
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getValuesRange() {
        "android.ext.ۧۧۥ۟"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val values = varArgs.checktable(1)
                        scope.launch {
                            val func = "gg.getValuesRange($values)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun gotoAddress() {
        "android.ext.ۣ۟ۧ۠ۢ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val address = varArgs.checklong(1)
                        val addressTmp = GGUtil.getHexValue(address as Long)
                        scope.launch {
                            val func = "gg.gotoAddress($addressTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun hideUiButton() {
        "android.ext.ۣۣ۟ۧ۠"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.hideUiButton()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun isClickedUiButton() {
        "android.ext.ۧۧۤۨ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.isClickedUiButton()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun isPackageInstalled() {
        "android.ext.ۦۤۡۤ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val pkg = varArgs.checkjstring(1)
                        val pkgTmp = GGUtil.getStringValue(pkg as String)
                        scope.launch {
                            val func = "gg.isPackageInstalled($pkgTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun isProcessPaused() {
        "android.ext.ۦۣۤۡ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.isProcessPaused()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun isVisible() {
        "android.ext.ۦۤۡۦ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.isVisible()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun loadList() {
        "android.ext.ۧۧۤۥ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val file = varArgs.checkjstring(1)
                        val fileTmp = GGUtil.getStringValue(file as String)
                        val flags = varArgs.optint(2, 0)
                        val flagsTmp = GGUtil.getConstValue(GG.CONST.LOAD, flags as Int)
                        scope.launch {
                            val func = "gg.loadList($fileTmp, $flagsTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun loadResults() {
        "android.ext.ۦۤۡ۠"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val results = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (!(filterParams && !GGUtil.isValidItems("$results"))) {
                            scope.launch {
                                val func = "gg.loadResults($results)"
                                sendLog(func, result)
                            }
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
                        val urlTmp = GGUtil.getStringValue(url as String)
                        val headers = varArgs.opttable(2, null)
                        val data = varArgs.optstring(3, null)
                        val dataTmp = GGUtil.getStringValue(data as String)
                        scope.launch {
                            val func = "gg.makeRequest($urlTmp, $headers, $dataTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun multiChoice() {
        "android.ext.ۣۧۧۤ"
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
                        val messageTmp = GGUtil.getStringValue(message as String)
                        scope.launch {
                            val func = "gg.multiChoice($items, $selection, $messageTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun numberFromLocale() {
        "android.ext.ۦۤۡ۟"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val num = varArgs.tojstring(1)
                        val numTmp = GGUtil.getStringValue(num as String)
                        scope.launch {
                            val func = "gg.numberFromLocale($numTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun numberToLocale() {
        "android.ext.ۦۤۡۢ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val num = varArgs.tojstring(1)
                        val numTmp = GGUtil.getStringValue(num as String)
                        scope.launch {
                            val func = "gg.numberToLocale($numTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun processKill() {
        "android.ext.۟ۧ۠ۤۢ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.processKill()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun processPause() {
        "android.ext.۟ۧ۠ۤۥ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.processPause()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun processResume() {
        "android.ext.۟ۧ۠ۤۦ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.processResume()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun processToggle() {
        "android.ext.۟ۧ۠ۤۨ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.processToggle()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun prompt() {
        "android.ext.ۦۤ۠ۨ"
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
                        scope.launch {
                            val func = "gg.prompt($items, $defaults, $types)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun removeListItems() {
        "android.ext.ۣۧۧۤ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val items = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (!(filterParams && !GGUtil.isValidItems("$items"))) {
                            scope.launch {
                                val func = "gg.removeListItems($items)"
                                sendLog(func, result)
                            }
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun removeResults() {
        "android.ext.ۥۡۡۡ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val results = varArgs.checktable(1)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (!(filterParams && !GGUtil.isValidItems("$results"))) {
                            scope.launch {
                                val func = "gg.removeResults($results)"
                                sendLog(func, result)
                            }
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun require() {
        "android.ext.ۦۤۤۢ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val version = varArgs.optjstring(1, "0")
                        val versionTmp = GGUtil.getStringValue(version as String)
                        val build = varArgs.optint(2, 0)
                        scope.launch {
                            val func = "gg.require($versionTmp, $build)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun saveList() {
        "android.ext.ۣۧۧۧ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val file = varArgs.checkjstring(1)
                        val fileTmp = GGUtil.getStringValue(file as String)
                        val flags = varArgs.optint(2, 0)
                        val flagsTmp = GGUtil.getConstValue(GG.CONST.SAVE, flags as Int)
                        scope.launch {
                            val func = "gg.saveList($fileTmp, $flagsTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun saveVariable() {
        "android.ext.۟ۧ۠ۥ۠"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val variable = varArgs.arg(1)
                        val filename = varArgs.checkjstring(2)
                        val filenameTmp = GGUtil.getStringValue(filename as String)
                        scope.launch {
                            val func = "gg.saveVariable($variable, $filenameTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchAddress() {
        "android.ext.ۣۧۧۥ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val text = varArgs.checkjstring(1)
                        val textTmp = GGUtil.getStringValue(text as String)
                        val mask = varArgs.optlong(2, -1L)
                        val maskTmp = GGUtil.getHexValue(mask as Long)
                        val type = varArgs.optint(3, 127)
                        val typeTmp = GGUtil.getConstValue(GG.CONST.TYPE, type as Int)
                        val sign = varArgs.optint(4, 0x20000000)
                        val signTmp = GGUtil.getConstValue(GG.CONST.SIGN, sign as Int)
                        val memoryFrom = varArgs.optlong(5, 0L)
                        val memoryFromTmp = GGUtil.getHexValue(memoryFrom as Long)
                        val memoryTo = varArgs.optlong(6, -1L)
                        val memoryToTmp = GGUtil.getHexValue(memoryTo as Long)
                        val limit = varArgs.optlong(7, 0L)
                        scope.launch {
                            val func =
                                "gg.searchAddress($textTmp, $maskTmp, $typeTmp, $signTmp, $memoryFromTmp, $memoryToTmp, $limit)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchFuzzy() {
        "android.ext.ۦۤۤۤ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val difference = varArgs.optjstring(1, "0")
                        val differenceTmp = GGUtil.getStringValue(difference as String)
                        val sign = varArgs.optint(2, 0x20000000)
                        val signTmp = GGUtil.getConstValue(GG.CONST.SIGN_FUZZY, sign as Int)
                        val type = varArgs.optint(3, 127)
                        val typeTmp = GGUtil.getConstValue(GG.CONST.TYPE, type as Int)
                        val memoryFrom = varArgs.optlong(4, 0L)
                        val memoryFromTmp = GGUtil.getHexValue(memoryFrom as Long)
                        val memoryTo = varArgs.optlong(5, -1L)
                        val memoryToTmp = GGUtil.getHexValue(memoryTo as Long)
                        val limit = varArgs.optlong(6, 0L)
                        scope.launch {
                            val func =
                                "gg.searchFuzzy($differenceTmp, $signTmp, $typeTmp, $memoryFromTmp, $memoryToTmp, $limit)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchNumber() {
        "android.ext.ۣۧۧۦ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val text = varArgs.checkjstring(1)
                        val textTmp = GGUtil.getStringValue(text as String)
                        val type = varArgs.optint(2, 127)
                        val typeTmp = GGUtil.getConstValue(GG.CONST.TYPE, type as Int)
                        val encrypted = varArgs.optboolean(3, false)
                        val sign = varArgs.optint(4, 0x20000000)
                        val signTmp = GGUtil.getConstValue(GG.CONST.SIGN, sign as Int)
                        val memoryFrom = varArgs.optlong(5, 0L)
                        val memoryFromTmp = GGUtil.getHexValue(memoryFrom as Long)
                        val memoryTo = varArgs.optlong(6, -1L)
                        val memoryToTmp = GGUtil.getHexValue(memoryTo as Long)
                        val limit = varArgs.optlong(7, 0L)
                        val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                        if (!(filterParams && !GGUtil.isValidParams("$text"))) {
                            scope.launch {
                                val func =
                                    "gg.searchNumber($textTmp, $typeTmp, $encrypted, $signTmp, $memoryFromTmp, $memoryToTmp, $limit)"
                                sendLog(func, result)
                            }
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchPointer() {
        "android.ext.۟ۧ۠ۥۢ"
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
                        scope.launch {
                            val func =
                                "gg.searchPointer($maxOffset, $memoryFromTmp, $memoryToTmp, $limit)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun setRanges() {
        "android.ext.ۧۧۧ۠"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val ranges = varArgs.checkint(1)
                        val rangesTmp = GGUtil.getConstValue(GG.CONST.REGION, ranges as Int)
                        scope.launch {
                            val func = "gg.setRanges($rangesTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun setSpeed() {
        "android.ext.۟ۧ۠ۥۣ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val speed = varArgs.checkdouble(1)
                        scope.launch {
                            val func = "gg.setSpeed($speed)"
                            sendLog(func, result)
                        }
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
                        if (!(filterParams && !GGUtil.isValidItems("$values"))) {
                            scope.launch {
                                val func = "gg.setValues($values)"
                                sendLog(func, result)
                            }
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun setVisible() {
        "android.ext.ۥۡۡ۟"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val visible = varArgs.checkboolean(1)
                        scope.launch {
                            val func = "gg.setVisible($visible)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun showUiButton() {
        "android.ext.۟ۧ۠ۥۥ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.showUiButton()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun skipRestoreState() {
        "android.ext.۟ۧ۠ۥۧ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        scope.launch {
                            val func = "gg.skipRestoreState()"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun sleep() {
        "android.ext.ۥۡ۠ۨ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val milliseconds = varArgs.checkint(1)
                        scope.launch {
                            val func = "gg.sleep($milliseconds)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun startFuzzy() {
        "android.ext.ۥۡ۠ۥ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val type = varArgs.optint(1, 127)
                        val typeTmp = GGUtil.getConstValue(GG.CONST.TYPE, type as Int)
                        val memoryFrom = varArgs.optlong(2, 0L)
                        val memoryFromTmp = GGUtil.getHexValue(memoryFrom as Long)
                        val memoryTo = varArgs.optlong(3, -1L)
                        val memoryToTmp = GGUtil.getHexValue(memoryTo as Long)
                        scope.launch {
                            val func = "gg.startFuzzy($typeTmp, $memoryFromTmp, $memoryToTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun timeJump() {
        "android.ext.ۦۣۤۥ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val time = varArgs.checkjstring(1)
                        val timeTmp = GGUtil.getStringValue(time as String)
                        scope.launch {
                            val func = "gg.timeJump($timeTmp)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun toast() {
        "android.ext.ۦۣۤۧ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val text = varArgs.checkjstring(1)
                        val textTmp = GGUtil.getStringValue(text as String)
                        val fast = varArgs.optboolean(2, false)
                        scope.launch {
                            val func = "gg.toast($textTmp, $fast)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun unrandomizer() {
        "android.ext.ۧۧۦۧ"
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
                        scope.launch {
                            val func = "gg.unrandomizer($qword, $qincr, $double_, $dincr)"
                            sendLog(func, result)
                        }
                    }
                }.ignoredAllFailure()
            }
    }
}