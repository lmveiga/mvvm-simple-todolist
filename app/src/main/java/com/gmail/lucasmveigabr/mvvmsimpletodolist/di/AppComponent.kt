package com.gmail.lucasmveigabr.mvvmsimpletodolist.di

import android.content.Context
import com.gmail.lucasmveigabr.mvvmsimpletodolist.data.repo.TaskRepository
import com.gmail.lucasmveigabr.mvvmsimpletodolist.data.room.TaskDao
import dagger.Component

@Component(modules = [ContextModule::class, RoomModule::class])
interface AppComponent {

    fun taskDao(): TaskDao
    fun appContext(): Context
    fun taskRepository(): TaskRepository

}