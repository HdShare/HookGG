package me.hd.hookgg

import com.google.android.material.color.DynamicColors
import com.highcapable.yukihookapi.hook.xposed.application.ModuleApplication

class MyApp : ModuleApplication() {
    companion object {
        lateinit var instance: MyApp
        val context get() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}