package me.hd.hookgg.hook.base

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.dataChannel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.data.GGData
import me.hd.hookgg.data.SetPagePrefsData

abstract class BaseGGHooker : YukiBaseHooker() {
    protected val scope = CoroutineScope(Dispatchers.Default)

    protected fun sendLog(func: String, result: Any?) {
        val logReturn = prefs.get(SetPagePrefsData.LOG_RETURN)
        val log = "$func\n${if (logReturn) "--[[$result]]\n" else ""}"
        appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put("log", log)
    }

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

    abstract fun addListItems()
    abstract fun alert()
    abstract fun choice()
    abstract fun clearResults()
    abstract fun editAll()
    abstract fun getRangesList()
    abstract fun getResults()
    abstract fun getResultsCount()
    abstract fun getValues()
    abstract fun makeRequest()
    abstract fun multiChoice()
    abstract fun prompt()
    abstract fun searchNumber()
    abstract fun searchPointer()
    abstract fun setRanges()
    abstract fun setValues()
    abstract fun toast()
}