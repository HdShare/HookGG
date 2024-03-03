package me.hd.hookgg.hook.utils

import com.google.gson.Gson
import com.highcapable.yukihookapi.hook.factory.prefs
import com.highcapable.yukihookapi.hook.xposed.prefs.YukiHookPrefsBridge
import me.hd.hookgg.MyApp
import me.hd.hookgg.data.ConfigData
import me.hd.hookgg.hook.data.GG
import me.hd.hookgg.hook.entity.ConfigEntity
import org.json.JSONObject

object ConfigUtil {

    private val gson = Gson()

    fun getConfigStr(prefs: YukiHookPrefsBridge): String {
        return prefs.get(ConfigData.SET_FUNCTION_PREFS, gson.toJson(ConfigEntity()))
    }

    fun setConfigStr(prefs: YukiHookPrefsBridge, str: String) {
        prefs.edit {
            put(ConfigData.SET_FUNCTION_PREFS, str)
        }
    }

    fun getConfigEntity(prefs: YukiHookPrefsBridge): ConfigEntity {
        val str = getConfigStr(prefs)
        return gson.fromJson(str, ConfigEntity::class.java)
    }

    fun getSingleChoiceItems(): Array<String> {
        return arrayOf(
            "96.0",
            "96.1",
            "101.1",
            "RLGG❌"
        )
    }

    fun getSingleChoiceCheckedItems(): Int {
        val versionName = MyApp.context.prefs().get(ConfigData.SET_VERSION_NAME)
        for ((index, item) in getSingleChoiceItems().withIndex()) {
            if (item == versionName) {
                return index
            }
        }
        return -1
    }

    fun getMultiChoiceItems(): Array<String> {
        return arrayOf(
            GG.toast,
            GG.alert,
            GG.clearResults,
            GG.setRanges,
            GG.searchNumber,
            GG.getResultsCount,
            GG.getResults,
            GG.editAll,
            GG.getValues,
            GG.setValues,
            GG.addListItems
        )
    }

    fun getMultiChoiceCheckedItems(): BooleanArray {
        val jsonObject = JSONObject(getConfigStr(MyApp.context.prefs()))
        val result = mutableListOf<Boolean>()
        for (item in getMultiChoiceItems()) {
            result.add(jsonObject.getBoolean(item))
        }
        return result.toBooleanArray()
    }

    fun getMultiChoiceCheckedNames(jsonObject: JSONObject = JSONObject(getConfigStr(MyApp.context.prefs()))): String {
        val result = mutableListOf<String>()
        for (item in getMultiChoiceItems()) {
            if (jsonObject.getBoolean(item)) {
                result.add(item)
            }
        }
        return result.toString()
    }

}