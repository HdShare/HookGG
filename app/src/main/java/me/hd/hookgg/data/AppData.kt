package me.hd.hookgg.data

import me.hd.hookgg.hook.hooker.agg.v333.AGGv333Hooker
import me.hd.hookgg.hook.hooker.elgg.v114.ELGGv114Hooker
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120Hooker
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011Hooker
import me.hd.hookgg.hook.hooker.gg.v960.GGv960Hooker
import me.hd.hookgg.hook.hooker.gg.v961.GGv961Hooker
import me.hd.hookgg.hook.hooker.rlgg.v2092.RLGGv2092Hooker

object AppData {
    private fun getMapKey(map: Map<String, *>): Array<String> {
        return map.keys.toTypedArray()
    }

    private val map = mapOf(
        "GG 96.0" to getMapKey(GGv960Hooker.functionMap),
        "GG 96.1" to getMapKey(GGv961Hooker.functionMap),
        "GG 101.1" to getMapKey(GGv1011Hooker.functionMap),
        "RLGG 2.0.9.2" to getMapKey(RLGGv2092Hooker.functionMap),
        "ELGG 1.1.0~1.1.6" to getMapKey(ELGGv114Hooker.functionMap),
        "ELGG 1.2.0" to getMapKey(ELGGv120Hooker.functionMap),
        "AGG 3.3.3~3.3.91" to getMapKey(AGGv333Hooker.functionMap),
    )

    fun getVersionList(): Array<String> {
        return getMapKey(map)
    }

    fun getFunctionList(version: String): Array<String> {
        return map[version] ?: emptyArray()
    }
}