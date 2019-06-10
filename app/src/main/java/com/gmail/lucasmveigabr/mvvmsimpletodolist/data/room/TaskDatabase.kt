package com.gmail.lucasmveigabr.mvvmsimpletodolist.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gmail.lucasmveigabr.mvvmsimpletodolist.data.model.Task
import com.gmail.lucasmveigabr.mvvmsimpletodolist.data.room.converter.DateTypeConverter

@Database(version = 3, entities = [Task::class], exportSchema = false)
@TypeConverters(DateTypeConverter::class)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

}