package me.hd.hookgg.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexboxLayoutManager
import com.highcapable.yukihookapi.hook.factory.prefs
import me.hd.hookgg.MyApp
import me.hd.hookgg.data.AppData
import me.hd.hookgg.data.SetPrefsData
import me.hd.hookgg.databinding.ItemRvFuncBinding

class FuncAdapter : RecyclerView.Adapter<FuncAdapter.ModuleViewHolder>() {
    private val moduleNameList =
        AppData.getFunctionList(MyApp.context.prefs().get(SetPrefsData.VERSION_NAME))

    class ModuleViewHolder(val binding: ItemRvFuncBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount() = moduleNameList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val view = ItemRvFuncBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModuleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        val moduleName = moduleNameList[position]
        holder.binding.apply {
            (root.layoutParams as FlexboxLayoutManager.LayoutParams).flexGrow = 1.0f
            val prefs = MyApp.context.prefs()
            val moduleEnableOldList = prefs.get(SetPrefsData.MODULE_ENABLE_LIST)
            itemCbFuncStatus.text = moduleName
            itemCbFuncStatus.isChecked = moduleEnableOldList.contains(moduleName)
            itemCbFuncStatus.setOnClickListener {
                val newModuleEnableSet = if (itemCbFuncStatus.isChecked) {
                    prefs.get(SetPrefsData.MODULE_ENABLE_LIST) + moduleName
                } else {
                    prefs.get(SetPrefsData.MODULE_ENABLE_LIST) - moduleName
                }
                prefs.edit {
                    put(SetPrefsData.MODULE_ENABLE_LIST, newModuleEnableSet)
                }
            }
        }
    }
}