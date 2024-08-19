package com.example.todoapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todoapp.data

@Dao
interface dao {


    @Query("SELECT * FROM data")
    fun getalldata(): LiveData<List<data>>

    @Insert
    fun addtodo(data: data)
    @Query("DELETE FROM data WHERE id = :id")
    fun deletetodo(id: Int)
}