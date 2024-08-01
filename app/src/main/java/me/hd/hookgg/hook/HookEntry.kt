package me.hd.hookgg.hook

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
                            if (prefs.get(SetPrefsData.TEST_FUNC)) {
                                loadHooker(TestEntry)
                            }
                            if (prefs.get(SetPrefsData.MODULE_FUNC)) {
                                HdClassLoader.hostClassLoader = appClassLoader!!
                                if (injectClassloader(HookEntry::class.java.classLoader)) {
                                    loadHooker(DemoModule)
                                }
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

    private fun injectClassloader(moduleLoader: ClassLoader?): Boolean {
        moduleLoader ?: return false
        val varArgsClassName = "luaj.Varargs"
        if (runCatching { moduleLoader.loadClass(varArgsClassName) }.isSuccess) {
            YLog.debug("already load stub")
            return true
        }
        val classLoaderParent = ClassLoader::class.java.declaredFields
            .first { it.name == "parent" }
            .apply { isAccessible = true }
        classLoaderParent.set(moduleLoader, null)
        if (HdClassLoader.load(varArgsClassName) == null) {
            YLog.debug("load stub failed")
            return false
        }
        classLoaderParent.set(moduleLoader, HdClassLoader)
        return runCatching { Class.forName(varArgsClassName) }
            .onFailure { YLog.debug("inject failure") }
            .onSuccess { YLog.debug("inject success") }
            .isSuccess
    }
}