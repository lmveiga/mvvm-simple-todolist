package com.gmail.lucasmveigabr.mvvmsimpletodolist.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    var title: String = "",
    val creationDate: Date,
    val expirationDate: Date
)