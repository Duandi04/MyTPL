package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Profile(){
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = "Profile", fontSize = 20.sp)
        }
    }
}

//@Preview(showBackground = true, device = "id:Nexus S")
//@Composable
//fun PreviewProfileScreen() {
//    Profile()
//}