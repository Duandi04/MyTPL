package com.example.myapplication

import android.graphics.BlurMaskFilter.Blur
import android.icu.text.ListFormatter.Width
import android.media.Image
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.example.myapplication.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val homeNavController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext

    val selected = remember{
        mutableStateOf(Icons.Default.Home)
    }

    val drawerSelection = remember { mutableStateOf("") }


    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet{

                Box(modifier = Modifier
                    .background(Purple40)
                    .height(70.dp)
                    .fillMaxWidth()
                )
                Divider()
                NavigationDrawerItem(
                    label = {Text(text = "Home")},
                    selected = false,
                    icon = {Icon(imageVector = Icons.Default.Home, contentDescription = "home")},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        homeNavController.navigate(Screens.Home.screens){
                            popUpTo(0)
                        }
                        selected.value = Icons.Default.Home
                        drawerSelection.value = "Home"
                    }
                )

                NavigationDrawerItem(
                    label = {Text(text = "Profile")},
                    selected = false,
                    icon = {Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "profile")},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        homeNavController.navigate(Screens.Profile.screens){
                            popUpTo(0)
                        }
                        selected.value = Icons.Default.AccountCircle
                        drawerSelection.value = "Profile"
                    }
                )


                NavigationDrawerItem(
                    label = {Text(text = "Mahasiswa")},
                    selected = false,
                    icon = {Icon(imageVector = Icons.Default.Person, contentDescription = "mahasiswa")},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        homeNavController.navigate(Screens.Mahasiswa.screens){
                            popUpTo(0)
                        }
                        drawerSelection.value = "Mahasiswa"
                        selected.value = Icons.Default.Person
                    }

                )

                NavigationDrawerItem(
                    label = {Text(text = "Dosen")},
                    selected = false,
                    icon = {Icon(imageVector = Icons.Default.Person, contentDescription = "dosen")},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        homeNavController.navigate(Screens.Dosen.screens){
                            popUpTo(0)
                        }
                        drawerSelection.value = "Dosen"
                        selected.value = Icons.Default.Person
                    }
                )

                NavigationDrawerItem(
                    label = {Text(text = "Agenda")},
                    selected = false,
                    icon = {Icon(imageVector = Icons.Default.DateRange, contentDescription = "agenda")},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        homeNavController.navigate(Screens.Agenda.screens){
                            popUpTo(0)
                        }
                        selected.value = Icons.Default.DateRange
                        drawerSelection.value = "Agenda"
                    }
                )

                NavigationDrawerItem(
                    label = {Text(text = "Logout")},
                    selected = false,
                    icon = {Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "logout")},
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context, "Logout From App", Toast.LENGTH_SHORT).show()
                        selected.value = Icons.Default.ExitToApp
                        drawerSelection.value = "Logout"
                    }
                )
            }
        }
    )
    {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar(
                    title = { Text("TPL") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Purple40,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                Icons.Rounded.Menu, contentDescription = "MenuButton"
                            )
                        }
                    },
                )
            },
            bottomBar = {
                BottomAppBar(containerColor = Purple40){
                    IconButton(onClick = {
                        selected.value = Icons.Default.Home
                        drawerSelection.value = "Home"
                        homeNavController.navigate(Screens.Home.screens){
                            popUpTo(0)
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(Icons.Default.Home,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.Home || drawerSelection.value == "Home") Color.White else Color.DarkGray
                            )
                        Text(
                            text = "Home",
                            color = if (selected.value == Icons.Default.Home || drawerSelection.value == "Home") Color.White else Color.DarkGray,
                        )
                    }

                    IconButton(onClick = {
                        selected.value = Icons.Default.DateRange
                        drawerSelection.value = "Agenda"
                        homeNavController.navigate(Screens.Agenda.screens){
                            popUpTo(0)
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(Icons.Default.DateRange,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.DateRange || drawerSelection.value == "Agenda") Color.White else Color.DarkGray
                        )
                        Text(
                            text = "Agenda",
                            color = if (selected.value == Icons.Default.DateRange || drawerSelection.value == "Agenda") Color.White else Color.DarkGray,
                        )
                    }

                    IconButton(onClick = {
                        selected.value = Icons.Default.AccountCircle
                        drawerSelection.value = "Profile"
                        homeNavController.navigate(Screens.Profile.screens){
                            popUpTo(0)
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(Icons.Default.AccountCircle,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.AccountCircle || drawerSelection.value == "Profile") Color.White else Color.DarkGray
                        )
                        Text(
                            text = "Profile",
                            color = if (selected.value == Icons.Default.AccountCircle || drawerSelection.value == "Profile") Color.White else Color.DarkGray,
                        )
                    }
                }
            }
        ) {
            NavHost(
                navController = homeNavController,
                startDestination = Screens.Home.screens,
                modifier = Modifier.padding(it)  // Add padding for content inside Scaffold
            ) {
                composable(Screens.Home.screens) { Home() }
                composable(Screens.Agenda.screens) { Agenda() }
                composable(Screens.Mahasiswa.screens) { Mahasiswa() }
                composable(Screens.Dosen.screens) { Dosen() }
                composable(Screens.Profile.screens) { Profile() }

            }
        }

    }
}