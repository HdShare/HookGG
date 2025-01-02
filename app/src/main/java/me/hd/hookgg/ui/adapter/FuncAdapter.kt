package me.hd.hookgg.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.highcapable.yukihookapi.hook.factory.prefs
import com.highcapable.yukihookapi.hook.xposed.prefs.YukiHookPrefsBridge
import me.hd.hookgg.MyApp
import me.hd.hookgg.R
import me.hd.hookgg.data.app.SetPrefsData
import me.hd.hookgg.data.bean.FuncObj
import me.hd.hookgg.databinding.ItemRvFuncBinding

class FuncAdapter(
    private val funcObjList: List<FuncObj>
) : RecyclerView.Adapter<FuncAdapter.FuncViewHolder>() {

    class FuncViewHolder(val binding: ItemRvFuncBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount() = funcObjList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FuncViewHolder {
        val view = ItemRvFuncBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FuncViewHolder(view)
    }

    private fun updateFuncSet(prefs: YukiHookPrefsBridge, funcName: String, add: Boolean) {
        val funcSet = prefs.get(SetPrefsData.FUNC_LIST)
        val newFuncSet = if (add) {
            funcSet + funcName
        } else {
            funcSet - funcName
        }
        prefs.edit {
            put(SetPrefsData.FUNC_LIST, newFuncSet)
        }
    }

    override fun onBindViewHolder(holder: FuncViewHolder, position: Int) {
        val prefs = MyApp.context.prefs()
        val funcObj = funcObjList[position]
        val funcSet = prefs.get(SetPrefsData.FUNC_LIST)
        holder.binding.apply {
            itemCbFuncStatus.text = funcObj.funcName
            itemCbFuncStatus.isChecked = funcSet.contains(funcObj.funcName)
            itemCbFuncStatus.setOnClickListener {
                if (itemCbFuncStatus.isChecked && funcObj.funcDetail.isWarning) {
                    MaterialAlertDialogBuilder(itemCbFuncStatus.context)
                        .setTitle(R.string.dialog_warning)
                        .setMessage(R.string.dialog_warning_message)
                        .setPositiveButton(R.string.dialog_continue) { _, _ ->
                            updateFuncSet(prefs, funcObj.funcName, true)
                        }
                        .setNegativeButton(R.string.dialog_cancel) { _, _ ->
                            itemCbFuncStatus.isChecked = false
                        }
                        .show()
                } else {
                    updateFuncSet(prefs, funcObj.funcName, itemCbFuncStatus.isChecked)
                }
            }
            itemCbFuncStatus.setBackgroundResource(
                if (funcObj.funcDetail.isWarning) R.drawable.checkbox_func_warning else R.drawable.checkbox_func_default
            )
        }
    }
}