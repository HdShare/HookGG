package me.hd.hookgg.hook.base

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.dataChannel
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.data.GG
import me.hd.hookgg.data.SetPagePrefsData

abstract class BaseGGHooker : YukiBaseHooker() {
    protected fun sendLog(func: String, result: Any?) {
        val logReturn = prefs.get(SetPagePrefsData.LOG_RETURN)
        val log = if (!logReturn) "$func\n" else "$func\n--[[$result]]\n"
        appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put("log", log)
    }

    override fun onHook() {
        val setFuncList = prefs.get(SetPagePrefsData.FUNCTION_LIST)
        if (GG.addListItems in setFuncList) addListItems()
        if (GG.alert in setFuncList) alert()
        if (GG.choice in setFuncList) choice()
        if (GG.clearResults in setFuncList) clearResults()
        if (GG.editAll in setFuncList) editAll()
        if (GG.getRangesList in setFuncList) getRangesList()
        if (GG.getResults in setFuncList) getResults()
        if (GG.getResultsCount in setFuncList) getResultsCount()
        if (GG.getValues in setFuncList) getValues()
        if (GG.makeRequest in setFuncList) makeRequest()
        if (GG.multiChoice in setFuncList) multiChoice()
        if (GG.prompt in setFuncList) prompt()
        if (GG.searchNumber in setFuncList) searchNumber()
        if (GG.searchPointer in setFuncList) searchPointer()
        if (GG.setRanges in setFuncList) setRanges()
        if (GG.setValues in setFuncList) setValues()
        if (GG.toast in setFuncList) toast()
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