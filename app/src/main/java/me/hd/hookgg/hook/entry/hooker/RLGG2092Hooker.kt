package me.hd.hookgg.hook.entry.hooker

import com.highcapable.yukihookapi.hook.log.YLog
import me.hd.hookgg.hook.entity.ConfigEntity
import me.hd.hookgg.hook.entry.base.BaseHooker
import me.hd.hookgg.hook.entry.impl.RLGG2092Function

object RLGG2092Hooker : BaseHooker() {
    override fun onConfigHook(configEntity: ConfigEntity) {
        if (configEntity.toast) YLog.error("toast") //RLGG2092Function.toast()
        if (configEntity.alert) RLGG2092Function.alert()
        if (configEntity.clearResults) RLGG2092Function.clearResults()
        if (configEntity.setRanges) RLGG2092Function.setRanges()
        if (configEntity.searchNumber) RLGG2092Function.searchNumber()
        if (configEntity.getResultsCount) RLGG2092Function.getResultsCount()
        if (configEntity.getResults) RLGG2092Function.getResults()
        if (configEntity.editAll) RLGG2092Function.editAll()
        if (configEntity.getValues) YLog.error("getValues") //RLGG2092Function.getValues()
        if (configEntity.setValues) YLog.error("setValues") //RLGG2092Function.setValues()
        if (configEntity.addListItems) YLog.error("addListItems") //RLGG2092Function.addListItems()
    }
}