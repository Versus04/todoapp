package com.example.todoapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.Instant
import java.util.Date


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun todolistpage(modifier: Modifier ){
    val todolist = faketodo()
    Column(modifier) {
        LazyColumn(Modifier.padding(8.dp)){
            itemsIndexed(todolist){ index , todos->
                todoitem(item = todos)

            }

        }
    }
}


@Composable
fun todoitem(item: data){
    Row(Modifier.fillMaxWidth().padding(8.dp).clip(RoundedCornerShape(8.dp)).background(MaterialTheme.colorScheme.primary) , horizontalArrangement = Arrangement.SpaceBetween) {
        Column(Modifier.padding(8.dp)){
            Text(text =item.created.toString() , fontSize = 5.sp)
            Text(text = item.title , fontSize = 15.sp)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun prev(){
    todoitem(item = data(1,"first to do " , Date.from(Instant.now())))
}