package com.gmail.lucasmveigabr.mvvmsimpletodolist.data.room.converter

import androidx.room.TypeConverter
import java.util.*

class DateTypeConverter {

    companion object{
        @TypeConverter @JvmStatic
        fun toDate(value: Long): Date {
            return Date(value)
        }

        @TypeConverter @JvmStatic
        fun toLong(value: Date): Long {
            return value.time
        }
    }


}