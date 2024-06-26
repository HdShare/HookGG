package me.hd.hookgg.data

object AppData {
    val VERSION_LIST = arrayOf(
        "GG 96.0",
        "GG 96.1",
        "GG 101.1",
        "RLGG 2.0.9.2",
        "ELGG 1.1.0~1.1.6",
        "ELGG 1.2.0",
        "AGG 3.3.3",
    )
    val FUNCTION_LIST = arrayOf(
        GG.toast,
        GG.alert,
        GG.choice,
        GG.multiChoice,
        GG.prompt,
        GG.clearResults,
        GG.setRanges,
        GG.getRangesList,
        GG.searchNumber,
        GG.searchPointer,
        GG.getResultsCount,
        GG.getResults,
        GG.editAll,
        GG.getValues,
        GG.setValues,
        GG.addListItems,
        GG.makeRequest,
    )
}