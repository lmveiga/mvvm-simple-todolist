package com.gmail.lucasmveigabr.mvvmsimpletodolist.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.gmail.lucasmveigabr.mvvmsimpletodolist.task.Task
import com.gmail.lucasmveigabr.mvvmsimpletodolist.task.TaskDao

@Database(version = 1, entities = [Task::class], exportSchema = false)
@TypeConverters(DateTypeConverter::class)
public abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

}