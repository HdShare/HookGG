package me.hd.hookgg.hook.hooker.test

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker

object TestEntry : YukiBaseHooker() {
    override fun onHook() {
        //loadHooker(DexkitHooker)
        loadHooker(DaemonHooker)
    }
}