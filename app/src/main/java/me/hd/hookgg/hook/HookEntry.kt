package me.hd.hookgg.hook

import android.annotation.SuppressLint
import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.configs
import com.highcapable.yukihookapi.hook.factory.encase
import com.highcapable.yukihookapi.hook.log.YLog
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.data.AppData
import me.hd.hookgg.data.SetPrefsData
import me.hd.hookgg.hook.loader.HdClassLoader
import me.hd.hookgg.hook.module.DemoModule
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
                            if (prefs.get(SetPrefsData.MODULE_FUNC)) {
                                val self = HookEntry::class.java.classLoader!!
                                HdClassLoader.parentLoader = self.parent
                                HdClassLoader.hostLoader = appClassLoader!!
                                if (injectClassLoader(self, HdClassLoader)) {
                                    loadHooker(DemoModule)
                                }
                            }
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

    @SuppressLint("DiscouragedPrivateApi")
    private fun injectClassLoader(self: ClassLoader, newParent: ClassLoader): Boolean {
        return runCatching {
            val fieldParent = ClassLoader::class.java
                .getDeclaredField("parent")
                .apply { isAccessible = true }
            fieldParent.set(self, newParent)
        }.onFailure {
            YLog.error("injectClassLoader failure")
        }.onSuccess {
            YLog.error("injectClassLoader success")
        }.isSuccess
    }
}