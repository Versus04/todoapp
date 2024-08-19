package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class todoviewmodel: ViewModel() {
 private var _todolist= MutableLiveData<List<data>>()
    val todolist : LiveData<List<data>> = _todolist
    init {
        _todolist.value = todomanager.getalltodo()
    }
        fun getalltodo(){
        _todolist.value=todomanager.getalltodo()
        }

        fun addtodo(title:String){
            todomanager.addtodo(title)
        }
        fun deletetodo(id:Int){
            todomanager.deletetodo(id)
            todomanager.getalltodo()
        }

}