package me.hd.hookgg.hook.entry.hooker

import me.hd.hookgg.hook.entity.ConfigEntity
import me.hd.hookgg.hook.entry.base.BaseHooker
import me.hd.hookgg.hook.entry.impl.GG961Function

object GG961Hooker : BaseHooker() {
    override fun onConfigHook(configEntity: ConfigEntity) {
        if (configEntity.toast) GG961Function.toast()
        if (configEntity.alert) GG961Function.alert()
        if (configEntity.clearResults) GG961Function.clearResults()
        if (configEntity.setRanges) GG961Function.setRanges()
        if (configEntity.searchNumber) GG961Function.searchNumber()
        if (configEntity.getResultsCount) GG961Function.getResultsCount()
        if (configEntity.getResults) GG961Function.getResults()
        if (configEntity.editAll) GG961Function.editAll()
        if (configEntity.getValues) GG961Function.getValues()
        if (configEntity.setValues) GG961Function.setValues()
        if (configEntity.addListItems) GG961Function.addListItems()
    }
}