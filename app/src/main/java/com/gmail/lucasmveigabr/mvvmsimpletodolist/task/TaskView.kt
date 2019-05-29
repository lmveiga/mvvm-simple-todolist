package com.gmail.lucasmveigabr.mvvmsimpletodolist.task

interface TaskView {
    fun addButtonClick()
    fun recyclerItemSwipe(task: Task)
    fun searchChange(search: String)
    fun recyclerItemClick(task: Task)
    fun addDialog(text: String)
    fun undoSnackbarClick(task: Task)
}