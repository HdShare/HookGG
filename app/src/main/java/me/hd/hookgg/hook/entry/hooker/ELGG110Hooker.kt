package me.hd.hookgg.hook.entry.hooker

import me.hd.hookgg.hook.entity.ConfigEntity
import me.hd.hookgg.hook.entry.base.BaseHooker
import me.hd.hookgg.hook.entry.impl.ELGG110Function

object ELGG110Hooker : BaseHooker() {
    override fun onConfigHook(configEntity: ConfigEntity) {
        if (configEntity.toast) ELGG110Function.toast()
        if (configEntity.alert) ELGG110Function.alert()
        if (configEntity.clearResults) ELGG110Function.clearResults()
        if (configEntity.setRanges) ELGG110Function.setRanges()
        if (configEntity.searchNumber) ELGG110Function.searchNumber()
        if (configEntity.getResultsCount) ELGG110Function.getResultsCount()
        if (configEntity.getResults) ELGG110Function.getResults()
        if (configEntity.editAll) ELGG110Function.editAll()
        if (configEntity.getValues) ELGG110Function.getValues()
        if (configEntity.setValues) ELGG110Function.setValues()
        if (configEntity.addListItems) ELGG110Function.addListItems()
    }
}