package me.hd.hookgg.hook.utils

import com.highcapable.yukihookapi.hook.param.PackageParam
import org.luckypray.dexkit.DexKitBridge

object DexKitUtil {
    private var isLoaded = false

    private fun loadDexKit() {
        if (!isLoaded) {
            System.loadLibrary("dexkit")
            isLoaded = true
        }
    }

    fun create(param: PackageParam, initiate: DexKitBridge.() -> Unit) {
        loadDexKit()
        DexKitBridge.create(param.appInfo.sourceDir).use {
            initiate(it)
        }
    }
}