package com.example.myapplication

sealed class Screens (val screens: String){
    data object Home: Screens("home")
    data object Profile: Screens("profile")
    data object Mahasiswa: Screens("mahasiswa")
    data object Dosen: Screens("dosen")
    data object Agenda: Screens("agenda")
}
