package me.hd.hookgg.ui.adapter

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.hd.hookgg.config.data.BuildData
import me.hd.hookgg.databinding.ItemRvLogBinding
import java.io.FileOutputStream

@SuppressLint("NotifyDataSetChanged")
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
        logList.clear()
        notifyDataSetChanged()
    }

    fun addLog(log: String) {
        logList.add(log)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogViewHolder {
        val binding = ItemRvLogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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