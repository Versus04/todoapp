package com.example.todoapp

import androidx.room.TypeConverter
import java.time.Instant
import java.util.Date

class converter {

    @TypeConverter
    fun fromdate(date: Date): Long{

        return date.time
    }
    @TypeConverter
    fun todate(time: Long): Date{
        return Date(time)
    }
}