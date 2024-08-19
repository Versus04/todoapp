package com.example.todoapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import java.time.Instant
import java.util.Date

object todomanager {
private val todolist = mutableListOf<data>()
    fun getalltodo(): List<data>{
        return todolist
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addtodo(title: String){
        todolist.add(data(System.currentTimeMillis().toInt(),title,Date.from(Instant.now())))
        getalltodo()
    }
    fun deletetodo(id: Int){
        todolist.removeIf{it.id == id}
    }

}