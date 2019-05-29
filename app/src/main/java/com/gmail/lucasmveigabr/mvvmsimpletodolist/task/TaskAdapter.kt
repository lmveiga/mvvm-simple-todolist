package com.gmail.lucasmveigabr.mvvmsimpletodolist.task

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gmail.lucasmveigabr.mvvmsimpletodolist.R
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class TaskAdapter constructor(val context: Context, val onItemClick: ((Task) -> Unit)): RecyclerView.Adapter<TaskAdapter.Holder>() {

    private var tasks: List<Task> = Collections.emptyList()


    fun setTasks(tasks: List<Task>){
        this.tasks = tasks
        notifyDataSetChanged()
    }

    fun getTask(pos: Int) = tasks[pos]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.task_view_holder, parent, false)
        return Holder(view, onItemClick)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(tasks[position])
    }

    inner class Holder(private val view: View, private val onClick: ((Task) -> Unit)?): RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener {
                onClick?.invoke(tasks[adapterPosition])
            }
        }

        fun bind(task: Task){
            view.findViewById<TextView>(android.R.id.text1).text = task.title
            view.findViewById<TextView>(android.R.id.text2).text =
                SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR")).format(task.creationDate)
        }

    }
}