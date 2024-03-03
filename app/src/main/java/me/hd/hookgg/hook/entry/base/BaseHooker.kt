package me.hd.hookgg.hook.entry.base

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import me.hd.hookgg.hook.entity.ConfigEntity
import me.hd.hookgg.hook.utils.ConfigUtil

abstract class BaseHooker : YukiBaseHooker() {
    override fun onHook() {
        val configEntity = ConfigUtil.getConfigEntity(prefs)
        onConfigHook(configEntity)
    }

    abstract fun onConfigHook(configEntity: ConfigEntity)
}