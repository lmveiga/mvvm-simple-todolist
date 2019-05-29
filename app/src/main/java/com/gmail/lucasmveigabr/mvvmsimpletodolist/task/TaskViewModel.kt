package com.gmail.lucasmveigabr.mvvmsimpletodolist.task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.gmail.lucasmveigabr.mvvmsimpletodolist.app.App
import com.gmail.lucasmveigabr.mvvmsimpletodolist.util.SingleLiveEvent
import java.util.*
import javax.inject.Inject

class TaskViewModel : ViewModel(), TaskView {

    private val taskRepository: TaskRepository = App.appComponent.taskRepository()

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

    fun getDialogEvent() : LiveData<Unit> = dialogEvent
    fun getDeletedEvent() : LiveData<Task> = deletedEvent


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


    override fun addDialog(text: String) {
        val task = Task(null, text, Date())
        taskRepository.addTask(task)
    }


}