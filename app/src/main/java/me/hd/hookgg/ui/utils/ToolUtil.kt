package me.hd.hookgg.ui.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import me.hd.hookgg.BuildConfig

object ToolUtil {
    fun copyToClipboard(context: Context, str: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText(BuildConfig.TAG, str)
        clipboard.setPrimaryClip(clip)
    }
}