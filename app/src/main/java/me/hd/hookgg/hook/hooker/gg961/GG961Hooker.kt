package me.hd.hookgg.hook.hooker.gg961

import com.highcapable.yukihookapi.hook.factory.dataChannel
import com.highcapable.yukihookapi.hook.factory.method
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.hook.base.BaseGGHooker
import me.hd.hookgg.hook.hooker.gg961.GG961VarArgs.arg
import me.hd.hookgg.hook.hooker.gg961.GG961VarArgs.checkint
import me.hd.hookgg.hook.hooker.gg961.GG961VarArgs.checkjstring
import me.hd.hookgg.hook.hooker.gg961.GG961VarArgs.checktable
import me.hd.hookgg.hook.hooker.gg961.GG961VarArgs.optboolean
import me.hd.hookgg.hook.hooker.gg961.GG961VarArgs.optint
import me.hd.hookgg.hook.hooker.gg961.GG961VarArgs.optjstring
import me.hd.hookgg.hook.hooker.gg961.GG961VarArgs.optlong
import me.hd.hookgg.hook.hooker.gg961.GG961VarArgs.optstring
import me.hd.hookgg.hook.hooker.gg961.GG961VarArgs.opttable

object GG961Hooker : BaseGGHooker() {
    override fun toast() {
        "android.ext.Script\$toast".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val text = varArgs.checkjstring(1)
                    val fast = varArgs.optboolean(2, false)
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
                        "log",
                        "gg.toast($text, $fast)"
                    )
                }
            }.ignoredAllFailure()
        }
    }

    override fun alert() {
        "android.ext.Script\$alert".toClassOrNull()?.apply {
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
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
                        "log",
                        "gg.alert($text, $positive, $negative, $neutral)"
                    )
                }
            }.ignoredAllFailure()
        }
    }

    override fun choice() {
        "android.ext.Script\$choice".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val items = varArgs.checktable(1)
                    val selected = varArgs.arg(2)
                    val message = varArgs.optjstring(3, "nil")
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
                        "log",
                        "gg.choice($items, $selected, $message)"
                    )
                }
            }.ignoredAllFailure()
        }
    }

    override fun multiChoice() {
        "android.ext.Script\$multiChoice".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val items = varArgs.checktable(1)
                    val selection = varArgs.opttable(2, null)
                    val message = varArgs.optjstring(3, "nil")
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
                        "log",
                        "gg.multiChoice($items, $selection, $message)"
                    )
                }
            }.ignoredAllFailure()
        }
    }

    override fun prompt() {
        "android.ext.Script\$prompt".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val items = varArgs.checktable(1)
                    val defaults = varArgs.opttable(2, null)
                    val types = varArgs.opttable(3, null)
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
                        "log",
                        "gg.prompt($items, $defaults, $types)"
                    )
                }
            }.ignoredAllFailure()
        }
    }

    override fun clearResults() {
        "android.ext.Script\$clearResults".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                before {
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
                        "log",
                        "gg.clearResults()"
                    )
                }
            }.ignoredAllFailure()
        }
    }

    override fun setRanges() {
        "android.ext.Script\$setRanges".toClassOrNull()?.apply {
            method {
                name = "d"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val ranges = varArgs.checkint(1)
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
                        "log",
                        "gg.setRanges($ranges)"
                    )
                }
            }.ignoredAllFailure()
        }
    }

    override fun getRangesList() {
        "android.ext.Script\$getRangesList".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val filter = varArgs.optjstring(1, "")
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
                        "log",
                        "gg.getRangesList($filter)"
                    )
                }
            }.ignoredAllFailure()
        }
    }

    override fun searchNumber() {
        "android.ext.Script\$searchNumber".toClassOrNull()?.apply {
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
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
                        "log",
                        "gg.searchNumber($text, $type, $encrypted, $sign, $memoryFrom, $memoryTo)"
                    )
                }
            }.ignoredAllFailure()
        }
    }

    override fun getResultsCount() {
        "android.ext.Script\$getResultsCount".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
                        "log",
                        "gg.getResultsCount()"
                    )
                }
            }.ignoredAllFailure()
        }
    }

    override fun getResults() {
        "android.ext.Script\$getResults".toClassOrNull()?.apply {
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
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
                        "log",
                        "gg.getResults($maxCount, $skip, $addressMin, $addressMax, $valueMin, $valueMax, $type, $fractional, $pointer)"
                    )
                }
            }.ignoredAllFailure()
        }
    }

    override fun editAll() {
        "android.ext.Script\$editAll".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val value = varArgs.checkjstring(1)
                    val type = varArgs.checkint(2)
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
                        "log",
                        "gg.editAll($value, $type)"
                    )
                }
            }.ignoredAllFailure()
        }
    }

    override fun getValues() {
        "android.ext.Script\$getValues".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val values = varArgs.checktable(1)
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
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
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
                        "log",
                        "gg.setValues($values)"
                    )
                }
            }.ignoredAllFailure()
        }
    }

    override fun addListItems() {
        "android.ext.Script\$addListItems".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val items = varArgs.checktable(1)
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
                        "log",
                        "gg.addListItems($items)"
                    )
                }
            }.ignoredAllFailure()
        }
    }

    override fun makeRequest() {
        "android.ext.Script\$makeRequest".toClassOrNull()?.apply {
            method {
                name = "b"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val url = varArgs.checkjstring(1)
                    val headers = varArgs.opttable(2, null)
                    val data = varArgs.optstring(3, null)
                    appContext?.dataChannel(BuildConfig.APPLICATION_ID)?.put(
                        "log",
                        "gg.makeRequest($url, $headers, $data)"
                    )
                }
            }.ignoredAllFailure()
        }
    }
}