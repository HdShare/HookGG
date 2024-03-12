package me.hd.hookgg.hook.entry.hooker.gg1011

import me.hd.hookgg.hook.entity.ConfigEntity
import me.hd.hookgg.hook.entry.base.BaseHooker
import me.hd.hookgg.hook.entry.hooker.gg1011.GG1011Function.addListItems
import me.hd.hookgg.hook.entry.hooker.gg1011.GG1011Function.alert
import me.hd.hookgg.hook.entry.hooker.gg1011.GG1011Function.clearResults
import me.hd.hookgg.hook.entry.hooker.gg1011.GG1011Function.editAll
import me.hd.hookgg.hook.entry.hooker.gg1011.GG1011Function.getResults
import me.hd.hookgg.hook.entry.hooker.gg1011.GG1011Function.getResultsCount
import me.hd.hookgg.hook.entry.hooker.gg1011.GG1011Function.getValues
import me.hd.hookgg.hook.entry.hooker.gg1011.GG1011Function.makeRequest
import me.hd.hookgg.hook.entry.hooker.gg1011.GG1011Function.searchNumber
import me.hd.hookgg.hook.entry.hooker.gg1011.GG1011Function.setRanges
import me.hd.hookgg.hook.entry.hooker.gg1011.GG1011Function.setValues
import me.hd.hookgg.hook.entry.hooker.gg1011.GG1011Function.toast

object GG1011Hooker : BaseHooker() {
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
        if (configEntity.makeRequest) makeRequest()
    }
}