package me.hd.hookgg.hook.entry.hooker

import me.hd.hookgg.hook.entity.ConfigEntity
import me.hd.hookgg.hook.entry.base.BaseHooker
import me.hd.hookgg.hook.entry.impl.GG960Function

object GG960Hooker : BaseHooker() {
    override fun onConfigHook(configEntity: ConfigEntity) {
        if (configEntity.toast) GG960Function.toast()
        if (configEntity.alert) GG960Function.alert()
        if (configEntity.clearResults) GG960Function.clearResults()
        if (configEntity.setRanges) GG960Function.setRanges()
        if (configEntity.searchNumber) GG960Function.searchNumber()
        if (configEntity.getResultsCount) GG960Function.getResultsCount()
        if (configEntity.getResults) GG960Function.getResults()
        if (configEntity.editAll) GG960Function.editAll()
        if (configEntity.getValues) GG960Function.getValues()
        if (configEntity.setValues) GG960Function.setValues()
        if (configEntity.addListItems) GG960Function.addListItems()
    }
}