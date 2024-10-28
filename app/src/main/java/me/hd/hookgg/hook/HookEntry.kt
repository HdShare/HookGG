package me.hd.hookgg.hook

import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.configs
import com.highcapable.yukihookapi.hook.factory.encase
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.data.AppData
import me.hd.hookgg.data.SetPrefsData
import me.hd.hookgg.hook.test.TestEntry

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
                    onAppLifecycle(false) {
                        onCreate {
                            if (prefs.get(SetPrefsData.TEST_FUNC)) {
                                loadHooker(TestEntry)
                            }
                            AppData.getMapHooker(prefs.get(SetPrefsData.VERSION_NAME))?.let {
                                loadHooker(it)
                            }
                        }
                    }
                }
            }
        }
    }
}