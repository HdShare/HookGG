package me.hd.hookgg.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexboxLayoutManager
import com.highcapable.yukihookapi.hook.factory.prefs
import me.hd.hookgg.MyApp
import me.hd.hookgg.data.SetPrefsData
import me.hd.hookgg.databinding.ItemRvFuncBinding

class FuncAdapter(
    private val funcList: List<String>
) : RecyclerView.Adapter<FuncAdapter.FuncViewHolder>() {

    class FuncViewHolder(val binding: ItemRvFuncBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount() = funcList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FuncViewHolder {
        val view = ItemRvFuncBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FuncViewHolder(view)
    }

    override fun onBindViewHolder(holder: FuncViewHolder, position: Int) {
        val prefs = MyApp.context.prefs()
        val funcName = funcList[position]
        holder.binding.apply {
            (root.layoutParams as FlexboxLayoutManager.LayoutParams).flexGrow = 1.0f
            itemCbFuncStatus.text = funcName
            itemCbFuncStatus.isChecked = prefs.get(SetPrefsData.FUNC_LIST).contains(funcName)
            itemCbFuncStatus.setOnClickListener {
                val newFuncSet = if (itemCbFuncStatus.isChecked) {
                    prefs.get(SetPrefsData.FUNC_LIST) + funcName
                } else {
                    prefs.get(SetPrefsData.FUNC_LIST) - funcName
                }
                prefs.edit {
                    put(SetPrefsData.FUNC_LIST, newFuncSet)
                }
            }
        }
    }
}