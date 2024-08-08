package me.hd.hookgg.hook.hooker.elgg.v117

import com.highcapable.yukihookapi.hook.factory.method
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import me.hd.hookgg.data.SetPrefsData
import me.hd.hookgg.data.func.GGLib
import me.hd.hookgg.hook.base.BaseGGHooker
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117VarArgs.arg
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117VarArgs.checkboolean
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117VarArgs.checkdouble
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117VarArgs.checkint
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117VarArgs.checkjstring
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117VarArgs.checklong
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117VarArgs.checktable
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117VarArgs.optboolean
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117VarArgs.optdouble
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117VarArgs.optint
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117VarArgs.optjstring
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117VarArgs.optlong
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117VarArgs.optstring
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117VarArgs.opttable
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117VarArgs.tojstring
import me.hd.hookgg.hook.utils.GGUtil

object ELGGv117Hooker : BaseGGHooker() {
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
        GGLib.searchPointer to { this.searchPointer() },
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
        "android.ext.ۦۤ۠۠"
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
                            val deferred = scope.async {
                                val func = "gg.addListItems($items)"
                                sendLog(func, result)
                            }
                            runBlocking { deferred.await() }
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun alert() {
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
                        val positive = varArgs.optjstring(2, "ok")
                        val positiveTmp = GGUtil.getStringValue(positive as String)
                        val negative = varArgs.optjstring(3, "nil")
                        val negativeTmp = GGUtil.getStringValue(negative as String)
                        val neutral = varArgs.optjstring(4, "nil")
                        val neutralTmp = GGUtil.getStringValue(neutral as String)
                        val deferred = scope.async {
                            val func = "gg.alert($textTmp, $positiveTmp, $negativeTmp, $neutralTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun allocatePage() {
        "android.ext.۟ۧ۠ۡۤ"
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
                        val deferred = scope.async {
                            val func = "gg.allocatePage($modeTmp, $addressTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun bytes() {
        "android.ext.۟ۧ۠ۡۥ"
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
                        val deferred = scope.async {
                            val func = "gg.bytes($textTmp, $encodingTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun choice() {
        "android.ext.ۦۤ۟ۦ"
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
                        val deferred = scope.async {
                            val func = "gg.choice($items, $selected, $messageTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun clearList() {
        "android.ext.ۧۧۢۨ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.clearList()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun clearResults() {
        "android.ext.ۦۤ۟ۥ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.clearResults()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun copyMemory() {
        "android.ext.ۦۤ۟ۢ"
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
                        val deferred = scope.async {
                            val func = "gg.copyMemory($fromTmp, $toTmp, $bytes)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun copyText() {
        "android.ext.ۦۤ۟ۡ"
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
                        val deferred = scope.async {
                            val func = "gg.copyText($textTmp, $fixLocale)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun disasm() {
        "android.ext.ۧۧۢۥ"
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
                        val deferred = scope.async {
                            val func = "gg.disasm($typeTmp, $addressTmp, $opcode)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun dumpMemory() {
        "android.ext.ۦۤ۟۠"
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
                        val flagsTmp = GGUtil.getConstValue(GGLib.CONST.DUMP, flags as Int)
                        val deferred = scope.async {
                            val func = "gg.dumpMemory($fromTmp, $toTmp, $dirTmp, $flagsTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun editAll() {
        "android.ext.ۧۧۢ۟"
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
                        val typeTmp = GGUtil.getConstValue(GGLib.CONST.TYPE, type as Int)
                        val deferred = scope.async {
                            val func = "gg.editAll($valueTmp, $typeTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getActiveTab() {
        "android.ext.۟ۧ۠ۢۢ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.getActiveTab()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getFile() {
        "android.ext.ۧۧۡۧ"
            .toClassOrNull()?.apply {
                method {
                    name = "a_"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.getFile()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getLine() {
        "android.ext.ۧۧۡۨ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.getLine()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
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
                        val deferred = scope.async {
                            val func = "gg.getListItems()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getLocale() {
        "android.ext.ۧۧۡۥ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.getLocale()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getRanges() {
        "android.ext.ۧۧۡۤ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.getRanges()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getRangesList() {
        "android.ext.ۧۧۡۡ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val filter = varArgs.optjstring(1, "")
                        val filterTmp = GGUtil.getStringValue(filter as String)
                        val deferred = scope.async {
                            val func = "gg.getRangesList($filterTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getResults() {
        "android.ext.ۧۧۥۣ"
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
                        val typeTmp = GGUtil.getConstValue(GGLib.CONST.TYPE, type as Int)
                        val fractional = varArgs.optjstring(8, "nil")
                        val fractionalTmp = GGUtil.getStringValue(fractional as String)
                        val pointer = varArgs.optint(9, 0)
                        val pointerTmp = GGUtil.getConstValue(GGLib.CONST.POINTER, pointer as Int)
                        val deferred = scope.async {
                            val func =
                                "gg.getResults($maxCount, $skip, $addressMinTmp, $addressMaxTmp, $valueMinTmp, $valueMaxTmp, $typeTmp, $fractionalTmp, $pointerTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getResultsCount() {
        "android.ext.ۥۡ۟۠"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.getResultsCount()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getSelectedElements() {
        "android.ext.ۧۧۥۤ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.getSelectedElements()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getSelectedListItems() {
        "android.ext.ۦۣۤۢ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.getSelectedListItems()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getSelectedResults() {
        "android.ext.ۧۧۥۡ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.getSelectedResults()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getSpeed() {
        "android.ext.ۧۧۥۢ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.getSpeed()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getTargetInfo() {
        "android.ext.ۧۧۥ۟"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.getTargetInfo()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getTargetPackage() {
        "android.ext.ۣ۟ۧ۠۠"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.getTargetPackage()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getValues() {
        "android.ext.ۧۧۥ۠"
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
                            val deferred = scope.async {
                                val func = "gg.getValues($values)"
                                sendLog(func, result)
                            }
                            runBlocking { deferred.await() }
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun getValuesRange() {
        "android.ext.ۣ۟ۧ۠ۢ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val values = varArgs.checktable(1)
                        val deferred = scope.async {
                            val func = "gg.getValuesRange($values)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun gotoAddress() {
        "android.ext.ۣ۟ۧ۠ۦ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val address = varArgs.checklong(1)
                        val addressTmp = GGUtil.getHexValue(address as Long)
                        val deferred = scope.async {
                            val func = "gg.gotoAddress($addressTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun hideUiButton() {
        "android.ext.ۦۤۡۨ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.hideUiButton()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun isClickedUiButton() {
        "android.ext.ۧۧۤۧ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.isClickedUiButton()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun isPackageInstalled() {
        "android.ext.ۦۤۡۥ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val pkg = varArgs.checkjstring(1)
                        val pkgTmp = GGUtil.getStringValue(pkg as String)
                        val deferred = scope.async {
                            val func = "gg.isPackageInstalled($pkgTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun isProcessPaused() {
        "android.ext.ۧۧۤۥ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.isProcessPaused()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun isVisible() {
        "android.ext.ۧۧۤۢ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.isVisible()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun loadList() {
        "android.ext.ۦۤۡ۟"
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
                        val flagsTmp = GGUtil.getConstValue(GGLib.CONST.LOAD, flags as Int)
                        val deferred = scope.async {
                            val func = "gg.loadList($fileTmp, $flagsTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun loadResults() {
        "android.ext.ۦۤۡۢ"
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
                            val deferred = scope.async {
                                val func = "gg.loadResults($results)"
                                sendLog(func, result)
                            }
                            runBlocking { deferred.await() }
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
                        val deferred = scope.async {
                            val func = "gg.makeRequest($urlTmp, $headers, $dataTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun multiChoice() {
        "android.ext.ۧۧۤۡ"
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
                        val deferred = scope.async {
                            val func = "gg.multiChoice($items, $selection, $messageTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun numberFromLocale() {
        "android.ext.ۦۤۡۡ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val num = varArgs.tojstring(1)
                        val numTmp = GGUtil.getStringValue(num as String)
                        val deferred = scope.async {
                            val func = "gg.numberFromLocale($numTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun numberToLocale() {
        "android.ext.۟ۧ۠ۤۡ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val num = varArgs.tojstring(1)
                        val numTmp = GGUtil.getStringValue(num as String)
                        val deferred = scope.async {
                            val func = "gg.numberToLocale($numTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun processKill() {
        "android.ext.ۦۤ۠ۧ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.processKill()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun processPause() {
        "android.ext.ۦۤ۠ۦ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.processPause()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun processResume() {
        "android.ext.ۣۧۧۧ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.processResume()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun processToggle() {
        "android.ext.ۦۤ۠ۨ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.processToggle()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun prompt() {
        "android.ext.ۦۤ۠ۢ"
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
                        val deferred = scope.async {
                            val func = "gg.prompt($items, $defaults, $types)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun removeListItems() {
        "android.ext.ۣۧۧۧ"
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
                            val deferred = scope.async {
                                val func = "gg.removeListItems($items)"
                                sendLog(func, result)
                            }
                            runBlocking { deferred.await() }
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun removeResults() {
        "android.ext.ۥۡۡۤ"
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
                            val deferred = scope.async {
                                val func = "gg.removeResults($results)"
                                sendLog(func, result)
                            }
                            runBlocking { deferred.await() }
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun require() {
        "android.ext.ۦۤۤۥ"
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
                        val deferred = scope.async {
                            val func = "gg.require($versionTmp, $build)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun saveList() {
        "android.ext.۟ۧ۠ۥ۟"
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
                        val flagsTmp = GGUtil.getConstValue(GGLib.CONST.SAVE, flags as Int)
                        val deferred = scope.async {
                            val func = "gg.saveList($fileTmp, $flagsTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun saveVariable() {
        "android.ext.ۧۧۧۤ"
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
                        val deferred = scope.async {
                            val func = "gg.saveVariable($variable, $filenameTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchAddress() {
        "android.ext.ۦۤ۠ۥ"
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
                        val typeTmp = GGUtil.getConstValue(GGLib.CONST.TYPE, type as Int)
                        val sign = varArgs.optint(4, 0x20000000)
                        val signTmp = GGUtil.getConstValue(GGLib.CONST.SIGN, sign as Int)
                        val memoryFrom = varArgs.optlong(5, 0L)
                        val memoryFromTmp = GGUtil.getHexValue(memoryFrom as Long)
                        val memoryTo = varArgs.optlong(6, -1L)
                        val memoryToTmp = GGUtil.getHexValue(memoryTo as Long)
                        val limit = varArgs.optlong(7, 0L)
                        val deferred = scope.async {
                            val func =
                                "gg.searchAddress($textTmp, $maskTmp, $typeTmp, $signTmp, $memoryFromTmp, $memoryToTmp, $limit)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchFuzzy() {
        "android.ext.ۦۤۤۡ"
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
                        val signTmp = GGUtil.getConstValue(GGLib.CONST.SIGN_FUZZY, sign as Int)
                        val type = varArgs.optint(3, 127)
                        val typeTmp = GGUtil.getConstValue(GGLib.CONST.TYPE, type as Int)
                        val memoryFrom = varArgs.optlong(4, 0L)
                        val memoryFromTmp = GGUtil.getHexValue(memoryFrom as Long)
                        val memoryTo = varArgs.optlong(5, -1L)
                        val memoryToTmp = GGUtil.getHexValue(memoryTo as Long)
                        val limit = varArgs.optlong(6, 0L)
                        val deferred = scope.async {
                            val func =
                                "gg.searchFuzzy($differenceTmp, $signTmp, $typeTmp, $memoryFromTmp, $memoryToTmp, $limit)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchNumber() {
        "android.ext.ۦۣۤۤ"
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
                        if (!(filterParams && !GGUtil.isValidParams("$text"))) {
                            val deferred = scope.async {
                                val func =
                                    "gg.searchNumber($textTmp, $typeTmp, $encrypted, $signTmp, $memoryFromTmp, $memoryToTmp, $limit)"
                                sendLog(func, result)
                            }
                            runBlocking { deferred.await() }
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun searchPointer() {
        "android.ext.ۧۧۧ۟"
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
                        val deferred = scope.async {
                            val func =
                                "gg.searchPointer($maxOffset, $memoryFromTmp, $memoryToTmp, $limit)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun setRanges() {
        "android.ext.۟ۧ۠ۥۧ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val ranges = varArgs.checkint(1)
                        val rangesTmp = GGUtil.getConstValue(GGLib.CONST.REGION, ranges as Int)
                        val deferred = scope.async {
                            val func = "gg.setRanges($rangesTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun setSpeed() {
        "android.ext.ۥۡ۠ۨ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val speed = varArgs.checkdouble(1)
                        val deferred = scope.async {
                            val func = "gg.setSpeed($speed)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
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
                            val deferred = scope.async {
                                val func = "gg.setValues($values)"
                                sendLog(func, result)
                            }
                            runBlocking { deferred.await() }
                        }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun setVisible() {
        "android.ext.ۥۡ۠ۥ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val visible = varArgs.checkboolean(1)
                        val deferred = scope.async {
                            val func = "gg.setVisible($visible)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun showUiButton() {
        "android.ext.ۧۧۦۨ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.showUiButton()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun skipRestoreState() {
        "android.ext.ۦۣۤۦ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val deferred = scope.async {
                            val func = "gg.skipRestoreState()"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun sleep() {
        "android.ext.ۦۣۤۥ"
            .toClassOrNull()?.apply {
                method {
                    name = "b"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val milliseconds = varArgs.checkint(1)
                        val deferred = scope.async {
                            val func = "gg.sleep($milliseconds)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun startFuzzy() {
        "android.ext.ۥۡ۠ۤ"
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
                        val deferred = scope.async {
                            val func = "gg.startFuzzy($typeTmp, $memoryFromTmp, $memoryToTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun timeJump() {
        "android.ext.ۦۣۤۧ"
            .toClassOrNull()?.apply {
                method {
                    name = "d"
                    paramCount = 1
                }.ignored().hook {
                    after {
                        val varArgs = args(0).any()
                        val time = varArgs.checkjstring(1)
                        val timeTmp = GGUtil.getStringValue(time as String)
                        val deferred = scope.async {
                            val func = "gg.timeJump($timeTmp)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun toast() {
        "android.ext.۟ۧ۠ۦ۟"
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
                        val deferred = scope.async {
                            val func = "gg.toast($textTmp, $fast)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }

    private fun unrandomizer() {
        "android.ext.ۦۣۤۡ"
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
                        val deferred = scope.async {
                            val func = "gg.unrandomizer($qword, $qincr, $double_, $dincr)"
                            sendLog(func, result)
                        }
                        runBlocking { deferred.await() }
                    }
                }.ignoredAllFailure()
            }
    }
}