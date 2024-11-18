package me.hd.hookgg.ui.utils

import me.hd.hookgg.data.AppData.mapHooker
import me.hd.hookgg.data.bean.FuncObj
import me.hd.hookgg.hook.base.BaseGGHooker

object AppDataUtil {
    fun getMapHooker(version: String): BaseGGHooker? {
        return mapHooker[version]
    }

    fun getVersionList(): Array<String> {
        return mapHooker.keys.toTypedArray()
    }

    fun getFuncNameSet(version: String): Set<String> {
        return mapHooker[version]?.run {
            functionMap.keys.toSet()
        } ?: setOf()
    }

    fun getFuncObjList(version: String): List<FuncObj> {
        return mapHooker[version]?.run {
            functionMap.map { (funcName, funcDetail) ->
                FuncObj(funcName, funcDetail)
            }.toMutableList()
        } ?: mutableListOf()
    }
}