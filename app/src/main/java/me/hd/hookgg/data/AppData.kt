package me.hd.hookgg.data

import me.hd.hookgg.hook.base.BaseGGHooker
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333Hooker
import me.hd.hookgg.hook.hooker.elgg.v114.ELGGv114Hooker
import me.hd.hookgg.hook.hooker.elgg.v117.ELGGv117Hooker
import me.hd.hookgg.hook.hooker.elgg.v119.ELGGv119Hooker
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120Hooker
import me.hd.hookgg.hook.hooker.elgg.v121.ELGGv121Hooker
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011Hooker
import me.hd.hookgg.hook.hooker.gg.v960.GGv960Hooker
import me.hd.hookgg.hook.hooker.gg.v961.GGv961Hooker
import me.hd.hookgg.hook.hooker.rlgg.v2092.RLGGv2092Hooker

object AppData {
    private val mapHooker = mapOf(
        "GG 96.0" to GGv960Hooker,
        "GG 96.1" to GGv961Hooker,
        "GG 101.1" to GGv1011Hooker,
        "RLGG 2.0.9.2" to RLGGv2092Hooker,
        "ELGG 1.1.0~1.1.6" to ELGGv114Hooker,
        "ELGG 1.1.7" to ELGGv117Hooker,
        "ELGG 1.1.9" to ELGGv119Hooker,
        "ELGG 1.2.0" to ELGGv120Hooker,
        "ELGG 1.2.1" to ELGGv121Hooker,
        "AGG 3.3.3~3.3.91" to AGGv333Hooker,
    )

    fun getMapHooker(version: String): BaseGGHooker? {
        return mapHooker[version]
    }

    fun getVersionList(): Array<String> {
        return mapHooker.keys.toTypedArray()
    }

    fun getFunctionList(version: String): Array<String> {
        return mapHooker[version]?.run {
            functionMap.keys.toTypedArray()
        } ?: arrayOf()
    }
}