package me.hd.hookgg.plugin

import java.io.File

object PluginManager {
    private const val PLUGIN_DIR_PATH = "/storage/emulated/0/Download"
    private lateinit var pluginBean: PluginBean

    fun loadPlugin() {
        initFileEnv()
        File(PLUGIN_DIR_PATH).listFiles { file ->
            file.name.endsWith(".java")
        }?.forEach { file ->
            if (file.name == "DemoPlugin.java") {
                pluginBean = PluginBean(file)
                pluginBean.loadPlugin()
            }
        }
    }

    private fun initFileEnv() {
        val demoPlugin = File("$PLUGIN_DIR_PATH/DemoPlugin.java")
        if (!demoPlugin.exists()) {
            demoPlugin.writeText(
                """
                |
                |log1("初始化时间戳: " + initTime);
                |
                """.trimMargin()
            )
        }
    }

    fun onPlugin(str: String) {
        pluginBean.onPlugin(str)
    }
}