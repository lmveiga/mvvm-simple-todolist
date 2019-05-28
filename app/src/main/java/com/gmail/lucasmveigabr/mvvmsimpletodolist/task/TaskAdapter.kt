package com.gmail.lucasmveigabr.mvvmsimpletodolist.task

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter(val context: Context): RecyclerView.Adapter<TaskAdapter.Holder>() {

    private var tasks: List<Task> = Collections.emptyList()

    fun setTasks(tasks: List<Task>){
        this.tasks = tasks
        notifyDataSetChanged()
    }

    fun getTask(pos: Int) = tasks[pos]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(tasks[position])
    }

    inner class Holder(private val view: View): RecyclerView.ViewHolder(view) {

        fun bind(task: Task){
            view.findViewById<TextView>(android.R.id.text1).text = task.title
            view.findViewById<TextView>(android.R.id.text2).text = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR")).format(task.date)
        }

    }
}