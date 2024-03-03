package me.hd.hookgg.hook.utils

import android.app.Application
import com.highcapable.yukihookapi.hook.factory.dataChannel
import me.hd.hookgg.BuildConfig

object LogUtil {

    fun Application?.sendLog(log: String) {
        this?.dataChannel(BuildConfig.APPLICATION_ID)?.put("log", log)
    }

}