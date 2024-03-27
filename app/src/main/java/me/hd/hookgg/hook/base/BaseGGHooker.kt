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
        if (GG.toast in setFuncList) toast()
        if (GG.alert in setFuncList) alert()
        if (GG.choice in setFuncList) choice()
        if (GG.multiChoice in setFuncList) multiChoice()
        if (GG.prompt in setFuncList) prompt()
        if (GG.clearResults in setFuncList) clearResults()
        if (GG.setRanges in setFuncList) setRanges()
        if (GG.getRangesList in setFuncList) getRangesList()
        if (GG.searchNumber in setFuncList) searchNumber()
        if (GG.getResultsCount in setFuncList) getResultsCount()
        if (GG.getResults in setFuncList) getResults()
        if (GG.editAll in setFuncList) editAll()
        if (GG.getValues in setFuncList) getValues()
        if (GG.setValues in setFuncList) setValues()
        if (GG.addListItems in setFuncList) addListItems()
        if (GG.makeRequest in setFuncList) makeRequest()
    }

    abstract fun toast()
    abstract fun alert()
    abstract fun choice()
    abstract fun multiChoice()
    abstract fun prompt()
    abstract fun clearResults()
    abstract fun setRanges()
    abstract fun getRangesList()
    abstract fun searchNumber()
    abstract fun getResultsCount()
    abstract fun getResults()
    abstract fun editAll()
    abstract fun getValues()
    abstract fun setValues()
    abstract fun addListItems()
    abstract fun makeRequest()
}