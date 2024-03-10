package me.hd.hookgg.hook.entry.hooker.gg960

import me.hd.hookgg.hook.entity.ConfigEntity
import me.hd.hookgg.hook.entry.base.BaseHooker
import me.hd.hookgg.hook.entry.hooker.gg960.GG960Function.addListItems
import me.hd.hookgg.hook.entry.hooker.gg960.GG960Function.alert
import me.hd.hookgg.hook.entry.hooker.gg960.GG960Function.clearResults
import me.hd.hookgg.hook.entry.hooker.gg960.GG960Function.editAll
import me.hd.hookgg.hook.entry.hooker.gg960.GG960Function.getResults
import me.hd.hookgg.hook.entry.hooker.gg960.GG960Function.getResultsCount
import me.hd.hookgg.hook.entry.hooker.gg960.GG960Function.getValues
import me.hd.hookgg.hook.entry.hooker.gg960.GG960Function.searchNumber
import me.hd.hookgg.hook.entry.hooker.gg960.GG960Function.setRanges
import me.hd.hookgg.hook.entry.hooker.gg960.GG960Function.setValues
import me.hd.hookgg.hook.entry.hooker.gg960.GG960Function.toast

object GG960Hooker : BaseHooker() {
    override fun onConfigHook(configEntity: ConfigEntity) {
        if (configEntity.toast) toast()
        if (configEntity.alert) alert()
        if (configEntity.clearResults) clearResults()
        if (configEntity.setRanges) setRanges()
        if (configEntity.searchNumber) searchNumber()
        if (configEntity.getResultsCount) getResultsCount()
        if (configEntity.getResults) getResults()
        if (configEntity.editAll) editAll()
        if (configEntity.getValues) getValues()
        if (configEntity.setValues) setValues()
        if (configEntity.addListItems) addListItems()
    }
}