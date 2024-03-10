package me.hd.hookgg.hook

import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.configs
import com.highcapable.yukihookapi.hook.factory.encase
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.data.ConfigData
import me.hd.hookgg.hook.entry.hooker.agg332beta.AGG332BetaHooker
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Hooker
import me.hd.hookgg.hook.entry.hooker.gg1011.GG1011Hooker
import me.hd.hookgg.hook.entry.hooker.gg960.GG960Hooker
import me.hd.hookgg.hook.entry.hooker.gg961.GG961Hooker
import me.hd.hookgg.hook.entry.hooker.rlgg2092.RLGG2092Hooker
import me.hd.hookgg.hook.utils.ConfigUtil.getSingleChoiceItems

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
            if (prefs.get(ConfigData.SET_PACKAGE_NAME, "") == packageName) {
                loadApp(packageName) {
                    when (prefs.get(ConfigData.SET_VERSION_NAME)) {
                        getSingleChoiceItems()[0] -> loadHooker(GG960Hooker)
                        getSingleChoiceItems()[1] -> loadHooker(GG961Hooker)
                        getSingleChoiceItems()[2] -> loadHooker(GG1011Hooker)
                        getSingleChoiceItems()[3] -> loadHooker(RLGG2092Hooker)
                        getSingleChoiceItems()[4] -> loadHooker(ELGG110Hooker)
                        getSingleChoiceItems()[5] -> loadHooker(AGG332BetaHooker)
                    }
                }
            }
        }
    }
}