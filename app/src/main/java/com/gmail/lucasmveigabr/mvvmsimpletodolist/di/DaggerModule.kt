package com.gmail.lucasmveigabr.mvvmsimpletodolist.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gmail.lucasmveigabr.mvvmsimpletodolist.room.TaskDatabase
import javax.inject.Singleton

public class DaggerModule {

    @Singleton
    fun provideTaskDatabase(context: Context) =
        Room.databaseBuilder(context, TaskDatabase::class.java, "tasks.db").build()

}