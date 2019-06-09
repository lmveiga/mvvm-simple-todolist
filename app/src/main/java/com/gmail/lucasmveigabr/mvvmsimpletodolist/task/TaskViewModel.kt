package com.gmail.lucasmveigabr.mvvmsimpletodolist.task

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.gmail.lucasmveigabr.mvvmsimpletodolist.R
import com.gmail.lucasmveigabr.mvvmsimpletodolist.app.App
import com.gmail.lucasmveigabr.mvvmsimpletodolist.util.SingleLiveEvent
import java.util.*

class TaskViewModel : ViewModel(), TaskView {

    private val taskRepository: TaskRepository = App.appComponent.taskRepository()
    private val appContext: Context = App.appComponent.appContext()

    private val query = MutableLiveData<String>()

    private val tasks = Transformations.switchMap(query){q ->
        if (q.isNullOrBlank()){
            taskRepository.getTasks()
        } else {
            taskRepository.getTasks(q)
        }
    }

    fun getTasks(): LiveData<List<Task>>{
        if (query.value == null) query.value = ""
        return tasks
    }

    private val dialogEvent = SingleLiveEvent<Unit>()
    private val deletedEvent = SingleLiveEvent<Task>()
    private val displayError = SingleLiveEvent<String>()

    fun getDialogEvent() : LiveData<Unit> = dialogEvent
    fun getDeletedEvent() : LiveData<Task> = deletedEvent
    fun getDisplayErrorEvent(): LiveData<String> = displayError

    override fun addButtonClick() {
        dialogEvent.call()
    }

    override fun recyclerItemSwipe(task: Task) {
        taskRepository.deleteTask(task)
        deletedEvent.value = task
    }

    override fun searchChange(search: String) {
        if (query.value != search){
            query.value = search
        }
    }

    override fun recyclerItemClick(task: Task) {

    }

    override fun undoSnackbarClick(task: Task) {
        taskRepository.addTask(task)
    }


    override fun addDialog(text: String, dayOfMonth: Int, month: Int, year: Int) {
        if (text.isBlank()) {
            displayError.value = appContext.getString(R.string.empty_task_error)
            return
        }
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.YEAR, year)
        val task = Task(null, text, Date(), Date(calendar.timeInMillis))
        taskRepository.addTask(task)
    }


}