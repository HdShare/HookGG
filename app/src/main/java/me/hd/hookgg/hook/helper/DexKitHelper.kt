package me.hd.hookgg.hook.helper

import com.highcapable.yukihookapi.hook.log.YLog
import com.highcapable.yukihookapi.hook.param.PackageParam
import org.luckypray.dexkit.DexKitBridge

object DexKitHelper {
    private var isLoaded = false

    private fun loadDexKit() {
        if (isLoaded) return
        runCatching {
            System.loadLibrary("dexkit")
            isLoaded = true
        }.onFailure {
            YLog.error("Load DexKit Failed!", it)
        }
    }

    fun create(param: PackageParam, initiate: DexKitBridge.() -> Unit) {
        loadDexKit()
        runCatching {
            DexKitBridge.create(param.appInfo.sourceDir).use {
                initiate(it)
            }
        }
    }
}