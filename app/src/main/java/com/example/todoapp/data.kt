package com.example.todoapp

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date

data class data(val id : Int, var title: String ,var created:  Date)

@RequiresApi(Build.VERSION_CODES.O)
fun faketodo(): List<data>{
    return  listOf<data>(data(1,"first to do " ,Date.from(Instant.now())),
        data(1,"first to do " ,Date.from(Instant.now()))
        ,data(1,"first to do " ,Date.from(Instant.now())),
        data(1,"first to do " ,Date.from(Instant.now())),
        data(1,"first to do " ,Date.from(Instant.now())))

}