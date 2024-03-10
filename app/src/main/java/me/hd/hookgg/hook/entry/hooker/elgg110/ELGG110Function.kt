package me.hd.hookgg.hook.entry.hooker.elgg110

import com.highcapable.yukihookapi.hook.factory.dataChannel
import com.highcapable.yukihookapi.hook.factory.method
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.hook.entry.base.BaseFunction
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Hooker.hook
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Hooker.toClassOrNull
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Method.checkint
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Method.checkjstring
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Method.checktable
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Method.optboolean
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Method.optint
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Method.optjstring
import me.hd.hookgg.hook.entry.hooker.elgg110.ELGG110Method.optlong

object ELGG110Function : BaseFunction {
    override fun toast() {
        "android.ext.ۧۧۦۧ".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val text = varArgs.checkjstring(1)
                    val fast = varArgs.optboolean(2, false)
                    ELGG110Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.toast($text, $fast)"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun alert() {
        "android.ext.۟ۧ۠ۡ۠".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val text = varArgs.checkjstring(1)
                    val positive = varArgs.optjstring(2, "ok")
                    val negative = varArgs.optjstring(3, "nil")
                    val neutral = varArgs.optjstring(4, "nil")
                    ELGG110Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.alert($text, $positive, $negative, $neutral)"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun clearResults() {
        "android.ext.۟ۧ۠۠ۨ".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                before {
                    ELGG110Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.clearResults()"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun setRanges() {
        "android.ext.۟ۧ۠ۥۣ".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val ranges = varArgs.checkint(1)
                    ELGG110Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.setRanges($ranges)"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun searchNumber() {
        "android.ext.ۣۣۧۧ".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val text = varArgs.checkjstring(1)
                    val type = varArgs.optint(2, 127)
                    val encrypted = varArgs.optboolean(3, false)
                    val sign = varArgs.optint(4, 0x20000000)
                    val memoryFrom = varArgs.optlong(5, 0L)
                    val memoryTo = varArgs.optlong(6, -1L)
                    val limit = varArgs.optlong(7, 0)
                    ELGG110Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.searchNumber($text, $type, $encrypted, $sign, $memoryFrom, $memoryTo, $limit)"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun getResultsCount() {
        "android.ext.ۧۧۡۢ".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    ELGG110Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.getResultsCount()"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun getResults() {
        "android.ext.ۧۧۡۡ".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val maxCount = varArgs.checkint(1)
                    val skip = varArgs.optint(2, 0)
                    val addressMin = varArgs.optlong(3, 0L)
                    val addressMax = varArgs.optlong(4, -1L)
                    val valueMin = varArgs.optjstring(5, "nil")
                    val valueMax = varArgs.optjstring(6, "nil")
                    val type = varArgs.optint(7, 0)
                    val fractional = varArgs.optjstring(8, "nil")
                    val pointer = varArgs.optint(9, 0)
                    ELGG110Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.getResults($maxCount, $skip, $addressMin, $addressMax, $valueMin, $valueMax, $type, $fractional, $pointer)"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun editAll() {
        "android.ext.ۧۧۢۡ".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val value = varArgs.checkjstring(1)
                    val type = varArgs.checkint(2)
                    ELGG110Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.editAll($value, $type)"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun getValues() {
        "android.ext.ۧۧۥ۟".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val values = varArgs.checktable(1)
                    ELGG110Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.getValues($values)"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun setValues() {
        "android.ext.Script\$setValues".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val values = varArgs.checktable(1)
                    ELGG110Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.setValues($values)"
                        )
                }
            }.ignoredAllFailure()
        }
    }

    override fun addListItems() {
        "android.ext.ۣۧۧۢ".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val items = varArgs.checktable(1)
                    ELGG110Hooker.appContext
                        ?.dataChannel(BuildConfig.APPLICATION_ID)
                        ?.put(
                            "log",
                            "gg.addListItems($items)"
                        )
                }
            }.ignoredAllFailure()
        }
    }
}