package me.hd.hookgg.ui.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.hd.hookgg.data.app.BuildData
import me.hd.hookgg.databinding.ItemRvLogBinding
import java.io.FileOutputStream

class LogAdapter : RecyclerView.Adapter<LogAdapter.LogViewHolder>() {
    private var logList = mutableListOf<String>()

    fun copyLog(context: Context) {
        val logStr = logList.joinToString("\n")
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText(BuildData.TAG, logStr)
        clipboard.setPrimaryClip(clip)
    }

    fun outLog(outputStream: FileOutputStream) {
        val logStr = logList.joinToString("\n")
        outputStream.write(logStr.toByteArray())
    }

    fun clearLog() {
        val count = logList.size
        logList.clear()
        notifyItemRangeRemoved(0, count)
    }

    fun addLog(log: String) {
        val pos = logList.size
        logList.add(log)
        notifyItemInserted(pos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogViewHolder {
        val binding = ItemRvLogBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LogViewHolder, position: Int) {
        val logText = logList[position].replace("\u0000", "")
        holder.tvLog.text = logText
    }

    override fun getItemCount(): Int = logList.size

    class LogViewHolder(binding: ItemRvLogBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvLog = binding.itemRvTvLog
    }
}