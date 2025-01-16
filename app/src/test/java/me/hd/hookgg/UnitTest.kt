package me.hd.hookgg

import org.junit.Test
import org.luaj.vm2.Globals
import org.luaj.vm2.LoadState
import org.luaj.vm2.compiler.LuaC
import org.luaj.vm2.lib.BaseLib

class UnitTest {
    @Test
    fun main() {
        val globals = Globals().apply {
            load(BaseLib())
            LoadState.install(this)
            LuaC.install(this)
        }
        globals.load("""print('Hello World');""").call()
    }
}