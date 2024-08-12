package me.hd.hookgg.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.highcapable.yukihookapi.hook.factory.prefs
import me.hd.hookgg.MyApp
import me.hd.hookgg.data.SetPrefsData
import me.hd.hookgg.databinding.ItemRvModuleBinding
import me.hd.hookgg.hook.module.DemoModule

class ModuleAdapter : RecyclerView.Adapter<ModuleAdapter.ModuleViewHolder>() {
    private val moduleNameList = DemoModule.moduleNameList

    class ModuleViewHolder(val binding: ItemRvModuleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount() = moduleNameList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val view = ItemRvModuleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModuleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        val moduleName = moduleNameList[position]
        holder.binding.apply {
            itemTvModuleName.text = moduleName
            val prefs = MyApp.context.prefs()
            val moduleEnableOldList = prefs.get(SetPrefsData.MODULE_ENABLE_LIST)
            itemCbModuleStatus.isChecked = moduleEnableOldList.contains(moduleName)
            itemCbModuleStatus.setOnClickListener {
                val newModuleEnableSet = if (itemCbModuleStatus.isChecked) {
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