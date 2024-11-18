package me.hd.hookgg.data.lib

object GGLib {
    const val addListItems = "gg.addListItems"
    const val alert = "gg.alert"
    const val allocatePage = "gg.allocatePage"
    const val bytes = "gg.bytes"
    const val choice = "gg.choice"
    const val clearList = "gg.clearList"
    const val clearResults = "gg.clearResults"
    const val copyMemory = "gg.copyMemory"
    const val copyText = "gg.copyText"
    const val disasm = "gg.disasm"
    const val dumpMemory = "gg.dumpMemory"
    const val editAll = "gg.editAll"
    const val getActiveTab = "gg.getActiveTab"
    const val getFile = "gg.getFile"
    const val getLine = "gg.getLine"
    const val getListItems = "gg.getListItems"
    const val getLocale = "gg.getLocale"
    const val getRanges = "gg.getRanges"
    const val getRangesList = "gg.getRangesList"
    const val getResults = "gg.getResults"
    const val getResultsCount = "gg.getResultsCount"
    const val getSelectedElements = "gg.getSelectedElements"
    const val getSelectedListItems = "gg.getSelectedListItems"
    const val getSelectedResults = "gg.getSelectedResults"
    const val getSpeed = "gg.getSpeed"
    const val getTargetInfo = "gg.getTargetInfo"
    const val getTargetPackage = "gg.getTargetPackage"
    const val getValues = "gg.getValues"
    const val getValuesRange = "gg.getValuesRange"
    const val gotoAddress = "gg.gotoAddress"
    const val hideUiButton = "gg.hideUiButton"
    const val internal1 = "gg.internal1"
    const val internal2 = "gg.internal2"
    const val internal3 = "gg.internal3"
    const val isClickedUiButton = "gg.isClickedUiButton"
    const val isPackageInstalled = "gg.isPackageInstalled"
    const val isProcessPaused = "gg.isProcessPaused"
    const val isVisible = "gg.isVisible"
    const val loadList = "gg.loadList"
    const val loadResults = "gg.loadResults"
    const val makeRequest = "gg.makeRequest"
    const val multiChoice = "gg.multiChoice"
    const val numberFromLocale = "gg.numberFromLocale"
    const val numberToLocale = "gg.numberToLocale"
    const val processKill = "gg.processKill"
    const val processPause = "gg.processPause"
    const val processResume = "gg.processResume"
    const val processToggle = "gg.processToggle"
    const val prompt = "gg.prompt"
    const val refineAddress = "gg.refineAddress"
    const val refineNumber = "gg.refineNumber"
    const val removeListItems = "gg.removeListItems"
    const val removeResults = "gg.removeResults"
    const val require = "gg.require"
    const val saveList = "gg.saveList"
    const val saveVariable = "gg.saveVariable"
    const val searchAddress = "gg.searchAddress"
    const val searchFuzzy = "gg.searchFuzzy"
    const val searchNumber = "gg.searchNumber"
    const val searchPointer = "gg.searchPointer"
    const val setRanges = "gg.setRanges"
    const val setSpeed = "gg.setSpeed"
    const val setValues = "gg.setValues"
    const val setVisible = "gg.setVisible"
    const val showUiButton = "gg.showUiButton"
    const val skipRestoreState = "gg.skipRestoreState"
    const val sleep = "gg.sleep"
    const val startFuzzy = "gg.startFuzzy"
    const val timeJump = "gg.timeJump"
    const val toast = "gg.toast"
    const val unrandomizer = "gg.unrandomizer"

    const val ASM_ARM = 4
    const val ASM_ARM64 = 6
    const val ASM_THUMB = 5
    const val DUMP_SKIP_SYSTEM_LIBS = 1
    const val FREEZE_IN_RANGE = 3
    const val FREEZE_MAY_DECREASE = 2
    const val FREEZE_MAY_INCREASE = 1
    const val FREEZE_NORMAL = 0
    const val LOAD_APPEND = 8
    const val LOAD_VALUES = 2
    const val LOAD_VALUES_FREEZE = 3
    const val POINTER_EXECUTABLE = 2
    const val POINTER_EXECUTABLE_WRITABLE = 1
    const val POINTER_NO = 4
    const val POINTER_READ_ONLY = 8
    const val POINTER_WRITABLE = 16
    const val PROT_EXEC = 4
    const val PROT_NONE = 0
    const val PROT_READ = 2
    const val PROT_WRITE = 1
    const val REGION_ANONYMOUS = 32
    const val REGION_ASHMEM = 524288
    const val REGION_BAD = 131072
    const val REGION_C_ALLOC = 4
    const val REGION_C_BSS = 16
    const val REGION_C_DATA = 8
    const val REGION_C_HEAP = 1
    const val REGION_CODE_APP = 16384
    const val REGION_CODE_SYS = 32768
    const val REGION_JAVA = 65536
    const val REGION_JAVA_HEAP = 2
    const val REGION_OTHER = -2080896
    const val REGION_PPSSPP = 262144
    const val REGION_STACK = 64
    const val REGION_VIDEO = 1048576
    const val SAVE_AS_TEXT = 1
    const val SIGN_EQUAL = 0x20000000
    const val SIGN_FUZZY_EQUAL = 0x20000000
    const val SIGN_FUZZY_GREATER = 0x04000000
    const val SIGN_FUZZY_LESS = 0x08000000
    const val SIGN_FUZZY_NOT_EQUAL = 0x10000000
    const val SIGN_GREATER_OR_EQUAL = 0x04000000
    const val SIGN_LESS_OR_EQUAL = 0x08000000
    const val SIGN_NOT_EQUAL = 0x10000000
    const val TAB_MEMORY_EDITOR = 3
    const val TAB_SAVED_LIST = 2
    const val TAB_SEARCH = 1
    const val TAB_SETTINGS = 0
    const val TYPE_AUTO = 127
    const val TYPE_BYTE = 1
    const val TYPE_DOUBLE = 64
    const val TYPE_DWORD = 4
    const val TYPE_FLOAT = 16
    const val TYPE_QWORD = 32
    const val TYPE_WORD = 2
    const val TYPE_XOR = 8

    object CONST {
        val ASM = mapOf(
            "gg.ASM_ARM" to ASM_ARM,
            "gg.ASM_THUMB" to ASM_THUMB,
            "gg.ASM_ARM64" to ASM_ARM64
        )
        val DUMP = mapOf(
            "gg.DUMP_SKIP_SYSTEM_LIBS" to DUMP_SKIP_SYSTEM_LIBS
        )
        val FREEZE = mapOf(
            "gg.FREEZE_NORMAL" to FREEZE_NORMAL,
            "gg.FREEZE_MAY_INCREASE" to FREEZE_MAY_INCREASE,
            "gg.FREEZE_MAY_DECREASE" to FREEZE_MAY_DECREASE,
            "gg.FREEZE_IN_RANGE" to FREEZE_IN_RANGE
        )
        val LOAD = mapOf(
            "gg.LOAD_VALUES_FREEZE" to LOAD_VALUES_FREEZE,
            "gg.LOAD_VALUES" to LOAD_VALUES,
            "gg.LOAD_APPEND" to LOAD_APPEND
        )
        val POINTER = mapOf(
            "gg.POINTER_NO" to POINTER_NO,
            "gg.POINTER_READ_ONLY" to POINTER_READ_ONLY,
            "gg.POINTER_WRITABLE" to POINTER_WRITABLE,
            "gg.POINTER_EXECUTABLE" to POINTER_EXECUTABLE,
            "gg.POINTER_EXECUTABLE_WRITABLE" to POINTER_EXECUTABLE_WRITABLE
        )
        val PROT = mapOf(
            "gg.PROT_NONE" to PROT_NONE,
            "gg.PROT_READ" to PROT_READ,
            "gg.PROT_WRITE" to PROT_WRITE,
            "gg.PROT_EXEC" to PROT_EXEC
        )
        val REGION = mapOf(
            "gg.REGION_JAVA_HEAP" to REGION_JAVA_HEAP,
            "gg.REGION_C_HEAP" to REGION_C_HEAP,
            "gg.REGION_C_ALLOC" to REGION_C_ALLOC,
            "gg.REGION_C_DATA" to REGION_C_DATA,
            "gg.REGION_C_BSS" to REGION_C_BSS,
            "gg.REGION_PPSSPP" to REGION_PPSSPP,
            "gg.REGION_ANONYMOUS" to REGION_ANONYMOUS,
            "gg.REGION_JAVA" to REGION_JAVA,
            "gg.REGION_STACK" to REGION_STACK,
            "gg.REGION_ASHMEM" to REGION_ASHMEM,
            "gg.REGION_VIDEO" to REGION_VIDEO,
            "gg.REGION_OTHER" to REGION_OTHER,
            "gg.REGION_BAD" to REGION_BAD,
            "gg.REGION_CODE_APP" to REGION_CODE_APP,
            "gg.REGION_CODE_SYS" to REGION_CODE_SYS
        )
        val SAVE = mapOf(
            "gg.SAVE_AS_TEXT" to SAVE_AS_TEXT
        )
        val SIGN = mapOf(
            "gg.SIGN_EQUAL" to SIGN_EQUAL,
            "gg.SIGN_NOT_EQUAL" to SIGN_NOT_EQUAL,
            "gg.SIGN_LESS_OR_EQUAL" to SIGN_LESS_OR_EQUAL,
            "gg.SIGN_GREATER_OR_EQUAL" to SIGN_GREATER_OR_EQUAL
        )
        val SIGN_FUZZY = mapOf(
            "gg.SIGN_FUZZY_EQUAL" to SIGN_FUZZY_EQUAL,
            "gg.SIGN_FUZZY_NOT_EQUAL" to SIGN_FUZZY_NOT_EQUAL,
            "gg.SIGN_FUZZY_LESS" to SIGN_FUZZY_LESS,
            "gg.SIGN_FUZZY_GREATER" to SIGN_FUZZY_GREATER
        )
        val TAB = mapOf(
            "gg.TAB_SETTINGS" to TAB_SETTINGS,
            "gg.TAB_SEARCH" to TAB_SEARCH,
            "gg.TAB_SAVED_LIST" to TAB_SAVED_LIST,
            "gg.TAB_MEMORY_EDITOR" to TAB_MEMORY_EDITOR
        )
        val TYPE = mapOf(
            "gg.TYPE_AUTO" to TYPE_AUTO,
            "gg.TYPE_BYTE" to TYPE_BYTE,
            "gg.TYPE_WORD" to TYPE_WORD,
            "gg.TYPE_DWORD" to TYPE_DWORD,
            "gg.TYPE_XOR" to TYPE_XOR,
            "gg.TYPE_FLOAT" to TYPE_FLOAT,
            "gg.TYPE_QWORD" to TYPE_QWORD,
            "gg.TYPE_DOUBLE" to TYPE_DOUBLE
        )
    }
}