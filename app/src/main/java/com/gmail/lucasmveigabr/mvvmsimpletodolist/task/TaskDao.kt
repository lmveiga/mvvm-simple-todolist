package com.gmail.lucasmveigabr.mvvmsimpletodolist.task

import androidx.room.*

@Dao
interface TaskDao {

    @Query("SELECT * FROM Task ORDER BY date DESC")
    fun getTasks(): List<Task>

    @Query("SELECT * FROM Task WHERE title LIKE '%'||:filter||'%' OR description LIKE '%'||:filter||'%'")
    fun getTasks(filter: String): List<Task>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(task: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(task: List<Task>)

    @Delete
    fun delete(task: Task)

}