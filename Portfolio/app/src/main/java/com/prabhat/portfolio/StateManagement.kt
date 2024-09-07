package com.prabhat.portfolio

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun StateManagement(modifier: Modifier = Modifier) {

    var username=""
//    var state by mutableStateOf("")
    var state = remember {
        mutableStateOf("")
    }
    TextField(value = state.value , onValueChange ={
        state.value=it

    } )
}