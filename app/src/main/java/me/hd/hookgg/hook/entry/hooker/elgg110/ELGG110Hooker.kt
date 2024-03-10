package me.hd.hookgg.hook.entry.hooker.elgg110

import me.hd.hookgg.hook.entity.ConfigEntity
import me.hd.hookgg.hook.entry.base.BaseHooker
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Function.addListItems
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Function.alert
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Function.clearResults
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Function.editAll
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Function.getResults
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Function.getResultsCount
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Function.getValues
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Function.searchNumber
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Function.setRanges
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Function.setValues
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Function.toast

object ELGG110Hooker : BaseHooker() {
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