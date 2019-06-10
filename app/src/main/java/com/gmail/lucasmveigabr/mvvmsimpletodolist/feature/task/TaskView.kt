package com.gmail.lucasmveigabr.mvvmsimpletodolist.feature.task

import com.gmail.lucasmveigabr.mvvmsimpletodolist.data.model.Task

interface TaskView {
    fun addButtonClick()
    fun recyclerItemSwipe(task: Task)
    fun searchChange(search: String)
    fun recyclerItemClick(task: Task)
    fun addDialog(text: String, dayOfMonth: Int, month: Int, year: Int)
    fun undoSnackbarClick(task: Task)
    fun deleteTaskClick(task: Task)
}