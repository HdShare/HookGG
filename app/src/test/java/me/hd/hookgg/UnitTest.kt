package me.hd.hookgg

import org.junit.Test
import org.luaj.vm2.Globals
import org.luaj.vm2.LoadState
import org.luaj.vm2.compiler.LuaC
import org.luaj.vm2.lib.BaseLib

class UnitTest {
    @Test
    fun main() {
        println("main")
        val globals = Globals().apply {
            load(BaseLib())
            LoadState.install(this)
            LuaC.install(this)
        }
        val code = globals.load(
            """
            print("Hello!")
        """.trimIndent()
        )
        code.call()
    }

    @Test
    fun unLuac() {
        println("unLuac")
        // unluac.Main.main(arrayOf("--help"))
        /**
         * --assemble：将给定的反汇编列表组装起来。
         * --disassemble：反汇编，而不是反编译。
         * --nodebug：忽略输入文件中的调试信息。
         * --typemap <file>：使用在<file>中指定的类型映射。
         * --opmap <file>：使用在<file>中指定的操作码映射。
         * --output <file>：输出到<file>，而不是标准输出。
         * --rawstring：将字符串字节直接复制到输出。
         * --luaj：模拟Luaj的宽容解析器。
         */
        // unluac.Main.main(arrayOf("--disassemble", "--output", "output.txt", "input.lua"))
    }
}