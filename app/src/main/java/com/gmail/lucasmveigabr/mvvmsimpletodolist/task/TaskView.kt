package com.gmail.lucasmveigabr.mvvmsimpletodolist.task

interface TaskView {
    fun addButtonClick()
    fun recyclerItemSwipe(task: Task)
    fun searchChange(search: String)
    fun recyclerItemClick(task: Task)
    fun addDialog(text: String, dayOfMonth: Int, month: Int, year: Int)
    fun undoSnackbarClick(task: Task)
}