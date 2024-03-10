package me.hd.hookgg.hook.entry.hooker

import me.hd.hookgg.hook.entity.ConfigEntity
import me.hd.hookgg.hook.entry.base.BaseHooker
import me.hd.hookgg.hook.entry.impl.AGG332BetaFunction

object AGG332BetaHooker : BaseHooker() {
    override fun onConfigHook(configEntity: ConfigEntity) {
        if (configEntity.toast) AGG332BetaFunction.toast()
        if (configEntity.alert) AGG332BetaFunction.alert()
        if (configEntity.clearResults) AGG332BetaFunction.clearResults()
        if (configEntity.setRanges) AGG332BetaFunction.setRanges()
        if (configEntity.searchNumber) AGG332BetaFunction.searchNumber()
        if (configEntity.getResultsCount) AGG332BetaFunction.getResultsCount()
        if (configEntity.getResults) AGG332BetaFunction.getResults()
        if (configEntity.editAll) AGG332BetaFunction.editAll()
        if (configEntity.getValues) AGG332BetaFunction.getValues()
        if (configEntity.setValues) AGG332BetaFunction.setValues()
        if (configEntity.addListItems) AGG332BetaFunction.addListItems()
    }
}