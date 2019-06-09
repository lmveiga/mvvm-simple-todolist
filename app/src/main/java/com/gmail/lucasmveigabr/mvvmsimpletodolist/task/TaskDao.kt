package com.gmail.lucasmveigabr.mvvmsimpletodolist.task

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {

    @Query("SELECT * FROM Task ORDER BY expirationDate")
    fun getTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM Task WHERE title LIKE '%'||:filter||'%' ORDER BY expirationDate")
    fun getTasks(filter: String): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: List<Task>)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

}