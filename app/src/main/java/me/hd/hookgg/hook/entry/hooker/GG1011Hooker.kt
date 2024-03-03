package me.hd.hookgg.hook.entry.hooker

import me.hd.hookgg.hook.entity.ConfigEntity
import me.hd.hookgg.hook.entry.base.BaseHooker
import me.hd.hookgg.hook.entry.impl.GG1011Function

object GG1011Hooker : BaseHooker() {
    override fun onConfigHook(configEntity: ConfigEntity) {
        if (configEntity.toast) GG1011Function.toast()
        if (configEntity.alert) GG1011Function.alert()
        if (configEntity.clearResults) GG1011Function.clearResults()
        if (configEntity.setRanges) GG1011Function.setRanges()
        if (configEntity.searchNumber) GG1011Function.searchNumber()
        if (configEntity.getResultsCount) GG1011Function.getResultsCount()
        if (configEntity.getResults) GG1011Function.getResults()
        if (configEntity.editAll) GG1011Function.editAll()
        if (configEntity.getValues) GG1011Function.getValues()
        if (configEntity.setValues) GG1011Function.setValues()
        if (configEntity.addListItems) GG1011Function.addListItems()
    }
}