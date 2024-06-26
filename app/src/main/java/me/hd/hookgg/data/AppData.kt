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
        GGData.addListItems,
        GGData.alert,
        GGData.choice,
        GGData.clearResults,
        GGData.editAll,
        GGData.getRangesList,
        GGData.getResults,
        GGData.getResultsCount,
        GGData.getValues,
        GGData.makeRequest,
        GGData.multiChoice,
        GGData.prompt,
        GGData.searchNumber,
        GGData.searchPointer,
        GGData.setRanges,
        GGData.setValues,
        GGData.toast,
    )
}