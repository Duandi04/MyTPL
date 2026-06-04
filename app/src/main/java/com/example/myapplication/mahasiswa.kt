package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.*

@Composable
fun Mahasiswa(){
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = "Mahasiswa", fontSize = 30.sp)
        }
    }
}