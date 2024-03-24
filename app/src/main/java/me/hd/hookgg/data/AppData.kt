package me.hd.hookgg.data

object AppData {
    val VERSION_LIST = arrayOf(
        "GG 96.0",
        "GG 96.1",
        "GG 101.1",
        "RLGG 2.0.9.2",
        "ELGG 1.1.4",
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
        GG.searchNumber,
        GG.getResultsCount,
        GG.getResults,
        GG.editAll,
        GG.getValues,
        GG.setValues,
        GG.addListItems,
        GG.makeRequest,
    )
}