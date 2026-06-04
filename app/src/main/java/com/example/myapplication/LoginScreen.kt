package com.example.myapplication

import android.content.res.Resources.Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.*

@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginError by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val logoPainter: Painter = painterResource(id = R.drawable.ic_launcher_foreground) // replace with your logo drawable resource
        Image(
            painter = logoPainter,
            contentDescription = "Logo",
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 16.dp)
        )
        Text(
            text = "Welcome\nTo TPL",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )
        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
            },
            label = { Text("Username") },
            shape = RoundedCornerShape(26.dp),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = Blue1,
                unfocusedLeadingIconColor = Blue1,
                focusedLabelColor = Blue1,
                unfocusedLabelColor = Color.Gray,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Blue2,
                unfocusedIndicatorColor = Color.DarkGray,
                focusedPlaceholderColor = Color.Black,
            ),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Username", tint = Blue1)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 14.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(26.dp),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedLeadingIconColor = Blue1,
                unfocusedLeadingIconColor = Blue1,
                focusedLabelColor = Blue1,
                unfocusedLabelColor = Color.Gray,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Blue2,
                unfocusedIndicatorColor = Color.DarkGray,
                focusedPlaceholderColor = Color.Black,
            ),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Password", tint = Blue1)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 14.dp)
        )
        if (loginError) {
            Text(
                text = "Invalid username or password",
                color = Color.Red,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        Button(
            onClick = {
                if (password.isEmpty() || username.isEmpty()){
                    loginError = true
                }
                if (Authentication(username, password)) {
                    navController.navigate("home")
                } else {
                    loginError= true
                }
            },
            colors = ButtonDefaults.buttonColors(Blue1),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, start = 40.dp, end = 40.dp, bottom = 20.dp)
        ) {
            Text("Login")
        }
    }
}

private fun Authentication(username: String, password: String): Boolean{
    val validUsername = "admin"
    val validPassword = "admin"
    return username == validUsername && password == validPassword
}