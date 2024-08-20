package com.example.todoapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.todoapp.converter
import com.example.todoapp.data

@Database(entities = [data::class] , version = 1)
@TypeConverters(converter::class)
abstract class tododatabase : RoomDatabase(){



    companion object{
         val NAME : String = "todo_db"

    }

    abstract fun todoDao() : dao


}