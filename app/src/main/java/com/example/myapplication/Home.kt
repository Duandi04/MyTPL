package com.example.myapplication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*

@Composable
fun Home(){
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.Center)
            .padding(20.dp)
            .fillMaxWidth())
            {
                OutlinedCard(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    border = BorderStroke(1.dp, Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(13.dp)
                ) {
                    Row {
                        val logoPainter: Painter = painterResource(id = R.drawable.ic_launcher_foreground)
                        Image(painter = logoPainter, contentDescription = "Profile")

                        Column ( modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 5.dp),
                            verticalArrangement = Arrangement.Center){
                            Text(text = "Welcome, Duandi!")
                            Row {
                                Text(text = "Nim")
                                Text(text = " : ")
                                Text(text = "2022133012")
                            }
                            Row {
                                Text(text = "Angkatan")
                                Text(text = " : ")
                                Text(text = "2022")
                            }
                        }
                    }
                }
            }
    }
}