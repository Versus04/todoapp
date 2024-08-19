package com.example.todoapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
@Entity
data class data(@PrimaryKey(autoGenerate = true) val id: Int =  0, var title: String,
                var created: Date
)

