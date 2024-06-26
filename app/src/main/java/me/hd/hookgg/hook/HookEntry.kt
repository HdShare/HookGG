package me.hd.hookgg.hook

import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.configs
import com.highcapable.yukihookapi.hook.factory.encase
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.data.AppData
import me.hd.hookgg.data.SetPagePrefsData
import me.hd.hookgg.hook.hooker.agg333.AGG333Hooker
import me.hd.hookgg.hook.hooker.elgg114.ELGG114Hooker
import me.hd.hookgg.hook.hooker.elgg120.ELGG120Hooker
import me.hd.hookgg.hook.hooker.gg1011.GG1011Hooker
import me.hd.hookgg.hook.hooker.gg960.GG960Hooker
import me.hd.hookgg.hook.hooker.gg961.GG961Hooker
import me.hd.hookgg.hook.hooker.rlgg2092.RLGG2092Hooker

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
            if (prefs.get(SetPagePrefsData.PACKAGE_NAME, "") == packageName) {
                loadApp(packageName) {
                    when (prefs.get(SetPagePrefsData.VERSION_NAME)) {
                        AppData.VERSION_LIST[0] -> loadHooker(GG960Hooker)
                        AppData.VERSION_LIST[1] -> loadHooker(GG961Hooker)
                        AppData.VERSION_LIST[2] -> loadHooker(GG1011Hooker)
                        AppData.VERSION_LIST[3] -> loadHooker(RLGG2092Hooker)
                        AppData.VERSION_LIST[4] -> loadHooker(ELGG114Hooker)
                        AppData.VERSION_LIST[5] -> loadHooker(ELGG120Hooker)
                        AppData.VERSION_LIST[6] -> loadHooker(AGG333Hooker)
                    }
                }
            }
        }
    }
}