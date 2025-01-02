package me.hd.hookgg.hook

import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.configs
import com.highcapable.yukihookapi.hook.factory.encase
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit
import me.hd.hookgg.data.app.BuildData
import me.hd.hookgg.data.app.HookerData
import me.hd.hookgg.data.app.SetPrefsData
import me.hd.hookgg.hook.test.TestEntry

@InjectYukiHookWithXposed(entryClassName = "Entry")
object HookEntry : IYukiHookXposedInit {
    override fun onInit() = configs {
        debugLog {
            tag = BuildData.TAG
        }
        isDebug = BuildData.DEBUG
    }

    override fun onHook() = encase {
        if (YukiHookAPI.Status.isModuleActive && packageName != BuildData.APPLICATION_ID) {
            if (prefs.get(SetPrefsData.PACKAGE_NAME, "") == packageName) {
                loadApp(packageName) {
                    onAppLifecycle(false) {
                        onCreate {
                            if (prefs.get(SetPrefsData.TEST_FUNC)) {
                                loadHooker(TestEntry)
                            }
                            HookerData.getMapHooker(prefs.get(SetPrefsData.VERSION_NAME))?.let {
                                loadHooker(it)
                            }
                            // TODO Plugin
                            // PluginManager.loadPlugin()
                            // PluginManager.onPlugin("测试")
                        }
                    }
                }
            }
        }
    }
}