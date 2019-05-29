package com.gmail.lucasmveigabr.mvvmsimpletodolist.di

import android.content.Context
import com.gmail.lucasmveigabr.mvvmsimpletodolist.app.App
import com.gmail.lucasmveigabr.mvvmsimpletodolist.task.TaskAdapter
import com.gmail.lucasmveigabr.mvvmsimpletodolist.task.TaskDao
import com.gmail.lucasmveigabr.mvvmsimpletodolist.task.TaskFragment
import com.gmail.lucasmveigabr.mvvmsimpletodolist.task.TaskRepository
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ContextModule::class, RoomModule::class])
interface AppComponent {

    fun taskDao(): TaskDao
    fun appContext(): Context
    fun taskRepository(): TaskRepository

}