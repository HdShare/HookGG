package me.hd.hookgg.ui.utils

import android.content.Context
import java.util.Locale

fun Context.setLanguage(locale: Locale): Context {
    return createConfigurationContext(
        resources.configuration.apply {
            Locale.setDefault(locale)
            setLocale(locale)
        }
    )
}