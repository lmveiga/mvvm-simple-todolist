package com.gmail.lucasmveigabr.mvvmsimpletodolist.task

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class TaskRepository @Inject constructor(private val taskDao: TaskDao) {

    fun getTasks() = taskDao.getTasks()

    fun getTasks(filter: String) = taskDao.getTasks(filter)

    fun addTask(task: Task) = GlobalScope.launch{ taskDao.insert(task) }

    fun addTask(taskList: List<Task>) = GlobalScope.launch { taskDao.insert(taskList) }

    fun deleteTask(task: Task) = GlobalScope.launch{ taskDao.delete(task) }

    fun updateTask(task: Task) = GlobalScope.launch{ taskDao.update(task) }

}