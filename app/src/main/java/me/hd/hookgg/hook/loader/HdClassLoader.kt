package me.hd.hookgg.hook.loader

object HdClassLoader : ClassLoader() {
    lateinit var hostClassLoader: ClassLoader

    fun load(name: String): Class<*>? {
        return runCatching {
            loadClass(name)
        }.getOrNull()
    }

    override fun loadClass(name: String?): Class<*> {
        return runCatching {
            hostClassLoader.loadClass(name)
        }.getOrElse {
            super.loadClass(name)
        }
    }
}