package me.hd.hookgg.config.data

import androidx.annotation.StringRes
import com.highcapable.yukihookapi.hook.param.PackageParam
import me.hd.hookgg.R

object ResStrData {
    val FILTER_INVALID_LENGTH = R.string.filter_invalid_length
    val FILTER_INVALID_PARAMS = R.string.filter_invalid_params

    fun PackageParam.getResStr(@StringRes id: Int): String {
        return moduleAppResources.getString(id)
    }
}