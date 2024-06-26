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
        GG.addListItems,
        GG.alert,
        GG.choice,
        GG.clearResults,
        GG.editAll,
        GG.getRangesList,
        GG.getResults,
        GG.getResultsCount,
        GG.getValues,
        GG.makeRequest,
        GG.multiChoice,
        GG.prompt,
        GG.searchNumber,
        GG.searchPointer,
        GG.setRanges,
        GG.setValues,
        GG.toast,
    )
}