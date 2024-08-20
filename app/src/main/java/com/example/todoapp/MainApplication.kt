package com.example.todoapp

import android.app.Application
import androidx.room.Room
import com.example.todoapp.database.tododatabase

class MainApplication : Application() {
        companion object {
            lateinit var tododatabase: tododatabase
        }

    override fun onCreate() {
        super.onCreate()
        tododatabase = Room.databaseBuilder(applicationContext, tododatabase::class.java, "todo_db").build()
}}
