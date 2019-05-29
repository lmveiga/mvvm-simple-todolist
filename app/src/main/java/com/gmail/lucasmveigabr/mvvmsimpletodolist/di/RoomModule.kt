package com.gmail.lucasmveigabr.mvvmsimpletodolist.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gmail.lucasmveigabr.mvvmsimpletodolist.room.TaskDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Provides
    fun provideTaskDatabase(context: Context) =
        Room.databaseBuilder(context, TaskDatabase::class.java, "tasks.db").build()

    @Provides
    fun provideTaskDao(taskDatabase: TaskDatabase) =
            taskDatabase.taskDao()
}