package com.gmail.lucasmveigabr.mvvmsimpletodolist.task

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.gmail.lucasmveigabr.mvvmsimpletodolist.R
import com.gmail.lucasmveigabr.mvvmsimpletodolist.util.setColor
import java.text.SimpleDateFormat
import java.util.*


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

    inner class Holder(view: View, private val onClick: ((Task) -> Unit)?) : RecyclerView.ViewHolder(view) {

        private var text1: TextView
        private var text2: TextView
        private var cardView: CardView

        init {
            view.setOnClickListener {
                onClick?.invoke(tasks[adapterPosition])
            }

            text1 = view.findViewById(R.id.text1)
            text2 = view.findViewById(R.id.text2)
            cardView = view.findViewById(R.id.card_view)
        }

        fun bind(task: Task){
            text1.text = task.title
            text2.text =
                SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR")).format(task.expirationDate)
            if (task.expirationDate.time < Date().time) {
                text1.setColor(R.color.expiredGray, context)
                text2.setColor(R.color.expiredRed, context)
                cardView.setColor(R.color.expiredBackground, context)
            } else {
                text1.setColor(android.R.color.black, context)
                text2.setColor(android.R.color.black, context)
                cardView.setColor(android.R.color.white, context)
            }
        }

    }
}