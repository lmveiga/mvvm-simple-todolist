package com.gmail.lucasmveigabr.mvvmsimpletodolist.task

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    var title: String = "",
    val creationDate: Date
)