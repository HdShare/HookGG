package me.hd.hookgg.hook.entry.hooker.agg332beta

import me.hd.hookgg.hook.entity.ConfigEntity
import me.hd.hookgg.hook.entry.base.BaseHooker
import me.hd.hookgg.hook.entry.hooker.agg332beta.AGG332BetaFunction.addListItems
import me.hd.hookgg.hook.entry.hooker.agg332beta.AGG332BetaFunction.alert
import me.hd.hookgg.hook.entry.hooker.agg332beta.AGG332BetaFunction.clearResults
import me.hd.hookgg.hook.entry.hooker.agg332beta.AGG332BetaFunction.editAll
import me.hd.hookgg.hook.entry.hooker.agg332beta.AGG332BetaFunction.getResults
import me.hd.hookgg.hook.entry.hooker.agg332beta.AGG332BetaFunction.getResultsCount
import me.hd.hookgg.hook.entry.hooker.agg332beta.AGG332BetaFunction.getValues
import me.hd.hookgg.hook.entry.hooker.agg332beta.AGG332BetaFunction.searchNumber
import me.hd.hookgg.hook.entry.hooker.agg332beta.AGG332BetaFunction.setRanges
import me.hd.hookgg.hook.entry.hooker.agg332beta.AGG332BetaFunction.setValues
import me.hd.hookgg.hook.entry.hooker.agg332beta.AGG332BetaFunction.toast

object AGG332BetaHooker : BaseHooker() {
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