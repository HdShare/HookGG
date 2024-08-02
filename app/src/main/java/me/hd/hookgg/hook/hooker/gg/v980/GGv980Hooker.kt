package me.hd.hookgg.hook.hooker.gg.v980

import com.highcapable.yukihookapi.hook.factory.method
import kotlinx.coroutines.launch
import me.hd.hookgg.data.SetPrefsData
import me.hd.hookgg.data.func.GG
import me.hd.hookgg.hook.base.BaseGGHooker
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011VarArgs.arg
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011VarArgs.checkboolean
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011VarArgs.checkdouble
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011VarArgs.checkint
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011VarArgs.checkjstring
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011VarArgs.checklong
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011VarArgs.checktable
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011VarArgs.optboolean
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011VarArgs.optdouble
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011VarArgs.optint
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011VarArgs.optjstring
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011VarArgs.optlong
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011VarArgs.optstring
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011VarArgs.opttable
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011VarArgs.tojstring
import me.hd.hookgg.hook.utils.GGUtil

object GGv980Hooker : BaseGGHooker() {
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
        "android.ext.Script\$addListItems".toClassOrNull()?.apply {
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
        "android.ext.Script\$alert".toClassOrNull()?.apply {
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

    private fun allocatePage() {
        "android.ext.Script\$allocatePage".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val mode = varArgs.optint(1, 6)
                    val address = varArgs.optlong(2, 0L)
                    scope.launch {
                        val func = "gg.allocatePage($mode, $address)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun bytes() {
        "android.ext.Script\$bytes".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val text = varArgs.checkjstring(1)
                    val encoding = varArgs.optjstring(2, "UTF-8")
                    scope.launch {
                        val func = "gg.bytes($text, $encoding)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun choice() {
        "android.ext.Script\$choice".toClassOrNull()?.apply {
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

    private fun clearList() {
        "android.ext.Script\$clearList".toClassOrNull()?.apply {
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
        "android.ext.Script\$clearResults".toClassOrNull()?.apply {
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
        "android.ext.Script\$copyMemory".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val from = varArgs.checklong(1)
                    val to = varArgs.checklong(2)
                    val bytes = varArgs.checkint(3)
                    scope.launch {
                        val func = "gg.copyMemory($from, $to, $bytes)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun copyText() {
        "android.ext.Script\$copyText".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val text = varArgs.checkjstring(1)
                    val fixLocale = varArgs.optboolean(2, true)
                    scope.launch {
                        val func = "gg.copyText($text, $fixLocale)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun disasm() {
        "android.ext.Script\$disasm".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val type = varArgs.checkint(1)
                    val address = varArgs.checklong(2)
                    val opcode = varArgs.checkint(3)
                    scope.launch {
                        val func = "gg.disasm($type, $address, $opcode)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun dumpMemory() {
        "android.ext.Script\$dumpMemory".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val from = varArgs.checklong(1)
                    val to = varArgs.checklong(2)
                    val dir = varArgs.checkjstring(3)
                    val flags = varArgs.optint(4, 0)
                    scope.launch {
                        val func = "gg.dumpMemory($from, $to, $dir, $flags)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun editAll() {
        "android.ext.Script\$editAll".toClassOrNull()?.apply {
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

    private fun getActiveTab() {
        "android.ext.Script\$getActiveTab".toClassOrNull()?.apply {
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
        "android.ext.Script\$getFile".toClassOrNull()?.apply {
            method {
                name = "b"
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
        "android.ext.Script\$getLine".toClassOrNull()?.apply {
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
        "android.ext.Script\$getListItems".toClassOrNull()?.apply {
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
        "android.ext.Script\$getLocale".toClassOrNull()?.apply {
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
        "android.ext.Script\$getRanges".toClassOrNull()?.apply {
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
        "android.ext.Script\$getRangesList".toClassOrNull()?.apply {
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
        "android.ext.Script\$getResults".toClassOrNull()?.apply {
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
        "android.ext.Script\$getResultsCount".toClassOrNull()?.apply {
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
        "android.ext.Script\$getSelectedElements".toClassOrNull()?.apply {
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
        "android.ext.Script\$getSelectedListItems".toClassOrNull()?.apply {
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
        "android.ext.Script\$getSelectedResults".toClassOrNull()?.apply {
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
        "android.ext.Script\$getSpeed".toClassOrNull()?.apply {
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
        "android.ext.Script\$getTargetInfo".toClassOrNull()?.apply {
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
        "android.ext.Script\$getTargetPackage".toClassOrNull()?.apply {
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
        "android.ext.Script\$getValues".toClassOrNull()?.apply {
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
        "android.ext.Script\$getValuesRange".toClassOrNull()?.apply {
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
        "android.ext.Script\$gotoAddress".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val address = varArgs.checklong(1)
                    scope.launch {
                        val func = "gg.gotoAddress($address)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun hideUiButton() {
        "android.ext.Script\$hideUiButton".toClassOrNull()?.apply {
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
        "android.ext.Script\$isClickedUiButton".toClassOrNull()?.apply {
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
        "android.ext.Script\$isPackageInstalled".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val pkg = varArgs.checkjstring(1)
                    scope.launch {
                        val func = "gg.isPackageInstalled($pkg)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun isProcessPaused() {
        "android.ext.Script\$isProcessPaused".toClassOrNull()?.apply {
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
        "android.ext.Script\$isVisible".toClassOrNull()?.apply {
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
        "android.ext.Script\$loadList".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val file = varArgs.checkjstring(1)
                    val flags = varArgs.optint(2, 0)
                    scope.launch {
                        val func = "gg.loadList($file, $flags)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun loadResults() {
        "android.ext.Script\$loadResults".toClassOrNull()?.apply {
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
        "android.ext.Script\$multiChoice".toClassOrNull()?.apply {
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

    private fun numberFromLocale() {
        "android.ext.Script\$numberFromLocale".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val num = varArgs.tojstring(1)
                    scope.launch {
                        val func = "gg.numberFromLocale($num)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun numberToLocale() {
        "android.ext.Script\$numberToLocale".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val num = varArgs.tojstring(1)
                    scope.launch {
                        val func = "gg.numberToLocale($num)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun processKill() {
        "android.ext.Script\$processKill".toClassOrNull()?.apply {
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
        "android.ext.Script\$processPause".toClassOrNull()?.apply {
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
        "android.ext.Script\$processResume".toClassOrNull()?.apply {
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
        "android.ext.Script\$processToggle".toClassOrNull()?.apply {
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
        "android.ext.Script\$prompt".toClassOrNull()?.apply {
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
        "android.ext.Script\$removeListItems".toClassOrNull()?.apply {
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
        "android.ext.Script\$removeResults".toClassOrNull()?.apply {
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
        "android.ext.Script\$require".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val version = varArgs.optjstring(1, "0")
                    val build = varArgs.optint(2, 0)
                    scope.launch {
                        val func = "gg.require($version, $build)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun saveList() {
        "android.ext.Script\$saveList".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val file = varArgs.checkjstring(1)
                    val flags = varArgs.optint(2, 0)
                    scope.launch {
                        val func = "gg.saveList($file, $flags)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun saveVariable() {
        "android.ext.Script\$saveVariable".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val variable = varArgs.arg(1)
                    val filename = varArgs.checkjstring(2)
                    scope.launch {
                        val func = "gg.saveVariable($variable, $filename)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun searchAddress() {
        "android.ext.Script\$searchAddress".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val text = varArgs.checkjstring(1)
                    val mask = varArgs.optlong(2, -1L)
                    val type = varArgs.optint(3, 127)
                    val sign = varArgs.optint(4, 0x20000000)
                    val memoryFrom = varArgs.optlong(5, 0L)
                    val memoryTo = varArgs.optlong(6, -1L)
                    scope.launch {
                        val func =
                            "gg.searchAddress($text, $mask, $type, $sign, $memoryFrom, $memoryTo)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun searchFuzzy() {
        "android.ext.Script\$searchFuzzy".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val difference = varArgs.optjstring(1, "0")
                    val sign = varArgs.optint(2, 0x20000000)
                    val type = varArgs.optint(3, 127)
                    val memoryFrom = varArgs.optlong(4, 0L)
                    val memoryTo = varArgs.optlong(5, -1L)
                    val limit = varArgs.optlong(6, 0L)
                    scope.launch {
                        val func =
                            "gg.searchFuzzy($difference, $sign, $type, $memoryFrom, $memoryTo, $limit)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun searchNumber() {
        "android.ext.Script\$searchNumber".toClassOrNull()?.apply {
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
                    val filterParams = prefs.get(SetPrefsData.FILTER_PARAMS)
                    if (!(filterParams && !GGUtil.isValidParams("$text"))) {
                        scope.launch {
                            val func =
                                "gg.searchNumber($text, $type, $encrypted, $sign, $memoryFrom, $memoryTo, $limit)"
                            sendLog(func, result)
                        }
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun setRanges() {
        "android.ext.Script\$setRanges".toClassOrNull()?.apply {
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

    private fun setSpeed() {
        "android.ext.Script\$setSpeed".toClassOrNull()?.apply {
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
        "android.ext.Script\$setValues".toClassOrNull()?.apply {
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
        "android.ext.Script\$setVisible".toClassOrNull()?.apply {
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
        "android.ext.Script\$showUiButton".toClassOrNull()?.apply {
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
        "android.ext.Script\$skipRestoreState".toClassOrNull()?.apply {
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
        "android.ext.Script\$sleep".toClassOrNull()?.apply {
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
        "android.ext.Script\$startFuzzy".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val type = varArgs.optint(1, 127)
                    val memoryFrom = varArgs.optlong(2, 0L)
                    val memoryTo = varArgs.optlong(3, -1L)
                    scope.launch {
                        val func = "gg.startFuzzy($type, $memoryFrom, $memoryTo)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun timeJump() {
        "android.ext.Script\$timeJump".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                after {
                    val varArgs = args(0).any()
                    val time = varArgs.checkjstring(1)
                    scope.launch {
                        val func = "gg.timeJump($time)"
                        sendLog(func, result)
                    }
                }
            }.ignoredAllFailure()
        }
    }

    private fun toast() {
        "android.ext.Script\$toast".toClassOrNull()?.apply {
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

    private fun unrandomizer() {
        "android.ext.Script\$unrandomizer".toClassOrNull()?.apply {
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