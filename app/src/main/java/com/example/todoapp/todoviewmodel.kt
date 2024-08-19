package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import java.time.Instant
import java.util.Date

class todoviewmodel: ViewModel() {
    val tododao = MainApplication.tododatabase.todoDao()

    val todolist : LiveData<List<data>> = tododao.getalldata()

        fun getalltodo(){
        tododao.getalldata()
        }

        fun addtodo(title:String){
            tododao.addtodo(data(title = title, created = Date.from(Instant.now())))
        }
        fun deletetodo(id:Int){
           tododao.deletetodo(id)
        }

}