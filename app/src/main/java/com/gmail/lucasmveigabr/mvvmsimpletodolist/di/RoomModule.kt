package com.gmail.lucasmveigabr.mvvmsimpletodolist.di

import android.content.Context
import androidx.room.Room
import com.gmail.lucasmveigabr.mvvmsimpletodolist.data.room.TaskDatabase
import dagger.Module
import dagger.Provides

@Module
class RoomModule {
    @Provides
    fun provideTaskDatabase(context: Context) =
        Room.databaseBuilder(context, TaskDatabase::class.java, "tasks.db").fallbackToDestructiveMigration().build()

    @Provides
    fun provideTaskDao(taskDatabase: TaskDatabase) =
            taskDatabase.taskDao()
}