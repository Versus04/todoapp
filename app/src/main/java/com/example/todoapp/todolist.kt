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
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Date
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun todolistpage(modifier: Modifier , viewModel: todoviewmodel ){
    val todolist by viewModel.todolist.observeAsState()
    var text by remember {
        mutableStateOf("")
    }
    Column(modifier) {

        todolist?.let {
            LazyColumn(
                Modifier
                    .padding(8.dp)
                    .weight(1f)){
                itemsIndexed(it){ index , todos->
                    todoitem(item = todos ,viewModel.deletetodo(todos.id))

                }

            }
        }?: Text( modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center , text = "The todo List is Empty")

        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp) , verticalAlignment = Alignment.Bottom , horizontalArrangement = Arrangement.SpaceEvenly) {
            OutlinedTextField(value = text, onValueChange = {text = it})
            IconButton(onClick = { viewModel.addtodo(text)
            text=""
            }) {
                Icon(imageVector = Icons.Default.Send, contentDescription ="Add to list" )
            }
        }
    }
}


@Composable
fun todoitem(item: data , onclick:Unit){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.primary) , horizontalArrangement = Arrangement.SpaceBetween , verticalAlignment = Alignment.CenterVertically) {
        Column(Modifier.padding(8.dp)){
            Text(text = SimpleDateFormat("HH:mm:aa , d/m" , Locale.ENGLISH).format(item.created), fontSize = 15.sp , color = Color.LightGray)
            Text(text = item.title , fontSize = 15.sp, color = Color.White)
        }
        IconButton(onClick = {onclick }) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = null , tint = Color.White)
            
        }
    }
}
    