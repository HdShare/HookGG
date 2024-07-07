package me.hd.hookgg.hook

import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.configs
import com.highcapable.yukihookapi.hook.factory.encase
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.data.AppData
import me.hd.hookgg.data.SetPrefsData
import me.hd.hookgg.hook.hooker.agg.v333.AGGv333Hooker
import me.hd.hookgg.hook.hooker.elgg.v114.ELGGv114Hooker
import me.hd.hookgg.hook.hooker.elgg.v120.ELGGv120Hooker
import me.hd.hookgg.hook.hooker.gg.v1011.GGv1011Hooker
import me.hd.hookgg.hook.hooker.gg.v960.GGv960Hooker
import me.hd.hookgg.hook.hooker.gg.v961.GGv961Hooker
import me.hd.hookgg.hook.hooker.rlgg.v2092.RLGGv2092Hooker

@InjectYukiHookWithXposed(entryClassName = "Entry")
object HookEntry : IYukiHookXposedInit {
    override fun onInit() = configs {
        debugLog {
            tag = BuildConfig.TAG
        }
        //isDebug = BuildConfig.DEBUG
        isDebug = false
    }

    override fun onHook() = encase {
        if (YukiHookAPI.Status.isModuleActive && packageName != BuildConfig.APPLICATION_ID) {
            if (prefs.get(SetPrefsData.PACKAGE_NAME, "") == packageName) {
                loadApp(packageName) {
                    when (prefs.get(SetPrefsData.VERSION_NAME)) {
                        AppData.getVersionList()[0] -> loadHooker(GGv960Hooker)
                        AppData.getVersionList()[1] -> loadHooker(GGv961Hooker)
                        AppData.getVersionList()[2] -> loadHooker(GGv1011Hooker)
                        AppData.getVersionList()[3] -> loadHooker(RLGGv2092Hooker)
                        AppData.getVersionList()[4] -> loadHooker(ELGGv114Hooker)
                        AppData.getVersionList()[5] -> loadHooker(ELGGv120Hooker)
                        AppData.getVersionList()[6] -> loadHooker(AGGv333Hooker)
                    }
                }
            }
        }
    }
}