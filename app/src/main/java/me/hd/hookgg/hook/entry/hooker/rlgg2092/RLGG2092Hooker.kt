package me.hd.hookgg.hook.entry.hooker.rlgg2092

import com.highcapable.yukihookapi.hook.log.YLog
import me.hd.hookgg.hook.entity.ConfigEntity
import me.hd.hookgg.hook.entry.base.BaseHooker
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Function.alert
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Function.clearResults
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Function.editAll
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Function.getResults
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Function.getResultsCount
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Function.makeRequest
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Function.searchNumber
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Function.setRanges

object RLGG2092Hooker : BaseHooker() {
    override fun onConfigHook(configEntity: ConfigEntity) {
        if (configEntity.toast) YLog.error("toast")
        if (configEntity.alert) alert()
        if (configEntity.clearResults) clearResults()
        if (configEntity.setRanges) setRanges()
        if (configEntity.searchNumber) searchNumber()
        if (configEntity.getResultsCount) getResultsCount()
        if (configEntity.getResults) getResults()
        if (configEntity.editAll) editAll()
        if (configEntity.getValues) YLog.error("getValues")
        if (configEntity.setValues) YLog.error("setValues")
        if (configEntity.addListItems) YLog.error("addListItems")
        if (configEntity.makeRequest) makeRequest()
    }
}