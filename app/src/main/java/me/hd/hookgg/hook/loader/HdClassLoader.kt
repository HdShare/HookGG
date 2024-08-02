package me.hd.hookgg.hook.loader

object HdClassLoader : ClassLoader() {
    lateinit var parentLoader: ClassLoader
    lateinit var hostLoader: ClassLoader

    override fun loadClass(name: String?): Class<*> {
        return runCatching {
            parentLoader.loadClass(name)
        }.getOrElse {
            runCatching {
                hostLoader.loadClass(name)
            }.getOrElse {
                super.loadClass(name)
            }
        }
    }
}