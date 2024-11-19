package me.hd.hookgg.plugin

import bsh.BshMethod
import bsh.Interpreter
import de.robv.android.xposed.XposedHelpers
import java.io.File

class PluginBean(private val pluginFile: File) {
    private val interpreter = Interpreter()
    private var isInit = false

    fun loadPlugin() {
        if (!isInit) {
            initEnv()
            isInit = true
        }
        interpreter.eval(pluginFile.reader())
    }

    private fun initEnv() {
        interpreter["initTime"] = System.currentTimeMillis()
        interpreter.nameSpace.setMethod(
            "log1",
            XposedHelpers.newInstance(
                BshMethod::class.java,
                PluginApi::class.java.getMethod("log1", String::class.java),
                null
            ) as BshMethod
        )
        interpreter.eval("import static me.hd.hookgg.plugin.PluginApi.*;")
    }

    fun onPlugin(str: String) {
        interpreter.nameSpace.getMethod(
            "onPlugin",
            arrayOf(String::class.java)
        )?.invoke(
            arrayOf(str),
            interpreter
        )
    }
}