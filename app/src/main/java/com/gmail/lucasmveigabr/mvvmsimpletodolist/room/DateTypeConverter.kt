package com.gmail.lucasmveigabr.mvvmsimpletodolist.room

import androidx.room.TypeConverter
import java.util.*

public class DateTypeConverter {

    companion object{
        @TypeConverter @JvmStatic
        public fun toDate(value: Long): Date{
            return Date(value)
        }

        @TypeConverter @JvmStatic
        public fun toLong(value: Date): Long{
            return value.time
        }
    }


}