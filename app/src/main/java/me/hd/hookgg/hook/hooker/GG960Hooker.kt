package me.hd.hookgg.hook.hooker

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.method
import me.hd.hookgg.hook.utils.ConfigUtil
import me.hd.hookgg.hook.utils.LogUtil.sendLog
import me.hd.hookgg.hook.utils.MethodUtil.checkint
import me.hd.hookgg.hook.utils.MethodUtil.checkjstring
import me.hd.hookgg.hook.utils.MethodUtil.checktable
import me.hd.hookgg.hook.utils.MethodUtil.optboolean
import me.hd.hookgg.hook.utils.MethodUtil.optint
import me.hd.hookgg.hook.utils.MethodUtil.optjstring
import me.hd.hookgg.hook.utils.MethodUtil.optlong

object GG960Hooker : YukiBaseHooker() {

    override fun onHook() {
        val configEntity = ConfigUtil.getConfigEntity(prefs)
        if (configEntity.toast) toast()
        if (configEntity.alert) alert()
        if (configEntity.clearResults) clearResults()
        if (configEntity.setRanges) setRanges()
        if (configEntity.searchNumber) searchNumber()
        if (configEntity.getResultsCount) getResultsCount()
        if (configEntity.getResults) getResults()
        if (configEntity.editAll) editAll()
        if (configEntity.getValues) getValues()
        if (configEntity.setValues) setValues()
        if (configEntity.addListItems) addListItems()
    }

    /**
     * gg.toast(string text, bool fast)
     */
    private fun toast() {
        "android.ext.Script\$toast".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val text = varArgs.checkjstring(1)
                    val fast = varArgs.optboolean(2, false)
                    appContext.sendLog("gg.toast($text, $fast)")
                }
            }
        }
    }

    /**
     * gg.alert(string text, string positive, string negative, string neutral)
     */
    private fun alert() {
        "android.ext.Script\$alert".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val text = varArgs.checkjstring(1)
                    val positive = varArgs.optjstring(2, "ok")
                    val negative = varArgs.optjstring(3, "nil")
                    val neutral = varArgs.optjstring(4, "nil")
                    appContext.sendLog("gg.alert($text, $positive, $negative, $neutral)")
                }
            }
        }
    }

    /**
     * gg.clearResults()
     */
    private fun clearResults() {
        "android.ext.Script\$clearResults".toClassOrNull()?.apply {
            method {
                name = "invokeUi"
                paramCount = 1
            }.ignored().hook {
                before {
                    appContext.sendLog("gg.clearResults()")
                }
            }
        }
    }

    /**
     * gg.setRanges(int ranges)
     */
    private fun setRanges() {
        "android.ext.Script\$setRanges".toClassOrNull()?.apply {
            method {
                name = "invokeUi"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val ranges = varArgs.checkint(1)
                    appContext.sendLog("gg.setRanges($ranges)")
                }
            }
        }
    }

    /**
     * gg.searchNumber(string text, int type, bool encrypted, int sign, long memoryFrom, long memoryTo)
     */
    private fun searchNumber() {
        "android.ext.Script\$searchNumber".toClassOrNull()?.apply {
            method {
                name = "invokeUi"
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
                    appContext.sendLog("gg.searchNumber($text, $type, $encrypted, $sign, $memoryFrom, $memoryTo)")
                }
            }
        }
    }

    /**
     * gg.getResultsCount()
     */
    private fun getResultsCount() {
        "android.ext.Script\$getResultsCount".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                before {
                    appContext.sendLog("gg.getResultsCount()")
                }
            }
        }
    }

    /**
     * gg.getResults(int maxCount, int skip, long addressMin, long addressMax, string valueMin, string valueMax, int type, string fractional, int pointer)
     */
    private fun getResults() {
        "android.ext.Script\$getResults".toClassOrNull()?.apply {
            method {
                name = "invokeUi"
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
                    appContext.sendLog("gg.getResults($maxCount, $skip, $addressMin, $addressMax, $valueMin, $valueMax, $type, $fractional, $pointer)")
                }
            }
        }
    }

    /**
     * gg.editAll(string value, int type)
     */
    private fun editAll() {
        "android.ext.Script\$editAll".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val value = varArgs.checkjstring(1)
                    val type = varArgs.checkint(2)
                    appContext.sendLog("gg.editAll($value, $type)")
                }
            }
        }
    }

    /**
     * gg.getValues(table values)
     */
    private fun getValues() {
        "android.ext.Script\$getValues".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val values = varArgs.checktable(1)
                    appContext.sendLog("gg.getValues($values)")
                }
            }
        }
    }

    /**
     * gg.setValues(table values)
     */
    private fun setValues() {
        "android.ext.Script\$setValues".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val values = varArgs.checktable(1)
                    appContext.sendLog("gg.setValues($values)")
                }
            }
        }
    }

    /**
     * gg.addListItems(table items)
     */
    private fun addListItems() {
        "android.ext.Script\$addListItems".toClassOrNull()?.apply {
            method {
                name = "invoke2"
                paramCount = 1
            }.ignored().hook {
                before {
                    val varArgs = args(0).any()
                    val items = varArgs.checktable(1)
                    appContext.sendLog("gg.addListItems($items)")
                }
            }
        }
    }

}