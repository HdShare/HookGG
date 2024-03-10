package me.hd.hookgg.hook.entry.hooker.gg961

import me.hd.hookgg.hook.entity.ConfigEntity
import me.hd.hookgg.hook.entry.base.BaseHooker
import me.hd.hookgg.hook.entry.hooker.gg961.GG961Function.addListItems
import me.hd.hookgg.hook.entry.hooker.gg961.GG961Function.alert
import me.hd.hookgg.hook.entry.hooker.gg961.GG961Function.clearResults
import me.hd.hookgg.hook.entry.hooker.gg961.GG961Function.editAll
import me.hd.hookgg.hook.entry.hooker.gg961.GG961Function.getResults
import me.hd.hookgg.hook.entry.hooker.gg961.GG961Function.getResultsCount
import me.hd.hookgg.hook.entry.hooker.gg961.GG961Function.getValues
import me.hd.hookgg.hook.entry.hooker.gg961.GG961Function.searchNumber
import me.hd.hookgg.hook.entry.hooker.gg961.GG961Function.setRanges
import me.hd.hookgg.hook.entry.hooker.gg961.GG961Function.setValues
import me.hd.hookgg.hook.entry.hooker.gg961.GG961Function.toast

object GG961Hooker : BaseHooker() {
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